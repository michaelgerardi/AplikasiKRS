package com.example.aplikasikrs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.aplikasikrs.Adapter.DosenAdapter;
import com.example.aplikasikrs.Model.DefaultResult;
import com.example.aplikasikrs.Model.Dosen;
import com.example.aplikasikrs.Network.GetDataService;
import com.example.aplikasikrs.Network.RetrofitClientInstance;
import  retrofit2.Call;
import  retrofit2.Callback;
import  retrofit2.Response;


import java.util.ArrayList;

public class Cruddosen extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DosenAdapter dosenAdapter;
    private ArrayList<Dosen>dosenArrayList;
    ProgressDialog progressDialog;



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_create,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== R.id.Menu_1) {
            Intent intent = new Intent(Cruddosen.this,Tambah_Dosen.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cruddosen);
        recyclerView = findViewById(R.id.RcvCrudDosen);
        this.setTitle("SI KRS - HAI Michael");



        //addData();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("masih loading sabar ...");
        progressDialog.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ArrayList<Dosen>> call = service.getDosenAll("72170100");// memanggil data yang sudah ada
        call.enqueue(new Callback<ArrayList<Dosen>>() {
            @Override
            public void onResponse(Call<ArrayList<Dosen>> call, Response<ArrayList<Dosen>> response) {
                progressDialog.dismiss();

                dosenArrayList = response.body();
                dosenAdapter = new DosenAdapter(response.body());
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Cruddosen.this);
                recyclerView .setLayoutManager(layoutManager);
                recyclerView .setAdapter( dosenAdapter );
            }

            @Override
            public void onFailure(Call<ArrayList<Dosen>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(Cruddosen.this,"Login gagal,Coba Lagi",Toast.LENGTH_LONG);
            }
        });


        registerForContextMenu(recyclerView);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Dosen dosen = dosenArrayList.get(item.getGroupId());
        if (item.getTitle() == "Ubah data dosen "){
            Intent intent = new Intent(Cruddosen.this,Tambah_Dosen.class);
            intent.putExtra("id_dosen",dosen.getId());
            intent.putExtra("nama_dosen",dosen.getNamaDosen());
            intent.putExtra("nidn",dosen.getNIDN());
            intent.putExtra("alamat",dosen.getAlamat());
            intent.putExtra("email",dosen.getEmail());
            intent.putExtra("gelar",dosen.getGelar());
            intent.putExtra("foto",dosen.getImg());
            intent.putExtra("is_update",true);
            startActivity(intent);
        }else if (item.getTitle() == "Delete data dosen ") {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("masih loading sabar ...");

            GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
            Call<DefaultResult> call = service.delete_dosen(
                    dosen.getId(),
                    "72170100");// memanggil data yang sudah ada
            call.enqueue(new Callback<DefaultResult>() {
                @Override
                public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                    progressDialog.dismiss();
                    Toast.makeText(Cruddosen.this, "Behasil Kehapus !!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Cruddosen.this, Cruddosen.class);
                    startActivity(intent);

                }

                @Override
                public void onFailure(Call<DefaultResult> call, Throwable t) {
                    progressDialog.dismiss();
                    Toast.makeText(Cruddosen.this, "Gagal Terhapus", Toast.LENGTH_LONG).show();
                }

            });
        }

        return super.onContextItemSelected(item);
    }


    /* private void addData(){
        dosenArrayList= new ArrayList<>();
        dosenArrayList.add(new Dosen("2121","siang","Master","siang@staff",R.drawable.siang,"jogja","1"));
        dosenArrayList.add(new Dosen("2121","argo","master","argo@staff",R.drawable.argo,"jogja","2"));
    }*/
}
