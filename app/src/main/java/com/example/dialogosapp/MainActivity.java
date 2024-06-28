package com.example.dialogosapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
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
        constructorDialogo.setTitle(R.string.Dialogo_titulo);
        constructorDialogo.setMessage(R.string.Muestra_mensaje);
        constructorDialogo.setPositiveButton(R.string.Aceptar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, R.string.T_aceptar, Toast.LENGTH_SHORT).show();
            }
        });

        constructorDialogo.setNegativeButton(R.string.Cancelar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, R.string.T_cancelar, Toast.LENGTH_SHORT).show();
            }
        });

        constructorDialogo.show();

    }
}