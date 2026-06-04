package com.irem.pawmatch

import retrofit2.Call
import retrofit2.http.GET

interface PetImageApiService {

    @GET("v1/images/search")
    fun getRandomCatImage(): Call<List<CatImageResponse>>

    @GET("api/breeds/image/random")
    fun getRandomDogImage(): Call<DogImageResponse>
}
