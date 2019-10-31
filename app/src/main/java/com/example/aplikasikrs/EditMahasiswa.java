package com.example.aplikasikrs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.aplikasikrs.Model.Mahasiswa;

public class EditMahasiswa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mahasiswa);
        this.setTitle("SI KRS - HAI Michael");

        Button mahasiswa = findViewById(R.id.button4);
        mahasiswa.setOnClickListener(EDIT_MHS);

    }
    private View.OnClickListener EDIT_MHS = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(EditMahasiswa.this);
            builder.setMessage("Apakahh anda yakin untuk menyimpan ??")
                    .setNegativeButton("No", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int which)
                    { Toast.makeText(EditMahasiswa.this, "Tidak Menyimpan", Toast.LENGTH_SHORT).show(); } })
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int which)
                    { Toast.makeText(EditMahasiswa.this, "Behasil Menyimpan !!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(EditMahasiswa.this,DaftarIsiActivity.class);
                        startActivity(intent);
                    }});
            AlertDialog dialog = builder.create(); dialog.show();
        }
    };
}
