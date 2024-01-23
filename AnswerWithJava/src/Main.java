import java.util.*;

public class Main {
    private List<Siparis> siparisListesi = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        List<Siparis> siparisListesi = new ArrayList<>();

        // Verileri listeye ekle
        main.siparisListesi.add(new Siparis(1000, 2000, 12, 100.51));
        main.siparisListesi.add(new Siparis(1000, 2001, 31, 200.0));
        main.siparisListesi.add(new Siparis(1000, 2002, 22, 150.86));
        main.siparisListesi.add(new Siparis(1000, 2003, 41, 250.0));
        main.siparisListesi.add(new Siparis(1000, 2004, 55, 244.0));
        main.siparisListesi.add(new Siparis(1001, 2001, 88, 44.531));
        main.siparisListesi.add(new Siparis(1001, 2002, 121, 88.11));
        main.siparisListesi.add(new Siparis(1001, 2004, 74, 211.0));
        main.siparisListesi.add(new Siparis(1001, 2002, 14, 88.11));
        main.siparisListesi.add(new Siparis(1002, 2003, 2, 12.1));
        main.siparisListesi.add(new Siparis(1002, 2004, 3, 22.3));
        main.siparisListesi.add(new Siparis(1002, 2003, 8, 12.1));
        main.siparisListesi.add(new Siparis(1002, 2002, 16, 94.0));
        main.siparisListesi.add(new Siparis(1002, 2005, 9, 44.1));
        main.siparisListesi.add(new Siparis(1002, 2006, 19, 90.0));


        for (Siparis siparis : main.siparisListesi) {
            System.out.println(siparis);
        }

        main.totalPrice();
        main.averagePrice();
        main.averagePriceByMalNumarasi(2000);
        main.averagePriceByMalNumarasi(2001);
        main.averagePriceByMalNumarasi(2002);
        main.averagePriceByMalNumarasi(2003);
        main.averagePriceByMalNumarasi(2004);
        main.averagePriceByMalNumarasi(2005);
        main.averagePriceByMalNumarasi(2006);
        main.groupOrdersByMalNo();


    }

    public void totalPrice() {            // Answer 1
        List<Siparis> orders = siparisListesi;
        double totalPrice = 0;
        for (Siparis siparis : orders) {
            totalPrice += siparis.getBirimFiyat() * siparis.getMiktar();
        }
        System.out.println("---------------------------------------");
        System.out.println("\nToplam Fiyat: " + totalPrice);
    }

    public void averagePrice() {          // Answer 2
        List<Siparis> orders = siparisListesi;
        double totalPrice = 0;
        double getMiktar = 0;
        for (Siparis siparis : orders) {
            totalPrice += siparis.getBirimFiyat() * siparis.getMiktar();
            getMiktar += siparis.getMiktar();

        }

        System.out.println("\nOrtalama Fiyat: " + totalPrice / getMiktar);
    }

    public void averagePriceByMalNumarasi(long malNumarasi) {         // Answer 3
        List<Siparis> orders = siparisListesi;
        double totalPrice = 0;
        double miktar = 0;
        for (Siparis siparis : orders) {
            if (siparis.getMalNumarasi() == malNumarasi) {
                totalPrice += siparis.getBirimFiyat() * siparis.getMiktar();
                miktar += siparis.getMiktar();
            }
        }
        System.out.println("\n----------------");
        System.out.println("Mal Numarası : " + malNumarasi);
        System.out.println("Ortalama Fiyat : " + totalPrice / miktar);

    }

    public Map<Integer, List<Siparis>> groupOrdersByMalNo() {         // Answer 4
        List<Siparis> orders = siparisListesi;
        Map<Integer, List<Siparis>> malNumarasiGruplari = new HashMap<>();

        for (Siparis order : orders) {
            long malNumarasi = order.getMalNumarasi();
            malNumarasiGruplari.computeIfAbsent((int) malNumarasi, key -> new ArrayList<>()).add(order);
        }

        System.out.println("----------------");
        System.out.println("\nMAL NUMARASINA GÖRE GRUPLAMA\n");
        for (Map.Entry<Integer, List<Siparis>> entry : malNumarasiGruplari.entrySet()) {
            int malNumarasi = entry.getKey();
            List<Siparis> siparisList = entry.getValue();
            System.out.println("Mal Numarası: " + malNumarasi);
            for (Siparis siparis : siparisList) {
                System.out.println("\t" + siparis);
            }
        }

        return malNumarasiGruplari;
    }
}