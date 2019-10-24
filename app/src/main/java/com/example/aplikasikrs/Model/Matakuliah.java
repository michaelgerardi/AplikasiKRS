package com.example.aplikasikrs.Model;



public class Matakuliah  {


    public String getKodematkul() {
        return Kodematkul;
    }

    public void setKodematkul(String kodematkul) {
        Kodematkul = kodematkul;
    }

    public String getNamaMatkul() {
        return NamaMatkul;
    }

    public void setNamaMatkul(String namaMatkul) {
        NamaMatkul = namaMatkul;
    }

    public String getHari() {
        return Hari;
    }

    public void setHari(String hari) {
        Hari = hari;
    }

    public String getSesi() {
        return Sesi;
    }

    public void setSesi(String sesi) {
        Sesi = sesi;
    }

    public String getJumlahsks() {
        return jumlahsks;
    }

    public void setJumlahsks(String jumlahsks) {
        this.jumlahsks = jumlahsks;
    }

    public String getJumlahmhs() {
        return jumlahmhs;
    }

    public void setJumlahmhs(String jumlahmhs) {
        this.jumlahmhs = jumlahmhs;
    }

    private String Kodematkul;
    private String NamaMatkul;
    private String Hari;
    private String Sesi;
    private String jumlahsks;

    public Matakuliah(String kodematkul, String namaMatkul, String hari, String sesi, String jumlahsks) {
        Kodematkul = kodematkul;
        NamaMatkul = namaMatkul;
        Hari = hari;
        Sesi = sesi;
        this.jumlahsks = jumlahsks;
        this.jumlahmhs = jumlahmhs;
    }

    private String jumlahmhs;
}
