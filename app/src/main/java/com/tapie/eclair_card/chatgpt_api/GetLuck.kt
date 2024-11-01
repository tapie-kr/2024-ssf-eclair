package com.tapie.eclair_card.chatgpt_api

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.Response

suspend fun getLuck(name: String, birthdate: String): String {
    Log.d("getLuck", "Requesting horoscope for: $name, $birthdate")
    val request = LuckRequest(
        model = "gpt-4o",
        messages = listOf(
            Message(role = "system", content = "너는 상세하고 정확한 운세 정보를 제공하는 전문가야."),
            Message(role = "system", content = "사용자에게 불필요한 정보나 인사말 없이 운세 정보만을 제공해야 해."),
            Message(role = "system", content = """
                오늘의 운세, 애정운, 재물운, 건강운을 평가해서 점수로 이를 나타내줘 점수는 1, 2, 3, 4, 5 중 하나로 해줘 1이 제일 안 좋은 경우이고 5가 제일 좋은 경우야 총점은 무조건 1, 2, 3, 4, 5중 하냐야 꼭 기억해 각각의 운에 점수를 정하라는게 아니라 각각의 운들을 평가해서 총점의 점수를 정하라는 거야 
                또한, 사용자에게 어울리는 사자성어 제공해줘 사자성어에 대한 설명은 일절 필요 없어.
                운세 정보는 다음과 같은 형식으로 제공해야 해:
                - 오늘의 운세: [내용]
                - 애정운: [내용]
                - 재물운: [내용]
                - 건강운: [내용]
                - 총점: [숫자]
                - 사자성어 
                사자성어는 설명이 필요 없어 그저 사자성어 한국어만 줘
                그리고 내가 이렇게 요청한 내용 외의 내용은 일절 필요 없어 그러니까 사자성어는 한국어 4단어만 주면 되는거야 이해했지?
            """.trimIndent()),
            Message(role = "user", content = "저의 이름은 $name 이고 생년월일은 $birthdate 입니다. 저의 오늘의 운세와 사자성어를 알려주세요.")
        ),
        max_tokens = 1000,
        temperature = 0.9,
    )

    return withContext(Dispatchers.IO) {
        val response = RetrofitInstance.api.getLuck(request)
        if (response.isSuccessful) {
            val result = response.body()?.choices?.firstOrNull()?.message?.content?.trim()
            if (result.isNullOrEmpty()) {
                Log.d("getLuck", "Horoscope result: Failed to get horoscope")
                "Failed to get horoscope"
            } else {
                Log.d("getLuck", "Horoscope result: $result")
                result
            }
        } else {
            val errorBody = response.errorBody()?.string()
            val errorMessage = if (errorBody != null) {
                val jsonError = JSONObject(errorBody)
                val error = jsonError.optJSONObject("error")
                error?.optString("message") ?: "Failed to get horoscope"
            } else {
                "Failed to get horoscope"
            }
            Log.e("getLuck", errorMessage ?: "Unknown error")
            errorMessage
        }
    }
}