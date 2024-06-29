package com.example.dialogosapp;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button dialogoBasico;
    Button dialogoPersonalizado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialogoBasico = findViewById(R.id.Dialog_basico);
        dialogoBasico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogoBasico();
            }
        });

        dialogoPersonalizado = findViewById(R.id.Dialogo_personalizado);
        dialogoPersonalizado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogoPersonalizado();
            }
        });
    }

    private void mostrarDialogoBasico() {
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

    private void mostrarDialogoPersonalizado() {
        LayoutInflater inflater = getLayoutInflater();
        View vistaDialogo = inflater.inflate(R.layout.dialogo_personalizado, null);

        EditText etNombre = vistaDialogo.findViewById(R.id.etNombre);
        EditText etUsuario = vistaDialogo.findViewById(R.id.etUsuario);
        EditText etTelefono = vistaDialogo.findViewById(R.id.etTelefono);
        EditText etEmail = vistaDialogo.findViewById(R.id.etEmail);
        EditText etContrasena = vistaDialogo.findViewById(R.id.etContrasena);

        AlertDialog.Builder constructorDialogo = new AlertDialog.Builder(MainActivity.this);
        constructorDialogo.setTitle(R.string.Dialogo_titulo_personalizado);
        constructorDialogo.setView(vistaDialogo);

        constructorDialogo.setPositiveButton(R.string.Aceptar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nombre = etNombre.getText().toString();
                String usuario = etUsuario.getText().toString();
                String telefono = etTelefono.getText().toString();
                String email = etEmail.getText().toString();
                String contrasena = etContrasena.getText().toString();

                Toast.makeText(MainActivity.this, R.string.toast_registro_aceptado, Toast.LENGTH_SHORT).show();
            }
        });

        constructorDialogo.setNegativeButton(R.string.Cancelar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, R.string.toast_registro_cancelado, Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = constructorDialogo.create();
        dialog.show();

        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.80);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.60);
        dialog.getWindow().setLayout(width, height);
    }
}