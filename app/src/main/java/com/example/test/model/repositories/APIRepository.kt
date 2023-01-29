package com.example.test.model.repositories

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class APIRepository {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://copa22.medeiro.tech/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getUsers(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dev-z6l996sb741760k.api.raw-labs.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}