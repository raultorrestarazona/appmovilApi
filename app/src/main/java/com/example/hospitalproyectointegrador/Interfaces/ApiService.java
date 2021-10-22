package com.example.hospitalproyectointegrador.Interfaces;

import com.example.hospitalproyectointegrador.models.LoginRequest;
import com.example.hospitalproyectointegrador.models.LoginResponse;
import com.example.hospitalproyectointegrador.models.Rol;
import com.example.hospitalproyectointegrador.models.Usuario;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("roles")
    Call<ArrayList<Rol>> getRolResponse();

    @GET("usuario")
    Call<ArrayList<Usuario>> getUserResponse();

    @POST("usuario/login")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);

}
