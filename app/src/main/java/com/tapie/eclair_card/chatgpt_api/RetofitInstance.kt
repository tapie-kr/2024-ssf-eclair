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