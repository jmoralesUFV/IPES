package ufv.dis.final2022.JMI;


import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@Component
public class ClassController {

    private Agenda agendaIPs;

    private final String urlI = "/IPs";
    private final String urlB = "/IPB";
    private final String urlBn = "/IPBn";


    public ClassController()
    {
        this.agendaIPs = new Agenda();

        boolean flag = false;
        if(flag) {
            throw new NullPointerException();
        }

    }

    /*
        Llamada a la raíz por ver si está colgada la API.
    */

    @GetMapping("/")
    public String saludar() {
        // ---
        return "Esto se ha colgado !!";
    }

    /*
        -------------------------------------------------
        CJTO DE FUNCIONES PARA EL LLAMAMIENTO DE IPs
        -------------------------------------------------
    */

    // Para evitar consumir mucho tiempo, solo llamamos a los GET por ver si se recibe.
    // Tanto las listas completas como solo un elemento.

    @GetMapping(urlI+"/{id}")
    public IPs getUserByIdREST(@PathVariable int id) {
        //
        return this.agendaIPs.getIPById(id);
    }

    @GetMapping(urlI)
    public ArrayList<IPs> getAllUsers() {
        //
        return this.agendaIPs.getAllIPs();
    }

    /*
        -------------------------------------------------
            CJTO DE FUNCIONES PARA EL LLAMAMIENTO DE BÚSQUEDAS DE IPs
        -------------------------------------------------
    */

    @GetMapping(urlBn)
    public ArrayList<IPnoENCONTRADA> getIPNoEncontradas() {

        ArrayList<IPnoENCONTRADA> IPNOENCON = this.agendaIPs.getAllIPsNoEncontrada();

        String json = new Gson().toJson(IPNOENCON);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("IPsNoEncontradas.json"))) {
            bw.write(json);
            System.out.println("Fichero creado\n ------------ \n");
        } catch (IOException ex) {
            System.out.println("No ha sido posible crear el archivo.");
        }

        return this.agendaIPs.getAllIPsNoEncontrada();
    }



    @GetMapping(urlB)
    public ArrayList<busquedasIP> getAllEncontradas() {
        //Primero guardamos en un json y luego lo imprimimos al usuario.

        ArrayList<busquedasIP> IPENCON = this.agendaIPs.getAllIPsBuscadas();

        String json = new Gson().toJson(IPENCON);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("IPsEncontradas.json"))) {
            bw.write(json);
            System.out.println("Fichero creado\n ------------ \n");
        } catch (IOException ex) {
            System.out.println("No ha sido posible crear el archivo.");
        }

        return this.agendaIPs.getAllIPsBuscadas();
    }
    /*
    @GetMapping(urlBn)
    public ArrayList<IPnoENCONTRADA> getAllNoEncontradas() {
        //
        return this.agendaIPs.getAllIPsNoEncontrada();
    }
*/
    @PostMapping(urlB)
    public String buscarIP(@RequestBody ObjetoBuscarIP c) {

        JsonReader json = new JsonReader();
        ArrayList<IPs> ListaIP = json.leerIPs();

        // Probamos a guardarlo en algún lugar que sea externo...
        String delObjetoRecibido = String.valueOf(c.getIp());
        long iptrans = json.Dot2LongIP(delObjetoRecibido);

        // this.agendaIPs.addIPBuscadas();

        busquedasIP pruebaDevolver = new busquedasIP();
        IPnoENCONTRADA listaEFES = new IPnoENCONTRADA();

        Boolean ejem = false;

        for(int i = 0; i < ListaIP.size(); i++) {
            // Que esa IP pertenezca a ese rango
            if ((ListaIP.get(i).getIp_from() <= iptrans) && (ListaIP.get(i).getIp_to() >= iptrans)) {
                ejem = true;
                pruebaDevolver.setIP(iptrans);
                pruebaDevolver.setCountry_code(ListaIP.get(i).getCountry_code());
                pruebaDevolver.setRegion_name(ListaIP.get(i).getRegion_name());
                pruebaDevolver.setCity_name(ListaIP.get(i).getCity_name());
                pruebaDevolver.setZip_code(ListaIP.get(i).getZip_code());
                pruebaDevolver.setTime_zone(ListaIP.get(i).getTime_zone());

                this.agendaIPs.addIPBuscadas(pruebaDevolver);
                String devolver = new Gson().toJson(pruebaDevolver);
                return devolver;

            }
        }

        if(ejem == false){

            listaEFES.setIP(iptrans);
            listaEFES.setMensaje("IP no encontrada.");

            this.agendaIPs.addIPNoEncontrada(listaEFES);

            String devolver = new Gson().toJson(listaEFES);
            return devolver;
        }

        /*

        if(ejem == true)
        {
            pruebaDevolver.setIP(iptrans);
            pruebaDevolver.setZip_code(delObjetoRecibido);
            pruebaDevolver.setTime_zone("+01:00");
            pruebaDevolver.setCity_name("Madrid");
            pruebaDevolver.setCountry_code("28224");
            pruebaDevolver.setCountry_code("ES");
            pruebaDevolver.setRegion_name("Comunidad de Madrid");
        }
        else
        {
            pruebaDevolver.setZip_code(delObjetoRecibido);
            pruebaDevolver.setTime_zone("+01:00");
            pruebaDevolver.setCity_name("Pozuelo");
            pruebaDevolver.setCountry_code("28224");
            pruebaDevolver.setCountry_code("ES");
            pruebaDevolver.setRegion_name("Comunidad de Madrid");
        }
        */

        // Devolver el contacto creado (Buena práctica)
        return "-";
    }
/*
    @PostMapping(urlB)
    public ObjetoBuscarIP imprimirIP(@RequestBody ObjetoBuscarIP c) {

        // Recoger el contacto del request

        // Guardo el contacto
        // this.agendaU.addUser(c);

        // Devolver el contacto creado (Buena práctica)
        return (c);
    }
*/

    /*
    public static String longToIp(long ip) {
        StringBuilder result = new StringBuilder(15);
        for (int i = 0; i < 4; i++) {
            result.insert(0, Long.toString(ip & 0xff));
            if (i < 3) {
                result.insert(0, '.');
            }
            ip = ip >> 8;
        }
        return result.toString();
        //192.168.1.2 -> 3232235778
    }

    public static Long Dot2LongIP(String dottedIP) {
        String[] addrArray = dottedIP.split("\\.");
        long num = 0;
        for (int i=0;i<addrArray.length;i++) {
            int power = 3-i;
            num += ((Integer.parseInt(addrArray[i]) % 256) * Math.pow(256,power));
        }
        return num;
    }
    */

}
