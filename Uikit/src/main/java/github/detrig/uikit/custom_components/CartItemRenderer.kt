package github.detrig.uikit.custom_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import github.detrig.uikit.R
import github.detrig.uikit.states.ScreenState
import github.detrig.uikit.components.utils.toComposeModifier
import github.detrig.uikit.core.Action
import github.detrig.uikit.core.ActionDispatcher
import github.detrig.uikit.core.ActionEvent
import github.detrig.uikit.core.performActionsForEvent
import github.detrig.uikit.custom_components.cart_item.CartItemData

object CartItemRenderer {

    @Composable
    fun Render(component: CartItemComponent, state: ScreenState, dispatcher: ActionDispatcher) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 12.dp),
            verticalAlignment = Alignment.Top
        ) {
            // ✅ Чекбокс
            Checkbox(
                checked = component.isChecked,
                onCheckedChange = { /* TODO: dispatcher.dispatch(...) */ },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFF1976D2),
                    uncheckedColor = Color(0xFF9E9E9E),
                    checkmarkColor = Color.White,
                    disabledCheckedColor = Color(0xFFBDBDBD),
                    disabledUncheckedColor = Color(0xFFBDBDBD)
                ),
                modifier = Modifier
                    .size(19.dp)
                    .align(Alignment.Top)
            )

            // ✅ Картинка товара
            AsyncImage(
                model = component.imageUrl,
                contentDescription = component.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(start = 12.dp)
                    .size(96.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            // ✅ Центральная колонка с названием, ценой и управлением количеством
            Column(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .width(162.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                // 💰 Цена
                Text(
                    text = "${component.price.toInt()} ₽",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                // 🏷️ Название
                Text(
                    text = component.title,
                    fontSize = 14.sp,
                    color = Color.Black,
                    lineHeight = 18.sp,
                    maxLines = 2,
                    modifier = Modifier.padding(top = 2.dp)
                )

                // ➕➖ Управление количеством
                Row(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.White)
                        .padding(horizontal = 14.dp, vertical = 11.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjDibeuSw1J2NHumyfFMISTORQAkpPvZTyMA&s",
                        contentDescription = "minus",
                        contentScale = ContentScale.Inside,
                        modifier = Modifier.size(20.dp)
                    )

                    Text(
                        text = component.quantity.toString(),
                        fontSize = 15.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(start = 18.dp)
                    )

                    AsyncImage(
                        model = "https://cdn-icons-png.flaticon.com/512/7794/7794550.png",
                        contentDescription = "plus",
                        contentScale = ContentScale.Inside,
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .size(20.dp)
                    )
                }

                // 🚚 "Купить с доставкой"
                Text(
                    text = "Купить с доставкой",
                    color = Color(0xFFA168F7),
                    fontSize = 13.sp,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }

            // ✅ Колонка справа: избранное + корзина
            Column(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                AsyncImage(
                    model = "https://www.iconpacks.net/icons/2/free-heart-icon-3510-thumb.png",
                    contentDescription = "favorite",
                    contentScale = ContentScale.Inside,
                    modifier = Modifier.size(28.dp)
                )

                AsyncImage(
                    model = "https://www.shutterstock.com/image-vector/trashcan-delete-icon-sign-symbol-260nw-2617652319.jpg",
                    contentDescription = "delete",
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .size(28.dp)
                )
            }
        }
    }
}
