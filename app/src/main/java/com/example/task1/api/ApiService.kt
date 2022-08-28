package com.example.task1.api

import com.example.task1.ModelTask
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("all_sports.php")
    fun getdata() : Call<ModelTask>
}