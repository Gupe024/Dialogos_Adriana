package com.example.dialogosapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button DialogoBasic;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DialogoBasic = findViewById(R.id.Dialog_basico);
        DialogoBasic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogo();
            }
        });
    }
    private void mostrarDialogo() {
        AlertDialog.Builder constructorDialogo = new AlertDialog.Builder(MainActivity.this);
        constructorDialogo.setTitle("Diálogo Básico");
        constructorDialogo.setMessage("¿Quieres aceptar o cancelar?");
        constructorDialogo.setPositiveButton("Aceptar", (dialog, which) -> {
            Toast.makeText(MainActivity.this, "Has aceptado", Toast.LENGTH_SHORT).show();
        });
        constructorDialogo.setNegativeButton("Cancelar", (dialog, which) -> {
            Toast.makeText(MainActivity.this, "Has cancelado", Toast.LENGTH_SHORT).show();
        });
        constructorDialogo.show();
    }
}