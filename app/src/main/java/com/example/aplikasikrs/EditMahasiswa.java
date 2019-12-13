package com.example.aplikasikrs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.aplikasikrs.Model.DefaultResult;
import com.example.aplikasikrs.Model.Mahasiswa;
import com.example.aplikasikrs.Network.GetDataService;
import com.example.aplikasikrs.Network.RetrofitClientInstance;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static  android.content.pm.PackageManager.PERMISSION_GRANTED;

public class EditMahasiswa extends AppCompatActivity {
    private EditText nama_mhs, nim_mhs,alamat_mhs,email_mhs,foto_dosen;
    ImageView part_img;
    Boolean isUpdate = false;
    String idMahasiswa= "";
    String Image;
    final  int Request_Gallery = 58;
    final int FILE_ACCESS_REQUES_CODE=58;
    Bitmap bitmap;
    byte[] Imagebyte;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mahasiswa);
        this.setTitle("SI KRS - HAI Michael");
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new  String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE
            },FILE_ACCESS_REQUES_CODE);
        }

        Button cari_gambar = findViewById(R.id.button3);
        cari_gambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pilih_gambar();
            }
        });

        nama_mhs=(EditText)findViewById(R.id.editText10);
        nim_mhs= (EditText)findViewById(R.id.editText8);
        alamat_mhs =(EditText)findViewById(R.id.editText6);
        email_mhs=(EditText)findViewById(R.id.editText7);
        foto_dosen=(EditText)findViewById(R.id.editText20);
        part_img = (ImageView)findViewById(R.id.gambar_mhs);

        Button edit_mahasiswa = findViewById(R.id.button4);
        check_Update();
        if (isUpdate) {
            edit_mahasiswa.setText("update");
        }
        edit_mahasiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nama_mhs.getText().toString().length() ==0){
                    nama_mhs.setError("Input data anda salah !");
                }
                if(nim_mhs.getText().toString().length() ==0){
                    nim_mhs.setError("Input data anda salah !");
                }
                if(alamat_mhs.getText().toString().length() ==0){
                    alamat_mhs.setError("Input data anda salah !");
                }
                if(email_mhs.getText().toString().length() ==0){
                    email_mhs.setError("Input data anda salah !");
                }
                if(foto_dosen.getText().toString().length() ==0){
                    foto_dosen.setError("Input data anda salah !");
                }

                if (!isUpdate){
                    AlertDialog.Builder builder = new AlertDialog.Builder(EditMahasiswa.this);
                    builder.setMessage("Apakahh anda yakin untuk menyimpan ??")
                            .setNegativeButton("No", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int which)
                            { Toast.makeText(EditMahasiswa.this, "Tidak Menyimpan", Toast.LENGTH_SHORT).show(); } })
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    tambah_data();
                                }});
                    AlertDialog dialog = builder.create(); dialog.show();
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(EditMahasiswa.this);
                    builder.setMessage("Apakahh anda yakin untuk menyimpan ??")
                            .setNegativeButton("No", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int which)
                            { Toast.makeText(EditMahasiswa.this, "Tidak Menyimpan", Toast.LENGTH_SHORT).show(); } })
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    update_mahasiwa();
                                }});
                    AlertDialog dialog = builder.create(); dialog.show();
                }
            }
        });
    }
    private void tambah_data(){
        String Image = ConvertingBitmapToString();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("masih loading sabar ...");
        progressDialog.show();


        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<DefaultResult> call = service.insert_mhs(
                idMahasiswa,
                nama_mhs.getText().toString(),
                nim_mhs.getText().toString(),
                email_mhs.getText().toString(),
                alamat_mhs.getText().toString(),
                Image,
                "72170100");
        call.enqueue(new Callback<DefaultResult>() {
            @Override
            public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                progressDialog.dismiss();
                Toast.makeText(EditMahasiswa.this, "Behasil Menyimpan !!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(EditMahasiswa.this,CrudMahasiswa.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<DefaultResult> call, Throwable t) {
                progressDialog.
                        dismiss();
                Toast.makeText(EditMahasiswa.this,"Login gagal,Coba Lagi",Toast.LENGTH_LONG);
            }
        });

    }
    private void update_mahasiwa(){
        String Image = ConvertingBitmapToString();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("masih loading sabar ...");
        progressDialog.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<DefaultResult> call = service.update_mhs(
               idMahasiswa,
                nama_mhs.getText().toString(),
                nim_mhs.getText().toString(),
                email_mhs.getText().toString(),
                alamat_mhs.getText().toString(),
                Image,
                "72170100");
        call.enqueue(new Callback<DefaultResult>() {
            @Override
            public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                progressDialog.dismiss();
                Toast.makeText(EditMahasiswa.this, "Behasil Update !!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(EditMahasiswa.this,CrudMahasiswa.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<DefaultResult> call, Throwable t) {
                progressDialog.
                        dismiss();
                Toast.makeText(EditMahasiswa.this,"Gagal update",Toast.LENGTH_LONG);
            }
        });
    }
    private void pilih_gambar(){
        Intent intent = new Intent();
        intent.setType("image/*");
        String[] minetype={"image/jpeg"};
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Open_gallery"),Request_Gallery);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == Request_Gallery && resultCode == RESULT_OK && data != null){
            Uri path = data.getData();
            try{
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),path);
                part_img.setImageBitmap(bitmap);
                part_img.setVisibility(View.VISIBLE);



            }catch (IOException E){
                E.printStackTrace();
            }
        }
    }
    public  String ConvertingBitmapToString (){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        Imagebyte = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(Imagebyte,Base64.DEFAULT);
    }
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

    void check_Update(){
        Bundle extras = getIntent().getExtras();
        if (extras == null){
            return;
        }
        isUpdate = extras.getBoolean("is_update");
        idMahasiswa = extras.getString("id_mahasiswa");
        nama_mhs.setText(extras.getString("nama_mhs"));
        nim_mhs.setText(extras.getString("nim_mhs"));
        alamat_mhs.setText(extras.getString("alamat_mhs"));
        email_mhs.setText(extras.getString("email_mhs"));
        Image = extras.getString("foto");
        Picasso.with(EditMahasiswa.this)
                .load("https://kpsi.fti.ukdw.ac.id/progmob/" +extras.getString("gambar_mhs"))
                .into(part_img);
    }
}
