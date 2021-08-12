package com.yiwencheng.mvp_practice

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class Module {
    @Provides
    fun getRetrofitService():ApiService{
        return Retrofit.Builder()
            .baseUrl("https://apolis-property-management.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}