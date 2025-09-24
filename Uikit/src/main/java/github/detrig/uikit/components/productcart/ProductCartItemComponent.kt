package github.detrig.uikit.components.productcart

import github.detrig.uikit.core.Action
import github.detrig.uikit.core.Component
import github.detrig.uikit.core.Style
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("product_cart_item")
data class ProductCardComponent(
    override val id: String? = null,
    override val style: Style? = null,
    override val actions: Map<String, Action>? = null,
    val title: String,
    val imageUrl: String,
    val quantity: Int = 0,
    val price: Int
) : Component()