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