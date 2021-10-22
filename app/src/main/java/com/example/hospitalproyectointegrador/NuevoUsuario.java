package com.example.hospitalproyectointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NuevoUsuario extends AppCompatActivity {

    Button btnNuevoUsuario_Regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevo_usuario);

        btnNuevoUsuario_Regresar= findViewById(R.id.btnNuevoUsuario_Regresar);
        btnNuevoUsuario_Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NuevoUsuario.this, com.example.hospitalproyectointegrador.Login.class));
                finish();
            }
        });
    }
}
