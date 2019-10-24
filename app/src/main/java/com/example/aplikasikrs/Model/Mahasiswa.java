package com.example.aplikasikrs.Model;

public class Mahasiswa {
    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getGambar() {
        return Gambar;
    }

    public void setGambar(int gambar) {
        Gambar = gambar;
    }

    public Mahasiswa(String NIM, String nama, String alamat, String email, int gambar) {
        this.NIM = NIM;
        Nama = nama;
        Alamat = alamat;
        Email = email;
        Gambar = gambar;
    }

    private String NIM;
    private String Nama;
    private String Alamat;
    private String Email;
    private int Gambar;
}
