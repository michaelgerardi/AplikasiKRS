package com.example.aplikasikrs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.aplikasikrs.Adapter.DosenAdapter;
import com.example.aplikasikrs.Adapter.MahasiswaAdapter;
import com.example.aplikasikrs.Model.DefaultResult;
import com.example.aplikasikrs.Model.Dosen;
import com.example.aplikasikrs.Model.Mahasiswa;
import com.example.aplikasikrs.Model.Matakuliah;
import com.example.aplikasikrs.Network.GetDataService;
import com.example.aplikasikrs.Network.RetrofitClientInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CrudMahasiswa extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MahasiswaAdapter mahasiswaAdapter;
    private ArrayList<Mahasiswa> mahasiswaArrayList;
    ProgressDialog progressDialog;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mhs,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== R.id.Menu_2) {
            Intent intent = new Intent(CrudMahasiswa.this,EditMahasiswa.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_mahasiswa);
        recyclerView = findViewById(R.id.RcvMahasiswa);
        this.setTitle("SI KRS - HAI Michael");

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("masih loading sabar ...");
        progressDialog.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ArrayList<Mahasiswa>> call = service.getmhsAll("72170100");// memanggil data yang sudah ada
        call.enqueue(new Callback<ArrayList<Mahasiswa>>() {
            @Override
            public void onResponse(Call<ArrayList<Mahasiswa>> call, Response<ArrayList<Mahasiswa>> response) {
                progressDialog.dismiss();

                mahasiswaArrayList = response.body();
                mahasiswaAdapter= new MahasiswaAdapter(response.body());
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CrudMahasiswa.this);
                recyclerView .setLayoutManager(layoutManager);
                recyclerView .setAdapter( mahasiswaAdapter );
            }

            @Override
            public void onFailure(Call<ArrayList<Mahasiswa>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(CrudMahasiswa.this,"Login gagal,Coba Lagi",Toast.LENGTH_LONG);
            }
        });
        registerForContextMenu(recyclerView);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Mahasiswa mahasiswa = mahasiswaArrayList.get(item.getGroupId());
        if (item.getTitle() == "Ubah data mahasiswa "){
            Intent intent = new Intent(CrudMahasiswa.this,EditMahasiswa.class);
            intent.putExtra("id_mahasiswa",mahasiswa.getId());
            intent.putExtra("nama_mhs",mahasiswa.getNama());
            intent.putExtra("nim_mhs",mahasiswa.getNIM());
            intent.putExtra("alamat_mhs",mahasiswa.getAlamat());
            intent.putExtra("email_mhs",mahasiswa.getEmail());
            intent.putExtra("gambar_mhs",mahasiswa.getGambar());
            intent.putExtra("is_update",true);
            startActivity(intent);
        }else if (item.getTitle() == "Delete data mahasiswa ") {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("masih loading sabar ...");

            GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
            Call<DefaultResult> call = service.delete_mhs(
                    mahasiswa.getId(),
                    "72170100");// memanggil data yang sudah ada
            call.enqueue(new Callback<DefaultResult>() {
                @Override
                public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                    progressDialog.dismiss();
                    Toast.makeText(CrudMahasiswa.this, "Behasil Kehapus !!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CrudMahasiswa.this, CrudMahasiswa.class);
                    startActivity(intent);

                }

                @Override
                public void onFailure(Call<DefaultResult> call, Throwable t) {
                    progressDialog.dismiss();
                    Toast.makeText(CrudMahasiswa.this, "Gagal Terhapus", Toast.LENGTH_LONG).show();
                }

            });
        }

        return super.onContextItemSelected(item);
    }

}
