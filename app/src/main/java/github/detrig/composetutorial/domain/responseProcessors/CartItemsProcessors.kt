package github.detrig.composetutorial.domain.responseProcessors

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import github.detrig.uikit.components.screen.ScreenState
import github.detrig.uikit.core.FetchResponseProcessor
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

/**
{
"cartItems": [
{
"id": "item_1",
"checked": true,
"imageUrl": "https://apple-pro.ru/upload/ammina.optimizer/jpg/q80/upload/iblock/0f4/magsafe.jpg",
"price": "4 990 ₽",
"title": "Зарядка MagSafe Charger 15W 1 метр",
"quantity": 1,
"deliveryText": "Купить с доставкой",
"favoriteIcon": "https://www.iconpacks.net/icons/2/free-heart-icon-3510-thumb.png",
"deleteIcon": "https://www.shutterstock.com/image-vector/trashcan-delete-icon-sign-symbol-260nw-2617652319.jpg"
},
{
"id": "item_2",
"checked": false,
"imageUrl": "https://example.com/product2.jpg",
"price": "2 499 ₽",
"title": "Кабель USB-C",
"quantity": 2,
"deliveryText": "Купить с доставкой",
"favoriteIcon": "https://www.iconpacks.net/icons/2/free-heart-icon-3510-thumb.png",
"deleteIcon": "https://www.shutterstock.com/image-vector/trashcan-delete-icon-sign-symbol-260nw-2617652319.jpg"
}
]
}
 */
//class CartItemsProcessor : FetchResponseProcessor {
//    override fun canProcess(endpoint: String) = endpoint.contains("cart")
//
//    override fun process(response: String, state: ScreenState) {
//        val json = Json.decodeFromString<CartData>(response)
//
//        // пример связывания: первый элемент списка -> cart_item_1, второй -> cart_item_2 и т.д.
//        json.cartItems.forEachIndexed { index, item ->
//            state.updateComponent("cart_item_${index + 1}_name", mutableStateOf(item.name))
//            state.updateComponent("cart_item_${index + 1}_price", mutableStateOf(item.price))
//            state.updateComponent("cart_item_${index + 1}_selected", mutableStateOf(item.selected))
//        }
//
//        // обновляем итоговую цену
//        state.updateComponent("totalPrice", mutableStateOf(json.totalPrice))
//    }
//}

class CartItemsProcessor : FetchResponseProcessor {
    override fun canProcess(endpoint: String): Boolean = endpoint.contains("/cart")

    override fun process(response: String, state: ScreenState) {
//        try {
//            val cart = Json.decodeFromString<CartData>(response)
//
//            val cartItem = dataJson["cartItems"]?.jsonArray?.firstOrNull()?.jsonObject
//            if (cartItem != null) {
//                DataBinder.bindDataToScreen(state.screenComponent, cartItem)
//            }
//        } catch (e: Exception) {
//            Log.e("alz-fetch", "Error processing cart", e)
//        }
    }



    private fun replacePlaceholders(template: String, item: CartItem?): String {
        if (item == null) return template
        return template
            .replace("\$title", item.title)
            .replace("\$price", item.price)
            .replace("\$deliveryText", item.deliveryText)
            .replace("\$quantity", item.quantity.toString())
    }

}

@Serializable
data class CartResponse(
    val cartItems: List<CartItem>
)

@Serializable
data class CartItem(
    val id: String,
    val checked: Boolean,
    val imageUrl: String,
    val price: String,
    val title: String,
    val quantity: Int,
    val deliveryText: String,
    val favoriteIcon: String,
    val deleteIcon: String
)