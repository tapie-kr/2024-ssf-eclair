package com.tapie.eclair_card.chatgpt_api

data class LuckRequest(
    val model: String,
    val messages: List<Message>,
    val max_tokens: Int,
    val temperature: Double
)