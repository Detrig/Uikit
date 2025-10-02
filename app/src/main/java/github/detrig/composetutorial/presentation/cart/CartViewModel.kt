package github.detrig.composetutorial.presentation.cart

import androidx.lifecycle.ViewModel

import github.detrig.composetutorial.core.Navigation
import github.detrig.composetutorial.core.NavigationHandlerFromJson
import github.detrig.composetutorial.core.ScreenViewModel
import github.detrig.composetutorial.presentation.makeorder.MakeOrderScreen
import github.detrig.uikit.components.screen.ScreenParser
import github.detrig.uikit.components.screen.ScreenState
import github.detrig.uikit.core.NavigationHandler

class CartViewModel(
    private val navigation: Navigation.Mutable,
    navigationHandler: NavigationHandler
) : ScreenViewModel(navigationHandler) {

//    fun getCartItems(): List<CartItem> {
//        val cartItemsList = listOf(
//            CartItem(
//                id = "1",
//                title = "SHOES AIR MAX",
//                price = 10000.toFloat(),
//                imageUrl = "https://avatars.mds.yandex.net/i?id=e3adb70428848a1379c658244ec0cd2cd420f933-17806471-images-thumbs&n=13",
//                quantity = 1
//            ),
//            CartItem(
//                id = "2",
//                title = "SHOES AIR MAX",
//                price = 2999.toFloat(),
//                imageUrl = "https://avatars.mds.yandex.net/i?id=e3adb70428848a1379c658244ec0cd2cd420f933-17806471-images-thumbs&n=13",
//                quantity = 2
//            ),
//            CartItem(
//                id = "4",
//                title = "sanek",
//                price = 4999.toFloat(),
//                imageUrl = "https://sun9-75.userapi.com/s/v1/ig2/TxiLpgir5MKs6SpRkwen_2iPzTzwNLcxEYZE5aPvev2IytJtDw7dyK8MaGlOZsNXExyjyvgKMwOSX8kL5btOsFVT.jpg?quality=95&as=32x32,48x48,72x72,108x108,160x160,240x240,360x360,480x480,540x540,640x640,720x720,1080x1080,1280x1280,1440x1440,1920x1920&from=bu&cs=1920x0",
//                quantity = 1
//            ),
//            CartItem(
//                id = "5",
//                title = "Provorov",
//                price = 19999.toFloat(),
//                imageUrl = "https://sun9-66.userapi.com/s/v1/ig2/1f2Jxf_B8KgxfEtVqRxa6MtanvOEI3Rqm3yNIV9RMJo5llXudWGK6IdKPTpaqozyBvW420UoOMnb-OESmppWnkAM.jpg?quality=95&as=32x72,48x108,72x161,108x242,160x359,240x538,360x807,480x1076,540x1210,640x1435,720x1614,1080x2421,1142x2560&from=bu&cs=1142x0",
//                quantity = 1
//            )
//        )
//        //screenState.updateComponent("cart_list", cartItemsList.map { it.toCartItemData() })
//
//        return cartItemsList
//    }

    fun mainScreen() {
        navigation.update(MakeOrderScreen)
    }
}
