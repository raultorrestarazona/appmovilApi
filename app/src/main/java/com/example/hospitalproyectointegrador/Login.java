package com.example.hospitalproyectointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hospitalproyectointegrador.Interfaces.ApiAdapter;
import com.example.hospitalproyectointegrador.models.LoginRequest;
import com.example.hospitalproyectointegrador.models.LoginResponse;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    Button btnIniciarSesion, btnCrearCuenta;
    EditText username, contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        username = (EditText) findViewById(R.id.edtUsuarioI);
        contraseña = (EditText) findViewById(R.id.edtContraseñaI);
        btnCrearCuenta = findViewById(R.id.btnCrearCuenta);
        btnCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, com.example.hospitalproyectointegrador.NuevoUsuario.class));
                finish();
            }
        });
        btnIniciarSesion = findViewById(R.id.btniniciarSesionLogin);
        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(contraseña.getText().toString())) {
                    Toast.makeText(Login.this, "Username / Password Required", Toast.LENGTH_LONG).show();
                } else {
                    //procced to login
                    login();
                    LoginResponse loginResponse = new LoginResponse();
                    if(loginResponse.getNombre_rol()=="ROLE_PACIENTE"){
                        startActivity(new Intent(Login.this, com.example.hospitalproyectointegrador.PacienteIngreso.class));
                        finish();
                    }
                    else{
                        startActivity(new Intent(Login.this, com.example.hospitalproyectointegrador.DoctorIngreso.class));
                        finish();
                    }
                }

            }
        });
    }
    public Call<LoginResponse> login(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setDni(username.getText().toString());
        loginRequest.setContraseña(contraseña.getText().toString());

        Call<LoginResponse> loginResponseCall = ApiAdapter.getApiService().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(Login.this, "Login Succesful", Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(Login.this, "Throwable"+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
        return loginResponseCall;
    }
}