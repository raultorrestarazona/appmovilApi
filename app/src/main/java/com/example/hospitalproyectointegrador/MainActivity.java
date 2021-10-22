package com.example.hospitalproyectointegrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.hospitalproyectointegrador.Interfaces.ApiAdapter;
import com.example.hospitalproyectointegrador.models.Usuario;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<ArrayList<Usuario>> {
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, com.example.hospitalproyectointegrador.Login.class));
                finish();
            }
        });

        Call<ArrayList<Usuario>> callUser = ApiAdapter.getApiService().getUserResponse();
        callUser.enqueue(this);

    }

    @Override
    public void onResponse(Call<ArrayList<Usuario>> call, Response<ArrayList<Usuario>> response) {
        ArrayList<Usuario> diseases = response.body();
        Log.d("onResponse diseases","Size of diseases => "+ diseases.size());
    }

    @Override
    public void onFailure(Call<ArrayList<Usuario>> call, Throwable t) {

    }
}
