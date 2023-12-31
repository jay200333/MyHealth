package com.example.myhealth

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NinjasApiService {
    @GET("exercises")
    fun getExercises(
        @Query("X-Api-Key") apiKey: String = "j2jhttQKs6n5erStQhmydXhjwFAcMngr9SdQDFyk"
    ): Call<List<Exercise>>
}