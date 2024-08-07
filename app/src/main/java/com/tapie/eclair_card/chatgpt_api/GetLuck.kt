package com.tapie.eclair_card.chatgpt_api

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.Response

suspend fun getLuck(name: String, birthdate: String): String {
    Log.d("getLuck", "Requesting horoscope for: $name, $birthdate")
    val request = LuckRequest(
        model = "gpt-4",
        messages = listOf(
            Message(role = "system", content = "너는 상세하고 정확한 운세 정보를 제공하는 전문가야."),
            Message(role = "system", content = "사용자에게 불필요한 정보나 인사말 없이 운세 정보만을 제공해야 해."),
            Message(role = "system", content = """
                운세 정보는 다음과 같은 형식으로 제공해야 해:
                - 오늘의 운세: [내용]
                - 애정운: [내용]
                - 재물운: [내용]
                - 건강운: [내용]
                또한, 사용자에게 어울리는 사자성어 제공해줘 사자성어에 대한 설명은 일절 필요 없어.
                
                내용은 한 개당 적어도 
                그리고 내가 이렇게 요청한 내용 외의 내용은 일절 필요 없어 
            """.trimIndent()),
            Message(role = "user", content = "저의 이름은 $name 이고 생년월일은 $birthdate 입니다. 저의 오늘의 운세와 사자성어를 알려주세요.")
        ),
        max_tokens = 1000,
        temperature = 0.9
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