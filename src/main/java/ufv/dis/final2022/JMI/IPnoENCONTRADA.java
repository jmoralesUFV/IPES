package ufv.dis.final2022.JMI;

public class IPnoENCONTRADA {

    private long IP;
    private String Mensaje;

    public IPnoENCONTRADA() {

    }

    public IPnoENCONTRADA(long IP, String mensaje) {
        this.IP = IP;
        Mensaje = mensaje;
    }

    public long getIP() {
        return IP;
    }

    public void setIP(long IP) {
        this.IP = IP;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String mensaje) {
        Mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "IPnoENCONTRADA{" +
                "IP=" + IP +
                ", Mensaje='" + Mensaje + '\'' +
                '}';
    }
}