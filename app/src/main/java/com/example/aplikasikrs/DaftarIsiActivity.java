package com.example.aplikasikrs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class DaftarIsiActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.layout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            if(item.getItemId()==R.id.Openbrowser){
                AlertDialog.Builder builder = new AlertDialog.Builder(DaftarIsiActivity.this);
                builder.setMessage("Apakahh anda yakin untuk Logout ??")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int which)
                        { Toast.makeText(DaftarIsiActivity.this, "Tidak Logout", Toast.LENGTH_SHORT).show(); } })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int which)
                        { Toast.makeText(DaftarIsiActivity.this, "Behasil Logout !!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(DaftarIsiActivity.this,MainActivity.class);
                            startActivity(intent);
                        }});
                AlertDialog dialog = builder.create(); dialog.show();
            }

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_isi);
        this.setTitle("SI KRS - HAI Michael");

        ImageButton Daftardosen = findViewById(R.id.imageButton2);
        Daftardosen.setOnClickListener(btnDosen);

        ImageButton DaftarMahasiswa = findViewById(R.id.imageButton5);
        DaftarMahasiswa.setOnClickListener(btnmhs);

        ImageButton Daftarmatkul= findViewById(R.id.imageButton3);
        Daftarmatkul.setOnClickListener(btnmatkul);

        ImageButton Daftarkelola = findViewById(R.id.imageButton4);
        Daftarkelola.setOnClickListener(btnkelolakrs);

        ImageButton daftardiri =findViewById(R.id.imageButton);
        daftardiri.setOnClickListener(btndatadiri);


    }
    private View.OnClickListener btnDosen = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(DaftarIsiActivity.this,Cruddosen.class);
            startActivity(intent);
        }
    };
    private  View.OnClickListener btnmhs  = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(DaftarIsiActivity.this,CrudMahasiswa.class);
            startActivity(intent);
        }
    };
    private  View.OnClickListener btnmatkul = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(DaftarIsiActivity.this,MatakuliahActivity.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener btnkelolakrs = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(DaftarIsiActivity.this,KelolaKRSActivity.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener btndatadiri = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent =new Intent(DaftarIsiActivity.this,DataDiriActivity.class);
            startActivity(intent);
        }
    };
}
