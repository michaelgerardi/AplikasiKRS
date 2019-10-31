package com.example.aplikasikrs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EditKelolaKRSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_kelola_krs);
        this.setTitle("SI KRS - HAI Michael");

        Button KRS = findViewById(R.id.button8);
        KRS.setOnClickListener(edit_krs);
    }
    private View.OnClickListener edit_krs = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(EditKelolaKRSActivity.this);
            builder.setMessage("Apakahh anda yakin untuk menyimpan ??")
                    .setNegativeButton("No", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int which)
                    { Toast.makeText(EditKelolaKRSActivity.this, "Tidak Menyimpan", Toast.LENGTH_SHORT).show(); } })
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int which)
                    { Toast.makeText(EditKelolaKRSActivity.this, "Behasil Menyimpan !!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(EditKelolaKRSActivity.this,DaftarIsiActivity.class);
                        startActivity(intent);
                    }});
            AlertDialog dialog = builder.create(); dialog.show();
        }
    };
}
