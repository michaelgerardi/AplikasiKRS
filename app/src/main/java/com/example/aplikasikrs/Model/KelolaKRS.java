package com.example.aplikasikrs.Model;

public class KelolaKRS {

    public String getKode() {
        return Kode;
    }

    public void setKode(String kode) {
        Kode = kode;
    }

    public String getMatkul() {
        return Matkul;
    }

    public void setMatkul(String matkul) {
        Matkul = matkul;
    }

    public String getSesi() {
        return Sesi;
    }

    public void setSesi(String sesi) {
        Sesi = sesi;
    }

    public String getJumlahkrs() {
        return Jumlahkrs;
    }

    public void setJumlahkrs(String jumlahkrs) {
        Jumlahkrs = jumlahkrs;
    }

    public String getPengampu() {
        return pengampu;
    }

    public void setPengampu(String pengampu) {
        this.pengampu = pengampu;
    }

    public String getJumlahMHS() {
        return JumlahMHS;
    }

    public void setJumlahMHS(String jumlahMHS) {
        JumlahMHS = jumlahMHS;
    }

    public String getHari() {
        return Hari;
    }

    public void setHari(String hari) {
        Hari = hari;
    }

    public KelolaKRS(String kode, String matkul, String sesi, String jumlahkrs, String pengampu, String jumlahMHS, String hari) {
        Kode = kode;
        Matkul = matkul;
        Sesi = sesi;
        Jumlahkrs = jumlahkrs;
        this.pengampu = pengampu;
        JumlahMHS = jumlahMHS;
        Hari = hari;
    }

    private String Kode;
    private String Matkul;
    private String Sesi;
    private  String Jumlahkrs;
    private  String pengampu;
    private String JumlahMHS;
    private String Hari;
}
