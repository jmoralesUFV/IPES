package ufv.dis.final2022.JMI;

public class ObjetoBuscarIP {

    private String ip;

    public ObjetoBuscarIP() {

    }

    public ObjetoBuscarIP(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "ObjetoBuscarIP{" +
                "ip='" + ip + '\'' +
                '}';
    }
}
