package github.detrig.composetutorial.domain.responseProcessors

import androidx.compose.runtime.mutableStateOf
import github.detrig.uikit.components.screen.ScreenState
import github.detrig.uikit.core.FetchResponseProcessor
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

/**
    {
    "cartItems": [
    { "name": "SHOES AIR MAX", "price": "2490 ₽", "selected": true },
    { "name": "T-SHIRT", "price": "890 ₽", "selected": false }
    ],
    "totalPrice": "3380 ₽"
    }
 */
class CartItemsProcessor : FetchResponseProcessor {
    override fun canProcess(endpoint: String) = endpoint.contains("cart")

    override fun process(response: String, state: ScreenState) {
        val json = Json.decodeFromString<CartData>(response)

        // пример связывания: первый элемент списка -> cart_item_1, второй -> cart_item_2 и т.д.
        json.cartItems.forEachIndexed { index, item ->
            state.updateComponent("cart_item_${index + 1}_name", mutableStateOf(item.name))
            state.updateComponent("cart_item_${index + 1}_price", mutableStateOf(item.price))
            state.updateComponent("cart_item_${index + 1}_selected", mutableStateOf(item.selected))
        }

        // обновляем итоговую цену
        state.updateComponent("totalPrice", mutableStateOf(json.totalPrice))
    }
}

@Serializable
data class CartData(
    val cartItems: List<CartItemData>,
    val totalPrice: String
)

@Serializable
data class CartItemData(
    val name: String,
    val price: String,
    val selected: Boolean
)