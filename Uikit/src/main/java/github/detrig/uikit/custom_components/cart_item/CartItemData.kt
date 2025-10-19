package github.detrig.uikit.custom_components.cart_item

import kotlinx.serialization.Serializable

@Serializable
data class CartItemData(
    val productId: String,
    val title: String,
    val price: String,
    val quantity: Int,
    val imageUrl: String? = null,
    val isSelected: Boolean = false,
    val isFavorite: Boolean = false
)
