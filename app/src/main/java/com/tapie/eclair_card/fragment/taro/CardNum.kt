package com.tapie.eclair_card.fragment.taro

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tapie.eclair_card.components.atomic.Card_0
import com.tapie.eclair_card.components.atomic.Card_1
import com.tapie.eclair_card.components.atomic.Card_2
import com.tapie.eclair_card.components.atomic.Card_3
import com.tapie.eclair_card.components.atomic.Card_4
import com.tapie.eclair_card.components.atomic.Card_5
import com.tapie.eclair_card.components.atomic.Card_6
import com.tapie.eclair_card.components.atomic.Card_7
import com.tapie.eclair_card.components.atomic.Card_8
import com.tapie.eclair_card.components.atomic.Card_9
import com.tapie.eclair_card.components.atomic.Card_10
import com.tapie.eclair_card.components.atomic.Card_11
import com.tapie.eclair_card.components.atomic.Card_12
import com.tapie.eclair_card.components.atomic.Card_13
import com.tapie.eclair_card.components.atomic.Card_14
import com.tapie.eclair_card.components.atomic.Card_15
import com.tapie.eclair_card.components.atomic.Card_16
import com.tapie.eclair_card.components.atomic.Card_17
import com.tapie.eclair_card.components.atomic.Card_18
import com.tapie.eclair_card.components.atomic.Card_19
import com.tapie.eclair_card.components.atomic.Card_20
import com.tapie.eclair_card.components.atomic.Card_21

@Composable
fun DisplayCard(cardNumber: Int, modifier: Modifier = Modifier) {
    when (cardNumber) {
        0 -> Card_0(modifier)
        1 -> Card_1(modifier)
        2 -> Card_2(modifier)
        3 -> Card_3(modifier)
        4 -> Card_4(modifier)
        5 -> Card_5(modifier)
        6 -> Card_6(modifier)
        7 -> Card_7(modifier)
        8 -> Card_8(modifier)
        9 -> Card_9(modifier)
        10 -> Card_10(modifier)
        11 -> Card_11(modifier)
        12 -> Card_12(modifier)
        13 -> Card_13(modifier)
        14 -> Card_14(modifier)
        15 -> Card_15(modifier)
        16 -> Card_16(modifier)
        17 -> Card_17(modifier)
        18 -> Card_18(modifier)
        19 -> Card_19(modifier)
        20 -> Card_20(modifier)
        21 -> Card_21(modifier)
        else -> Card_0(modifier) // 기본 이미지 (예외 처리)
    }
}