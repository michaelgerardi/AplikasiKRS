package com.example.aplikasikrs.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dosen {
    @SerializedName("nidn")
    @Expose
    private String NIDN;
    @SerializedName("nama")
    @Expose
    private String NamaDosen;
    @SerializedName("gelar")
    @Expose
    private String Gelar;
    @SerializedName("email")
    @Expose
    private String Email;
    @SerializedName("foto")
    @Expose
    private String Img;
    @SerializedName("alamat")
    @Expose
    private String Alamat;
    @SerializedName("id")
    @Expose
    private String id;

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

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Dosen(String NIDN, String namaDosen, String gelar, String email, String img, String alamat, String id) {
        this.NIDN = NIDN;
        NamaDosen = namaDosen;
        Gelar = gelar;
        Email = email;
        Img = img;
        Alamat = alamat;
        this.id = id;
    }




}
