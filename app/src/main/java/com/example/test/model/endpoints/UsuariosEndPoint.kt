package com.example.test.model.endpoints

import com.example.test.model.entities.api.Usuarios
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UsuariosEndPoint {
    @GET("usuarios")
    suspend fun getUser(@Query("user") user: String ): Response<Usuarios>
}