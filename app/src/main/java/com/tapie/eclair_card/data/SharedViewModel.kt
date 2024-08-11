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

    private val _todayLuck = MutableLiveData<String>()
    val todayLuck: LiveData<String> get() = _todayLuck

    private val _loveLuck = MutableLiveData<String>()
    val loveLuck: LiveData<String> get() = _loveLuck

    private val _wealthLuck = MutableLiveData<String>()
    val wealthLuck: LiveData<String> get() = _wealthLuck

    private val _healthLuck = MutableLiveData<String>()
    val healthLuck: LiveData<String> get() = _healthLuck

    private val _num = MutableLiveData<String>()
    val num: LiveData<String> get() = _num

    private val _fourIdioms = MutableLiveData<String>()
    val fourIdioms: LiveData<String> get() = _fourIdioms

    private val _selectedCards = MutableLiveData<List<Int>>(emptyList())
    val selectedCards: LiveData<List<Int>> get() = _selectedCards



    fun setSelectedCards(cards: List<Int>) {
        _selectedCards.value = cards
    }


    fun setUserName(name: String) {
        _userName.value = name.trim() // Trim any whitespace
        Log.d("SharedViewModel", "UserName set to: ${_userName.value}")
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

            parseHoroscope(result)
            Log.d("SharedViewModel", "Horoscope fetched: $result")
            onComplete()
        }
    }

    private fun parseHoroscope(horoscope: String) {
        val todayLuckMatch = Regex("- 오늘의 운세: (.*)").find(horoscope)
        val loveLuckMatch = Regex("- 애정운: (.*)").find(horoscope)
        val wealthLuckMatch = Regex("- 재물운: (.*)").find(horoscope)
        val healthLuckMatch = Regex("- 건강운: (.*)").find(horoscope)
        val numLuckMatch = Regex("- 총점: (.*)").find(horoscope)
        val fourIdiomsLuckMatch = Regex("- 사자성어: (.*)").find(horoscope)

        _todayLuck.value = todayLuckMatch?.groupValues?.get(1) ?: ""
        _loveLuck.value = loveLuckMatch?.groupValues?.get(1) ?: ""
        _wealthLuck.value = wealthLuckMatch?.groupValues?.get(1) ?: ""
        _healthLuck.value = healthLuckMatch?.groupValues?.get(1) ?: ""
        _num.value = numLuckMatch?.groupValues?.get(1)?.trim() ?: ""  // Trim any whitespace
        _fourIdioms.value = fourIdiomsLuckMatch?.groupValues?.get(1) ?: ""

        Log.d("SharedViewModel", "Parsed num: ${_num.value}")
    }


    fun addSelectedCard(cardNumber: Int) {
        val currentList = _selectedCards.value ?: emptyList()
        if (currentList.size < 3) { // 최대 3개까지만 선택 가능
            _selectedCards.value = currentList + cardNumber
            Log.d("SharedViewModel", "Card selected: $cardNumber. Current selection: ${_selectedCards.value}")
        }
    }


    fun resetTarotSelection() {
        _selectedCards.value = emptyList()
    }
}