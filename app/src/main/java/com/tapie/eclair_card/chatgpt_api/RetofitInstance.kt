package com.tapie.eclair_card.chatgpt_api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {
    private const val API_KEY = "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"

    private val client = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $API_KEY")
                .build()
            chain.proceed(request)
        }
        .build()

    val api: LuckApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.openai.com/v1/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LuckApiService::class.java)
    }
}