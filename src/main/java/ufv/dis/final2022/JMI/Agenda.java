package ufv.dis.final2022.JMI;

import java.util.ArrayList;


/*
    Clase Agenda

    Clase que hace de gestor y control de las estructuras de datos que manejamos mediante clases.
    Instancia mediante arraylists las diferentes clases de manera que tenemos una lista de equipos, usuarios y préstamos.

    Contiene las funciones elementales del procesamiento de una API-Rest como introducir nuevos datos, consultarlos,
    modificarlos o eliminarlos.

*/

public class Agenda {

    // Instanciamos un ArrayList para las direcciones IP y mandamos al JSON reader a que nos lea ese archivo.
    private ArrayList<IPs> ListaIP;
    private ArrayList<busquedasIP> IPsEncontradas;
    private ArrayList<IPnoENCONTRADA> IPsNoEncontradas;

    private ObjetoBuscarIP IPaBuscar;

    public JsonReader Json = new JsonReader();

    public Agenda()
    {
        this.ListaIP = Json.leerIPs();
        this.IPsEncontradas = new ArrayList<busquedasIP>(500);
        this.IPsNoEncontradas = new ArrayList<IPnoENCONTRADA>(500);
        this.IPaBuscar = new ObjetoBuscarIP("150.244.0.0");
    }

    /*
        -------------------------------------------------
        CJTO DE FUNCIONES PARA EL TRATAMIENTO DE IPs
        -------------------------------------------------
    */

    public Boolean addIP(IPs U)
    {
        Boolean añadido=this.ListaIP.add(U);
        return añadido;
    }

    public ArrayList<IPs> getAllIPs()
    {
        return this.ListaIP;
    }

    public IPs getIPById(int id)
    {
        return this.ListaIP.get(id);
    }

    public IPs removeIPById(int id)
    {
        return this.ListaIP.remove(id);
    }

    // Por las necesidades del momento no lo implementamos.
    /*
    public IPs updateIPByIP(int id, IPs newIP) {

        this.ListaIP.get(id).setNombre(newContact.getNombre());
        this.ListaIP.get(id).setDepartamento(newContact.getDepartamento());
        this.ListaIP.get(id).setTlf(newContact.getTlf());
        this.ListaIP.get(id).setEmailContact(newContact.getEmailContact());
        this.ListaIP.get(id).setUbicacion(newContact.getUbicacion());

        return newIP;
    }
    */

    /*
        -------------------------------------------------
            CJTO DE FUNCIONES PARA EL LLAMAMIENTO DE BÚSQUEDAS DE IPs
        -------------------------------------------------
    */

    public ObjetoBuscarIP getObjetoBusqueda(){
        return this.IPaBuscar;
    }

    /*
        -------------------------------------------------
        CJTO DE FUNCIONES PARA EL TRATAMIENTO DE BÚSQUEDAS DE IPS.
        -------------------------------------------------
    */


    public Boolean addIPBuscadas(busquedasIP o)
    {
        Boolean añadido=this.IPsEncontradas.add(o);
        return añadido;
    }

    public ArrayList<busquedasIP> getAllIPsBuscadas()
    {
        return this.IPsEncontradas;
    }

    public busquedasIP getIPByIdBuscada(int id)
    {
        return this.IPsEncontradas.get(id);
    }

    /*
        -------------------------------------------------
        CJTO DE FUNCIONES PARA EL TRATAMIENTO DE BÚSQUEDAS DE IPS no encontradas.
        -------------------------------------------------
    */

    public Boolean addIPNoEncontrada(IPnoENCONTRADA o)
    {
        Boolean añadido=this.IPsNoEncontradas.add(o);
        return añadido;
    }

    public ArrayList<IPnoENCONTRADA> getAllIPsNoEncontrada()
    {
        return this.IPsNoEncontradas;
    }

}
