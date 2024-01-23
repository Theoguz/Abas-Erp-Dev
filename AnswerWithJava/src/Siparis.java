public class Siparis {

    private int siparis;
    private int malNumarasi;
    private int miktar;
    private double birimFiyat;


    public int getSiparis() {
        return siparis;
    }

    public void setSiparis(int siparis) {
        this.siparis = siparis;
    }

    public int getMalNumarasi() {
        return malNumarasi;
    }

    public void setMalNumarasi(int malNumarasi) {
        this.malNumarasi = malNumarasi;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public double getBirimFiyat() {
        return birimFiyat;
    }

    public void setBirimFiyat(double birimFiyat) {
        this.birimFiyat = birimFiyat;
    }

    public Siparis(int siparis, int malNumarasi, int miktar, double birimFiyat) {
        this.siparis = siparis;
        this.malNumarasi = malNumarasi;
        this.miktar = miktar;
        this.birimFiyat = birimFiyat;
    }

    @Override
    public String toString() {
        return "Siparis{" +
                "siparis=" + siparis +
                ", malNumarasi=" + malNumarasi +
                ", miktar=" + miktar +
                ", birimFiyat=" + birimFiyat +
                '}';
    }
}
