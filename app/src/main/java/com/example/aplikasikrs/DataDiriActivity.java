package com.example.aplikasikrs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DataDiriActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_diri);
        this.setTitle("SI KRS - HAI Michael");

        Button simpan1 = findViewById(R.id.button7);
        simpan1.setOnClickListener(btspn1);
    }
    private View.OnClickListener btspn1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(DataDiriActivity.this);
            builder.setMessage("Apakahh anda yakin untuk menyimpan ??")
                    .setNegativeButton("No", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int which)
                    { Toast.makeText(DataDiriActivity.this, "Tidak Menyimpan", Toast.LENGTH_SHORT).show(); } })
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int which)
                    { Toast.makeText(DataDiriActivity.this, "Behasil Menyimpan !!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DataDiriActivity.this,DaftarIsiActivity.class);
                        startActivity(intent);
                    }});
            AlertDialog dialog = builder.create(); dialog.show();
        }
    };
}
