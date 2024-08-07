package com.tapie.eclair_card.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tapie.eclair_card.chatgpt_api.getLuck
import kotlinx.coroutines.launch

class SharedViewModel : ViewModel() {

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> get() = _userName

    private val _birthDate = MutableLiveData<String>()
    val birthDate: LiveData<String> get() = _birthDate

    private val _horoscope = MutableLiveData<String>()
    val horoscope: LiveData<String> get() = _horoscope

    fun setUserName(name: String) {
        _userName.value = name
        Log.d("SharedViewModel", "UserName set to: $name")
    }

    fun setBirthDate(date: String) {
        _birthDate.value = date
        Log.d("SharedViewModel", "BirthDate set to: $date")
    }

    fun fetchHoroscope(onComplete: () -> Unit) {
        viewModelScope.launch {
            val name = _userName.value ?: ""
            val birthdate = _birthDate.value ?: ""
            Log.d("SharedViewModel", "Fetching horoscope for: $name, $birthdate")
            val result = getLuck(name, birthdate)
            _horoscope.value = result
            Log.d("SharedViewModel", "Horoscope fetched: $result")
            onComplete()
        }
    }
}