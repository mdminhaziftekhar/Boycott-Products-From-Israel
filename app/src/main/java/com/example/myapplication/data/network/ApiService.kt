package com.example.myapplication.data.network

import com.example.myapplication.data.model.ProductResponse
import retrofit2.http.GET

interface ApiService {
    @GET("api/brands?sort[0]=priority:desc&sort[1]=name:asc&pagination[limit]=500&populate=alternative")
    suspend fun getProducts(): ProductResponse
}

