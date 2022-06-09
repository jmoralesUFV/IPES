package ufv.dis.final2022.JMI;

public class busquedasIP {

    private long IP;
    private String country_code;
    private String region_name;
    private String city_name;
    private String zip_code;
    private String time_zone;

    public busquedasIP() {

    }

    public busquedasIP(long IP, String country_code, String region_name, String city_name, String zip_code, String time_zone) {
        this.IP = IP;
        this.country_code = country_code;
        this.region_name = region_name;
        this.city_name = city_name;
        this.zip_code = zip_code;
        this.time_zone = time_zone;
    }

    public long getIP() {
        return IP;
    }

    public void setIP(long IP) {
        this.IP = IP;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getTime_zone() {
        return time_zone;
    }

    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }

    @Override
    public String toString() {
        return "busquedasIP{" +
                "IP=" + IP +
                ", country_code='" + country_code + '\'' +
                ", region_name='" + region_name + '\'' +
                ", city_name='" + city_name + '\'' +
                ", zip_code='" + zip_code + '\'' +
                ", time_zone='" + time_zone + '\'' +
                '}';
    }
}
