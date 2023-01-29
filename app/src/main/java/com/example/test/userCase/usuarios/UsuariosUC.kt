package com.example.test.userCase.usuarios

import android.util.Log
import com.example.test.model.endpoints.UsuariosEndPoint
import com.example.test.model.entities.api.Usuarios
import com.example.test.model.repositories.APIRepository

class UsuariosUC {
    suspend fun getUsuario(user: String): Usuarios? {
        var u: Usuarios? = null
        try {
            println("en usuarios UC  $user")
            val service = APIRepository().getUsers()
            val response = service.create(UsuariosEndPoint::class.java).getUser(user)
            if (response.isSuccessful) {
                u = response.body()!!
            } else {
                throw Exception("Fracaso conexion en usuarios UC")
            }
        } catch (e: Exception) {
            Log.d("Error", e.message.toString())
        }
        return u
    }
}