package com.example.question.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "siparis")
    private long siparis;
    @Column(name = "malNumarasi")
    private long malNumarasi;
    @Column(name = "miktar")
    private int miktar;
    @Column(name = "birimFiyat")
    private double birimFiyat;


    public Order(long siparis, long malNumarasi, int miktar, double birimFiyat) {
        this.siparis = siparis;
        this.malNumarasi = malNumarasi;
        this.miktar = miktar;
        this.birimFiyat = birimFiyat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getSiparis() {
        return siparis;
    }

    public void setSiparis(long siparis) {
        this.siparis = siparis;
    }

    public long getMalNumarasi() {
        return malNumarasi;
    }

    public void setMalNumarasi(long malNumarasi) {
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

    public Order() {
    }
}
