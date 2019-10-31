package com.example.aplikasikrs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EditDosenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_dosen);
        this.setTitle("SI KRS - HAI Michael");

        Button edit_dosen = findViewById(R.id.button2);
        edit_dosen.setOnClickListener(dosen);

    }
    private View.OnClickListener dosen = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(EditDosenActivity.this);
            builder.setMessage("Apakahh anda yakin untuk menyimpan ??")
                    .setNegativeButton("No", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int which)
                    { Toast.makeText(EditDosenActivity.this, "Tidak Menyimpan", Toast.LENGTH_SHORT).show(); } })
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int which)
                    { Toast.makeText(EditDosenActivity.this, "Behasil Menyimpan !!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(EditDosenActivity.this,DaftarIsiActivity.class);
                        startActivity(intent);
                    }});
            AlertDialog dialog = builder.create(); dialog.show();
        }
    };
}
