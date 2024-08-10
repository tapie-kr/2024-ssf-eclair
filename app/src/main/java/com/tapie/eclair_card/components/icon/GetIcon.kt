package com.tapie.eclair_card.components.icon

import com.tapie.eclair_card.R

fun GetIcon(num: String): Int {
    return when (num.trim()) {
        "1" -> R.drawable.very_bad
        "2" -> R.drawable.bad
        "3" -> R.drawable.normal
        "4" -> R.drawable.smile_little
        "5" -> R.drawable.smile
        else -> R.drawable.loading
    }
}