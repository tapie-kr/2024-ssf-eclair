import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tapie.eclair_card.components.atomic.typography.HomeTypography
import com.tapie.eclair_card.data.SharedViewModel
import com.tapie.eclair_card.ui.theme.PurpleColor
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.tapie.eclair_card.R
import com.tapie.eclair_card.components.icon.GetIcon

@Composable
fun LuckCardList(
    sharedViewModel: SharedViewModel,
    cardWidth: Int = 1,
    cardHeight: Int = 1
) {
    val todayLuck by sharedViewModel.todayLuck.observeAsState("")
    val loveLuck by sharedViewModel.loveLuck.observeAsState("")
    val wealthLuck by sharedViewModel.wealthLuck.observeAsState("")
    val healthLuck by sharedViewModel.healthLuck.observeAsState("")
    val num by sharedViewModel.num.observeAsState("")

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(24.dp) // 카드 사이 간격 설정
    ) {
        items(listOf("총운", "연애운", "재물운", "건강운")) { title ->
            val content = when (title) {
                "총운" -> todayLuck
                "연애운" -> loveLuck
                "재물운" -> wealthLuck
                "건강운" -> healthLuck
                else -> ""
            }

            LuckDescription(
                title = title,
                fourIdioms = if (title == "총운") "사자성어" else "",
                content = content,
                num = num,
                width = cardWidth,
                height = cardHeight,
                modifier = Modifier
                    .width(cardWidth.dp)
                    .height(cardHeight.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(PurpleColor)
                    .padding(20.dp)
            )
        }
    }
}

@Composable
fun LuckDescription(
    title: String,
    fourIdioms: String,
    content: String,
    num: String,
    width: Int,
    height: Int,
    modifier: Modifier = Modifier
) {
    val icon = GetIcon(num)

    Box(
        modifier = modifier
            .width(width.dp)
            .height(height.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
            )
            Text(text = title, style = HomeTypography.Todayluck, color = Color.White)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = fourIdioms, style = HomeTypography.Body, color = Color.White)
            Text(text = content, style = HomeTypography.Body, color = Color.White)
        }
    }
}