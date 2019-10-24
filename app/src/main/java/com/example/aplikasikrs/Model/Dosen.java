package com.example.aplikasikrs.Model;

public class Dosen {
    public Dosen(String NIDN, String namaDosen, String gelar, String email, int img, String alamat) {
        this.NIDN = NIDN;
        NamaDosen = namaDosen;
        Gelar = gelar;
        Email = email;
        Img = img;
        Alamat = alamat;
    }

    public String getNIDN() {
        return NIDN;
    }

    public void setNIDN(String NIDN) {
        this.NIDN = NIDN;
    }

    public String getNamaDosen() {
        return NamaDosen;
    }

    public void setNamaDosen(String namaDosen) {
        NamaDosen = namaDosen;
    }

    public String getGelar() {
        return Gelar;
    }

    public void setGelar(String gelar) {
        Gelar = gelar;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }

    private String NIDN;
    private String NamaDosen;
    private String Gelar;
    private String Email;
    private int Img;
    private String Alamat;
}
