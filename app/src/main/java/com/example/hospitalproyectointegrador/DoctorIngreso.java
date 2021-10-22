package com.example.hospitalproyectointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DoctorIngreso extends AppCompatActivity implements View.OnClickListener {
    Button cerrarSesion = (Button) findViewById(R.id.btnCerrarSesionDoctor);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_ingreso);
    }

    @Override
    public void onClick(View v) {
        if(v==cerrarSesion){
            startActivity(new Intent(DoctorIngreso.this, com.example.hospitalproyectointegrador.Login.class));
            finish();
        }
    }
}
