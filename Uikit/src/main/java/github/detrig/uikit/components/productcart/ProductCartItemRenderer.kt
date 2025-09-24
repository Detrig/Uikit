package github.detrig.uikit.components.productcart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import github.detrig.uikit.components.screen.ScreenState
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import coil.compose.AsyncImage
import github.detrig.uikit.core.ActionDispatcher

object ProductCardRenderer {

    @Composable
    fun Render(component: ProductCardComponent, state: ScreenState, dispatcher: ActionDispatcher) {
        val quantity = state.getValue(component.id + "_quantity") as? Int ?: component.quantity

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(component.style?.padding?.dp ?: 8.dp),
            colors = CardDefaults.cardColors(
                containerColor = component.style?.backgroundColor?.let { Color(it.toColorInt()) }
                    ?: Color.White
            )
        ) {
            Column(modifier = Modifier.padding(8.dp)) {
                AsyncImage(
                    model = component.imageUrl,
                    contentDescription = component.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Название
                Text(
                    text = component.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Количество + кнопки
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Button(onClick = {
                        dispatcher.dispatch(component.actions?.get("decrement") ?: return@Button)
                    }) {
                        Text("-")
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(text = quantity.toString(), fontSize = 16.sp)

                    Spacer(modifier = Modifier.width(8.dp))

                    Button(onClick = {
                        dispatcher.dispatch(component.actions?.get("increment") ?: return@Button)
                    }) {
                        Text("+")
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    // Цена
                    Text(text = "${component.price * quantity} ₽", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Удалить
                Button(
                    onClick = {
                        dispatcher.dispatch(component.actions?.get("delete") ?: return@Button)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) {
                    Text("Удалить", color = Color.White)
                }
            }
        }
    }
}
