package com.tapie.eclair_card.chatgpt_api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LuckApiService {
    @Headers("Content-Type: application/json")
    @POST("chat/completions")
    suspend fun getLuck(@Body request: LuckRequest): Response<LuckResponse>
}