package github.detrig.uikit.custom_components.lazy_column

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import github.detrig.uikit.states.ScreenState
import github.detrig.uikit.components.utils.toComposeModifier
import github.detrig.uikit.core.ActionDispatcher
import github.detrig.uikit.custom_components.CartItemComponent
import github.detrig.uikit.custom_components.CartItemRenderer
import github.detrig.uikit.states.DataState

object LazyColumnRenderer {

    @Composable
    fun Render(component: LazyColumnComponent, state: ScreenState, dataState: DataState, dispatcher: ActionDispatcher) {
        val realItems = dataState.getList(component.template).orEmpty()

        val items = remember {
            listOf(
                CartItemComponent(
                    id = "1",
                    title = "Зарядка MagSafe Charger 15W 1 м",
                    price = 4990f,
                    imageUrl = "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/MHXH3",
                ),
                CartItemComponent(
                    id = "2",
                    title = "Чехол для iPhone 15",
                    price = 2990f,
                    imageUrl = "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/MHXH3",
                ),
                CartItemComponent(
                    id = "3",
                    title = "AirPods Pro 2",
                    price = 24990f,
                    imageUrl = "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/MHXH3",
                    isChecked = true,
                    isFavorite = true
                )
            )
        }

        LazyColumn(
            modifier = component.modifier?.toComposeModifier() ?: Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(realItems) { item ->
                when (component.template) {
                  //  "cartItem" -> CartItemRenderer.Render(item, state, dispatcher)
                    else -> Text("Unknown template: ${component.template}")
                }
            }
        }
    }
}
