package com.example.ujk_andika.network
import com.example.ujk_andika.R
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkConfig {
    fun getInterceptop():OkHttpClient{
        val interceptor = HttpLoggingInterceptor();
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient().newBuilder().addInterceptor(interceptor).build()
    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("http://172.10.10.90/UJK_ANDIKA/").client(
            getInterceptop()
        ).addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun service() = getRetrofit().create(CafeService::class.java)
}