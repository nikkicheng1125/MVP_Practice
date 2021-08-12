package com.yiwencheng.mvp_practice

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("auth/login")
    fun loginUser(@Body user: User):Call<LoginResponse>
}