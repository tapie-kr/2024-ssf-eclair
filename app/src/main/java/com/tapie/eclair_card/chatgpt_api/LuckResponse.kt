package com.tapie.eclair_card.chatgpt_api

data class LuckResponse(
    val choices: List<Choice>
)

data class Choice(
    val message: Message
)

data class Message(
    val role: String,
    val content: String
)