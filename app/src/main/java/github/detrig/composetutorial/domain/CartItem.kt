//package github.detrig.composetutorial.domain
//
//import github.detrig.uikit.components.productcart.CartItemData
//import kotlinx.serialization.SerialName
//import kotlinx.serialization.Serializable
//
//@Serializable
//@SerialName("cart_item")
//data class CartItem(
//    val id: String,
//    val title: String,
//    val price: Float,
//    val imageUrl: String,
//    val isChecked: Boolean = false,
//    val isFavorite: Boolean = false,
//    val quantity: Int
//)
//
//data class Store(
//    val name: String,
//    val rating: Double,
//    val reviews: Int,
//    val checked: Boolean,
//    val cartItems: List<CartItem>
//)
//
//fun CartItem.toCartItemData(): CartItemData {
//    return CartItemData(
//        id = id,
//        title = title,
//        price = price,
//        imageUrl = imageUrl,
//        quantity = quantity,
//        isSelected = isChecked,
//        isFavorite = isFavorite
//    )
//}