package com.example.aplikasikrs.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Mahasiswa {


    @SerializedName("nim_mhs")
    @Expose
    private String NIM;
    @SerializedName("nama_mhs")
    @Expose
    private String Nama;
    @SerializedName("alamat_mhs")
    @Expose
    private String Alamat;
    @SerializedName("email_mhs")
    @Expose
    private String Email;

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

    public String getGambar() {
        return Gambar;
    }

    public void setGambar(String gambar) {
        Gambar = gambar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Mahasiswa(String NIM, String nama, String alamat, String email, String gambar, String id) {
        this.NIM = NIM;
        Nama = nama;
        Alamat = alamat;
        Email = email;
        Gambar = gambar;
        this.id = id;
    }

    @SerializedName("gambar_mhs")
    @Expose
    private String Gambar;

    @SerializedName("id_mahasiswa")
    @Expose
    private  String id;
}
