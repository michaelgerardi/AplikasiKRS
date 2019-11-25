package com.example.aplikasikrs;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikasikrs.Model.DefaultResult;
import com.example.aplikasikrs.Model.Dosen;
import com.example.aplikasikrs.Network.GetDataService;
import com.example.aplikasikrs.Network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tambah_Dosen extends AppCompatActivity {
    private EditText nama_dosen;
    private EditText alamat_dosen;
    private EditText email_dosen;
    private EditText gelar_dosen;
    private EditText nidn_dosen;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah__dosen);
        this.setTitle("SI KRS - HAI Michael");

        Button edit_dosen = findViewById(R.id.btn_simpan_dosen);
        edit_dosen.setOnClickListener(dosen);

    }
    private View.OnClickListener dosen = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Tambah_Dosen.this);
            builder.setMessage("Apakahh anda yakin untuk menyimpan ??")
                    .setNegativeButton("No", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int which)
                    { Toast.makeText(Tambah_Dosen.this, "Tidak Menyimpan", Toast.LENGTH_SHORT).show(); } })
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            tambah_data();
                    }});
            AlertDialog dialog = builder.create(); dialog.show();
        }
    };
   private void tambah_data(){
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("masih loading sabar ...");
        progressDialog.show();

        nama_dosen = (EditText) findViewById(R.id.txt_nama_dosen_1);
        nidn_dosen = (EditText)findViewById(R.id.txt_NIDN_dosen_1);
        gelar_dosen = (EditText) findViewById(R.id.txt_gelar_dosen_1);
        alamat_dosen = (EditText)findViewById(R.id.txt_alamat_dosen_1);
        email_dosen = (EditText) findViewById(R.id.txt_email_dosen_1);



        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<DefaultResult> call = service.insert_dosen(
                nama_dosen.getText().toString(),
                alamat_dosen.getText().toString(),
                nidn_dosen.getText().toString(),
                gelar_dosen.getText().toString(),
                email_dosen.getText().toString(),
                "https://picsum.photos/200",
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

}