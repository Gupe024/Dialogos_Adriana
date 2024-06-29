package com.example.dialogosapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button DialogoBasico, DialogoPersonalizado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DialogoBasico = findViewById(R.id.Dialog_basico);
        DialogoPersonalizado = findViewById(R.id.Dialogo_personalizado);

        DialogoBasico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogoBasico();
            }
        });

        DialogoPersonalizado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogoPersonalizado();
            }
        });
    }

    private void mostrarDialogoBasico() {
        AlertDialog.Builder constructorDialogo = new AlertDialog.Builder(MainActivity.this, R.style.CustomDialogTheme);
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

    private void mostrarDialogoPersonalizado() {
        AlertDialog.Builder constructorDialogo = new AlertDialog.Builder(MainActivity.this, R.style.CustomDialogTheme);
        constructorDialogo.setTitle(R.string.Dialogo_titulo_personalizado);

        View dialogView = getLayoutInflater().inflate(R.layout.dialogo_personalizado, null);
        constructorDialogo.setView(dialogView);

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
