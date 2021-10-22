package com.example.hospitalproyectointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PacienteIngreso extends AppCompatActivity {
    Button btnPerfilPaciente,btnCrearCitaPaciente,btnHistorialCitasxFechaPaciente,btnCerrarSesionPaciente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paciente_ingreso);

        btnPerfilPaciente= findViewById(R.id.btnPerfilPaciente);
        btnPerfilPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PacienteIngreso.this, com.example.hospitalproyectointegrador.PerfilUsuario.class));
                finish();
            }
        });

        btnCrearCitaPaciente= findViewById(R.id.btnCrearCitaPaciente);
        btnCrearCitaPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PacienteIngreso.this, com.example.hospitalproyectointegrador.Paciente_CrearCita.class));
                finish();
            }
        });

        btnHistorialCitasxFechaPaciente= findViewById(R.id.btnHistorialCitasxFechaPaciente);
        btnHistorialCitasxFechaPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PacienteIngreso.this, com.example.hospitalproyectointegrador.Paciente_HistorialCitasxFechas.class));
                finish();
            }
        });

        btnCerrarSesionPaciente= findViewById(R.id.btnCerrarSesionPaciente);
        btnCerrarSesionPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PacienteIngreso.this, com.example.hospitalproyectointegrador.Login.class));
                finish();
            }
        });
    }
}
