package com.example.aplikasikrs;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.aplikasikrs.Model.DefaultResult;
import com.example.aplikasikrs.Model.Dosen;
import com.example.aplikasikrs.Network.GetDataService;
import com.example.aplikasikrs.Network.RetrofitClientInstance;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;
import static  android.content.pm.PackageManager.PERMISSION_GRANTED;


public class Tambah_Dosen extends AppCompatActivity {
    private EditText nama_dosen;
    private EditText alamat_dosen;
    private EditText email_dosen;
    private EditText gelar_dosen;
    private EditText nidn_dosen;
    private EditText foto_dosen;
    Boolean isUpdate = false;
    String idDosen= "";
    ProgressDialog progressDialog;
    final  int Request_Gallery = 58;
    final int FILE_ACCESS_REQUES_CODE=58;
    Bitmap bitmap;
    ImageView part_image;
    EditText text_tulisan;
    String Image;
    byte[] Imagebyte;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah__dosen);
        this.setTitle("SI KRS - HAI Michael");

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new  String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE
            },FILE_ACCESS_REQUES_CODE);
        }
        part_image = (ImageView)findViewById(R.id.img_pilih);
        text_tulisan = (EditText)findViewById(R.id.txt_foto_dosen);


        Button btn_carifoto = findViewById(R.id.btn_cari_foto);
        btn_carifoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pilih_gambar();
            }
        });


        nama_dosen = (EditText) findViewById(R.id.txt_nama_dosen_1);
        nidn_dosen = (EditText)findViewById(R.id.txt_NIDN_dosen_1);
        gelar_dosen = (EditText) findViewById(R.id.txt_gelar_dosen_1);
        alamat_dosen = (EditText)findViewById(R.id.txt_alamat_dosen_1);
        email_dosen = (EditText) findViewById(R.id.txt_email_dosen_1);
        foto_dosen = (EditText) findViewById(R.id.txt_foto_dosen);


        check_Update();
        Button edit_dosen = findViewById(R.id.btn_simpan_dosen);
        if (isUpdate) {
            edit_dosen.setText("update");
        }
        edit_dosen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(nama_dosen.getText().toString().length() ==0){
                    nama_dosen.setError("Input data anda salah !");
                }
                if (nidn_dosen.getText().toString().length() == 0){
                    nidn_dosen.setError("Input data anda salah");
                }
                if (gelar_dosen.getText().toString().length() == 0){
                    gelar_dosen.setError("Input data anda salah !");
                }
                if (alamat_dosen.getText().toString().length() == 0 ){
                    alamat_dosen.setError("Input data anda salah!");
                }
                if (email_dosen.getText().toString().length()==0){
                    email_dosen.setError("Input data anda salah");
                }
                if (foto_dosen.getText().toString().length()==0){
                    foto_dosen.setError("Input data anda salah");
                }
                if (!isUpdate){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Tambah_Dosen.this);
                    builder.setMessage("Apakahh anda yakin untuk menyimpan ??")
                            .setNegativeButton("No", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int which)
                            { Toast.makeText(Tambah_Dosen.this, "Tidak Menyimpan", Toast.LENGTH_SHORT).show(); } })
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    tambah_data();
                                }});
                    AlertDialog dialog = builder.create(); dialog.show();
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Tambah_Dosen.this);
                    builder.setMessage("Apakahh anda yakin untuk menyimpan ??")
                            .setNegativeButton("No", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int which)
                            { Toast.makeText(Tambah_Dosen.this, "Tidak Menyimpan", Toast.LENGTH_SHORT).show(); } })
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    update_dosen();
                                }});
                    AlertDialog dialog = builder.create(); dialog.show();
                }
                }
            }
        );

    }


   private void tambah_data(){
        String Image = ConvertingBitmapToString();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("masih loading sabar ...");
        progressDialog.show();


        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<DefaultResult> call = service.Insert_foto(
                nama_dosen.getText().toString(),
                alamat_dosen.getText().toString(),
                nidn_dosen.getText().toString(),
                gelar_dosen.getText().toString(),
                email_dosen.getText().toString(),
                Image,
                "72170100");
        call.enqueue(new Callback<DefaultResult>() {
            @Override
            public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                progressDialog.dismiss();
                Toast.makeText(Tambah_Dosen.this, "Behasil Menyimpan !!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Tambah_Dosen.this,Cruddosen.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<DefaultResult> call, Throwable t) {
                progressDialog.
                        dismiss();
                Toast.makeText(Tambah_Dosen.this,"Login gagal,Coba Lagi",Toast.LENGTH_LONG);
            }
        });

    }
    private void update_dosen(){
        String Image = ConvertingBitmapToString();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("masih loading sabar ...");
        progressDialog.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<DefaultResult> call = service.Update_foto_dosen(
                idDosen,
                nama_dosen.getText().toString(),
                alamat_dosen.getText().toString(),
                nidn_dosen.getText().toString(),
                gelar_dosen.getText().toString(),
                email_dosen.getText().toString(),
                Image,
                "72170100");
        call.enqueue(new Callback<DefaultResult>() {
            @Override
            public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                progressDialog.dismiss();
                Toast.makeText(Tambah_Dosen.this, "Behasil Update !!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Tambah_Dosen.this,Cruddosen.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<DefaultResult> call, Throwable t) {
                progressDialog.
                        dismiss();
                Toast.makeText(Tambah_Dosen.this,"Gagal update",Toast.LENGTH_LONG);
            }
        });
    }
    // masuk kedalam galeri
    private void pilih_gambar(){
            Intent intent = new Intent();
            intent.setType("image/*");
            String[] minetype={"image/jpeg"};
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent,"Open_gallery"),Request_Gallery);

        }
    // memasukkan gambar ke ImageView
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == Request_Gallery && resultCode == RESULT_OK && data != null){
            Uri path = data.getData();
            try{
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),path);
                part_image.setImageBitmap(bitmap);
                part_image.setVisibility(View.VISIBLE);
                text_tulisan.setVisibility(View.VISIBLE);


            }catch (IOException E){
                E.printStackTrace();
            }
        }
    }
    //
    public  String ConvertingBitmapToString (){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        Imagebyte = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(Imagebyte,Base64.DEFAULT);
    }
    // metode Meminta ijin sebelum masuk kedalam galerry
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case FILE_ACCESS_REQUES_CODE:
                if(grantResults.length > 0 && grantResults[0] == PERMISSION_GRANTED){
                    //permision granted
                }
                break;
        }
    }
    void  check_Update(){
       Bundle extras = getIntent().getExtras();
       if (extras == null){
           return;
       }
       isUpdate = extras.getBoolean("is_update");
       idDosen = extras.getString("id_dosen");
       nama_dosen.setText(extras.getString("nama_dosen"));
       nidn_dosen.setText(extras.getString("nidn"));
       alamat_dosen.setText(extras.getString("alamat"));
       gelar_dosen.setText(extras.getString("gelar"));
       email_dosen.setText(extras.getString("email"));
      // foto_dosen.setText(extras.getString("foto"));
        Image = extras.getString("foto");
        Picasso.with(Tambah_Dosen.this)
                .load("https://kpsi.fti.ukdw.ac.id/progmob/" +extras.getString("foto"))
                .into(part_image);

    }

}
