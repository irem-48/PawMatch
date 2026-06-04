package com.irem.pawmatch

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val catApi: PetImageApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PetImageApiService::class.java)
    }

    val dogApi: PetImageApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://dog.ceo/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PetImageApiService::class.java)
    }
}
