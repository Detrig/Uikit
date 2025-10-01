package github.detrig.composetutorial.presentation.cart

import android.widget.CheckBox
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import github.detrig.composetutorial.R
import github.detrig.composetutorial.presentation.cart.BaseComponents.BottomCartBar
import github.detrig.composetutorial.presentation.cart.BaseComponents.QuantitySelector
import github.detrig.composetutorial.presentation.core.ProvideViewModel
import github.detrig.composetutorial.presentation.core.Screen
import github.detrig.uikit.components.screen.ScreenRenderer
import github.detrig.uikit.core.Action
import github.detrig.uikit.core.ActionDispatcher


//object CartScreen : Screen {
//
//    @Composable
//    override fun Show() {
//        val viewModel =
//            (LocalContext.current.applicationContext as ProvideViewModel).viewModel(CartViewModel::class.java)
//
//        val stores = listOf(
//            Store(
//                name = "Pear Store",
//                rating = 4.8,
//                reviews = 634,
//                checked = true,
//                cartItems = viewModel.getCartItems()
//            ),
//            Store(
//                name = "Banana Shop",
//                rating = 4.6,
//                reviews = 321,
//                checked = false,
//                cartItems = viewModel.getCartItems()
//            )
//        )
//
//        Scaffold(
//            topBar = {
//                Column(
//                    modifier = Modifier.background(Color.White)
//                ) {
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//
//                    ) {
//                        Box(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                        ) {
//                            Text(
//                                text = "Корзина",
//                                textAlign = TextAlign.Center,
//                                fontSize = 20.sp,
//                                color = Color.Black,
//                                modifier = Modifier
//                                    .align(Alignment.TopCenter)
//                                    .padding(top = 14.dp)
//                            )
//
//                            IconButton(
//                                onClick = { },
//                                modifier = Modifier
//                                    .align(Alignment.TopStart)
//                                    .padding(start = 14.dp, top = 12.dp)
//                                    .size(24.dp)
//                            ) {
//                                Icon(
//                                    painter = painterResource(R.drawable.img),
//                                    modifier = Modifier.fillMaxSize(),
//                                    contentDescription = null
//                                )
//                            }
//                        }
//
//                    }
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)
//                    ) {
//                        Checkbox(
//                            modifier = Modifier
//                                .size(21.dp)
//                                .align(Alignment.CenterVertically),
//                            checked = true,
//                            onCheckedChange = {},
//                        )
//
//                        Text(
//                            modifier = Modifier
//                                .padding(start = 8.dp)
//                                .align(Alignment.CenterVertically),
//                            text = "Выбрать всё",
//                            fontSize = 16.sp
//                        )
//
//                        Spacer(modifier = Modifier.weight(1f))
//
//                        Text(
//                            text = "Удалить (3)",
//                            color = Color(0xFF0099F7),
//                            modifier = Modifier
//                                .align(Alignment.CenterVertically)
//                                .clickable { }
//                        )
//                    }
//                }
//            },
//            bottomBar = {
//                BottomCartBar(
//                    totalPrice = 12450,
//                    onCheckoutClick = { /* TODO: переход к оплате */ }
//                )
//            }
//        ) { innerPadding ->
//            LazyColumn(
//                contentPadding = innerPadding,
//                modifier = Modifier.fillMaxSize()
//            ) {
//                stores.forEach { store ->
//                    item {
//                        StoreHeader(store)
//                    }
//
//                    items(store.cartItems) { product ->
//                        CartItem(product)
//                    }
//                }
//            }
//        }
//
//
//    }
//
//
//}
//
//
//@Composable
//fun CartItem(item: CartItem) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth(),
//        colors = CardDefaults.cardColors(containerColor = Color.White)
//    ) {
//        Row(
//            verticalAlignment = Alignment.Top,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 16.dp, end = 16.dp, bottom = 8.dp, top = 8.dp)
//        ) {
//            Checkbox(
//                modifier = Modifier.size(21.dp),
//                checked = true,
//                onCheckedChange = {},
//            )
//
//            AsyncImage(
//                model = item.imageUrl,
//                contentDescription = item.title,
//                modifier = Modifier
//                    .size(96.dp)
//                    .padding(start = 8.dp)
//                    .clip(RoundedCornerShape(12.dp)),
//                contentScale = ContentScale.Crop
//            )
//
//            Spacer(modifier = Modifier.width(10.dp))
//
//            Column(
//                modifier = Modifier.weight(1f)
//            ) {
//                Text(
//                    "${item.price * item.quantity} ₽",
//                    fontWeight = FontWeight.Bold
//                )
//
//                Text(
//                    item.title,
//                    color = Color.Gray,
//                    maxLines = 2,
//                    overflow = TextOverflow.Ellipsis
//                )
//
//                Spacer(modifier = Modifier.height(8.dp))
//
//                QuantitySelector(
//                    quantity = item.quantity,
//                    onIncrement = { /* увеличить */ },
//                    onDecrement = { /* уменьшить */ }
//                )
//
//                Spacer(modifier = Modifier.height(10.dp))
//
//                ClickableText(
//                    text = AnnotatedString("Купить с доставкой"),
//                    modifier = Modifier.padding(8.dp),
//                    onClick = { }
//                )
//            }
//
//            Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                IconButton(onClick = { }) {
//                    Icon(Icons.Default.FavoriteBorder, contentDescription = "Favorite")
//                }
//                IconButton(onClick = { }) {
//                    Icon(Icons.Default.Delete, contentDescription = "Delete")
//                }
//            }
//        }
//    }
//}
//
//
//@Composable
//fun StoreHeader(store: Store) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 12.dp)
//    ) {
//        Checkbox(
//            modifier = Modifier
//                .size(21.dp)
//                .align(Alignment.CenterVertically),
//            checked = true,
//            onCheckedChange = {},
//        )
//
//        Text(
//            modifier = Modifier
//                .padding(start = 8.dp),
//            text = "${store.name}",
//            fontSize = 24.sp,
//            fontWeight = FontWeight.Bold
//        )
//
//        Icon(
//            painter = painterResource(R.drawable.img_1),
//            modifier = Modifier
//                .size(14.dp)
//                .align(Alignment.CenterVertically)
//                .padding(start = 4.dp),
//            contentDescription = null,
//            tint = Color.Green
//        )
//
//        Text(
//            modifier = Modifier
//                .padding(start = 2.dp)
//                .align(Alignment.CenterVertically),
//            text = "${store.rating}",
//            fontSize = 16.sp,
//            fontWeight = FontWeight.Normal
//        )
//
//        Text(
//            modifier = Modifier
//                .padding(start = 2.dp)
//                .align(Alignment.CenterVertically),
//            text = "(${store.reviews})",
//            fontSize = 16.sp,
//            color = Color(0xFFA3A3A3),
//            fontWeight = FontWeight.Normal,
//
//        )
//
//    }

object CartScreen : Screen {
    @Composable
    override fun Show() {
        val viewModel =
            (LocalContext.current.applicationContext as ProvideViewModel).viewModel(CartViewModel::class.java)

        val json = """
        {
          "type": "screen",
          "id": "cart_screen",
          "name": "CartScreen",
          "background": "#FFFFFF",
          "topBar": [
          {
                "type": "row",
                 "children": [
                    {
                                  "type": "row",
                                  "modifier": {
                                    "fillMaxWidth": true,
                                    "padding": { "start": 16, "end": 16, "top": 8, "bottom": 12 }
                                  },
                                  "verticalAlignment": "centerVertically",
                                  "horizontalAlignment": "start",
                                  "children": [
                                    {
                                      "type": "checkbox",
                                      "isChecked": "true",
                                      "colors": { "checkedColor": "#000000", "uncheckedColor": "#000000", "disableColor": "#808080" },
                                      "modifier": { "size": { "width": "21", "height": "21" } }
                                    },
                                    {
                                      "type": "text",
                                      "text": "PearStore",
                                      "style": { "fontSize": 24, "fontWeight": "bold" },
                                      "modifier": { "padding": { "start": 8 } }
                                    },
                                    {
                                      "type": "icon",
                                      "icon": "star",
                                      "modifier": { "size": { "width": "14", "height": "14" } , "padding": { "start": 8 }, "align": "CenterVertically" },
                                      "tint": "#00FF00"
                                    },
                                    {
                                      "type": "text",
                                      "text": "4.8",
                                      "style": { "fontSize": 16, "fontWeight": "normal" },
                                      "modifier": { "padding": { "start": 2 } }
                                    },
                                    {
                                      "type": "text",
                                      "text": "(463)",
                                      "style": { "fontSize": 16, "fontWeight": "normal", "color": "#A3A3A3" },
                                      "modifier": { "padding": { "start": 2 } },
                                      "format": "(%s)"
                                    }
                                  ]
                                }
                 ]
            }
          ],
          "bottomBar": [
             {
              "type": "box",
              "shape": { "topStart": 16, "topEnd": 16 },
              "shadow": { "elevation": 8 },
              "background": "#FFFFFF",
              "children": [
                {
                  "type": "row",
                  "modifier": { "padding": { "start": 12, "end": 12 } },
                  "children": [
                    {
                      "type": "column",
                      "children": [
                        { "type": "text", "text": "3 товара", "style": { "fontSize": 12 } },
                        {
                          "type": "text",
                          "text": "12450 ₽",
                          "style": { "fontSize": 20, "fontWeight": "bold" }
                        }
                      ]
                    },
                    { 
                        "type": "spacer",
                        "modifier": { "weight": 1  }
                    },
                    {
                      "type": "button",
                      "text": "Оформить доставку",
                      "actions": [
                        {
                            "action": "navigate",
                            "targetId": "make_order"
                            }
                      ],
                      "style": {
                        "background": "#965EEB",
                        "textColor": "#FFFFFF",
                        "shape": { "cornerRadius": 12 }
                      },
                      "modifier": { "height": "48" },
                      "onClick": "checkout"
                    }
                  ]
                }
              ]
              }
          ],
          "content": [
            {
              "type": "card",
              "id": "cart_item",
              "modifier": {
                "fillMaxWidth": true,
                "padding": { "top": 8, "bottom": 8 }
              },
              "background": "#FFFFFF",
              "shape": { "cornerRadius": 12 },
              "children": [
                {
                  "type": "row",
                  "verticalAlignment": "top",
                  "modifier": {
                      "fillMaxWidth": true,
                      "padding": { "start": 16, "end": 16, "top": 8, "bottom": 8 }
                  },
                  "children": [
                    {
                      "type": "checkbox",
                      "isChecked": true,
                      "colors": { "checkedColor": "#000000", "uncheckedColor": "#000000", "disableColor": "#808080" },
                      "modifier": { "size": { "width": "21", "height": "21" } }
                    },
                    {
                      "type": "image",
                      "url": "https://sun9-77.userapi.com/s/v1/ig2/KeExlUQUq5eKWjUqliuzv6J4o84ppdJVAV7arT8fw5yE4cltAaSHvPtTJvfA9w7dJxx3yrXijPaghdvqRc0_6m0n.jpg?quality=95&as=32x43,48x64,72x96,108x144,160x213,240x320,360x480,480x640,540x720,640x853,720x960,1080x1440&from=bu&cs=1080x0",
                      "contentScale": "Crop",
                      "modifier": {
                        "size": { "width": "96", "height": "96" },
                        "padding": { "start": 12, "end": 12 },
                        "clip": { "cornerRadius": 12 }
                      }
                    },
                    {
                      "type": "spacer",
                      "modifier": { "height": "10" }
                    },
                    {
                      "type": "column",
                      "modifier": { "weight": 1 },
                      "children": [
                        {
                          "type": "text",
                          "text": "2490 ₽",
                          "style": { "fontWeight": "bold", "fontSize": 16 }
                        },
                        {
                          "type": "text",
                          "text": "SHOES AIR MAX",
                          "style": { "color": "#888888", "fontSize": 14 },
                          "maxLines": 2,
                          "overflow": "ellipsis"
                        },
                        {
                          "type": "spacer",
                          "modifier": { "height": "8" }
                        },
                        {
                          "id": "quantitySelector",
                          "type": "row",
                          "children": [
                            {
                              "type": "row",
                              "modifier": {
                                "clip": { "cornerRadius": 8 },
                                "background": "#F0F0F0",
                                "padding": { "top": 12, "bottom": 6 }
                              },
                              "children": [
                                {
                                  "type": "box",
                                  "modifier": {
                                    "padding": { "start": 12, "end": 12, "top": 6, "bottom": 6 },
                                    "clickable": true
                                  },
                                  "children": [
                                    { "type": "text", "text": "-", "style": { "fontSize": 18, "fontWeight": "bold" } }
                                  ]
                                },
                                {
                                  "type": "text",
                                  "text": "1",
                                  "style": { "fontSize": 16, "fontWeight": "medium" },
                                  "modifier": { "padding": { "start": 12, "end": 12, "top": 6 } }
                                },
                                {
                                  "type": "box",
                                  "modifier": {
                                    "padding": { "start": 12, "end": 12, "top": 6, "bottom": 6 },
                                    "clickable": true
                                  },
                                  "children": [
                                    { "type": "text", "text": "+", "style": { "fontSize": 18, "fontWeight": "bold" } }
                                  ]
                                }
                              ]
                            }
                          ]
                       },
                        {
                            "type": "spacer",
                            "modifier": { "height": "10" }
                         },
                        {
                          "type": "text",
                          "text": "Купить с доставкой",
                          "style": { "color": "#0099F7", "fontSize": 14 },
                          "modifier": { "padding": { "top": 8, "bottom": 8 } }
                        }
                      ]
                    },
                    {
                      "type": "row",
                      "id": "icons column",
                      "children": [
                        { "type": "spacer", "modifier": { "weight": 1 } },
                        {
                          "type": "column",
                          "children": [
                            { "type": "icon", "icon": "favorite_border" },
                            {
                              "type": "icon",
                              "icon": "delete",
                              "actions": [
                                { "action": "showSnackbar", "targetId": "deleteCartItemSnackbar" }
                              ]
                            }
                          ]
                        }
                      ]
                    }
                  ]
                }
              ]
        },
        {
              "type": "card",
              "id": "cart_item",
              "modifier": {
                "fillMaxWidth": true,
                "padding": { "top": 8, "bottom": 8 }
              },
              "background": "#FFFFFF",
              "shape": { "cornerRadius": 12 },
              "children": [
                {
                  "type": "row",
                  "verticalAlignment": "top",
                  "modifier": {
                      "fillMaxWidth": true,
                      "padding": { "start": 16, "end": 16, "top": 8, "bottom": 8 }
                  },
                  "children": [
                    {
                      "type": "checkbox",
                      "isChecked": true,
                      "colors": { "checkedColor": "#000000", "uncheckedColor": "#000000", "disableColor": "#808080" },
                      "modifier": { "size": { "width": "21", "height": "21" } }
                    },
                    {
                      "type": "image",
                      "url": "https://sun9-77.userapi.com/s/v1/ig2/KeExlUQUq5eKWjUqliuzv6J4o84ppdJVAV7arT8fw5yE4cltAaSHvPtTJvfA9w7dJxx3yrXijPaghdvqRc0_6m0n.jpg?quality=95&as=32x43,48x64,72x96,108x144,160x213,240x320,360x480,480x640,540x720,640x853,720x960,1080x1440&from=bu&cs=1080x0",
                      "contentScale": "Crop",
                      "modifier": {
                        "size": { "width": "96", "height": "96" },
                        "padding": { "start": 12, "end": 12 },
                        "clip": { "cornerRadius": 12 }
                      }
                    },
                    {
                      "type": "spacer",
                      "modifier": { "height": "10" }
                    },
                    {
                      "type": "column",
                      "modifier": { "weight": 1 },
                      "children": [
                        {
                          "type": "text",
                          "text": "2490 ₽",
                          "style": { "fontWeight": "bold", "fontSize": 16 }
                        },
                        {
                          "type": "text",
                          "text": "SHOES AIR MAX",
                          "style": { "color": "#888888", "fontSize": 14 },
                          "maxLines": 2,
                          "overflow": "ellipsis"
                        },
                        {
                          "type": "spacer",
                          "modifier": { "height": "8" }
                        },
                        {
                          "id": "quantitySelector",
                          "type": "row",
                          "children": [
                            {
                              "type": "row",
                              "modifier": {
                                "clip": { "cornerRadius": 8 },
                                "background": "#F0F0F0",
                                "padding": { "top": 12, "bottom": 6 }
                              },
                              "children": [
                                {
                                  "type": "box",
                                  "modifier": {
                                    "padding": { "start": 12, "end": 12, "top": 6, "bottom": 6 },
                                    "clickable": true
                                  },
                                  "children": [
                                    { "type": "text", "text": "-", "style": { "fontSize": 18, "fontWeight": "bold" } }
                                  ]
                                },
                                {
                                  "type": "text",
                                  "text": "1",
                                  "style": { "fontSize": 16, "fontWeight": "medium" },
                                  "modifier": { "padding": { "start": 12, "end": 12, "top": 6 } }
                                },
                                {
                                  "type": "box",
                                  "modifier": {
                                    "padding": { "start": 12, "end": 12, "top": 6, "bottom": 6 },
                                    "clickable": true
                                  },
                                  "children": [
                                    { "type": "text", "text": "+", "style": { "fontSize": 18, "fontWeight": "bold" } }
                                  ]
                                }
                              ]
                            }
                          ]
                       },
                        {
                            "type": "spacer",
                            "modifier": { "height": "10" }
                         },
                        {
                          "type": "text",
                          "text": "Купить с доставкой",
                          "style": { "color": "#0099F7", "fontSize": 14 },
                          "modifier": { "padding": { "top": 8, "bottom": 8 } }
                        }
                      ]
                    },
                    {
                      "type": "row",
                      "id": "icons column",
                      "children": [
                        { "type": "spacer", "modifier": { "weight": 1 } },
                        {
                          "type": "column",
                          "children": [
                            { "type": "icon", "icon": "favorite_border" },
                            {
                              "type": "icon",
                              "icon": "delete",
                              "actions": [
                                { "action": "showSnackbar", "targetId": "deleteCartItemSnackbar" }
                              ]
                            }
                          ]
                        }
                      ]
                    }
                  ]
                }
              ]
        },
        {
              "type": "card",
              "id": "cart_item",
              "modifier": {
                "fillMaxWidth": true,
                "padding": { "top": 8, "bottom": 8 }
              },
              "background": "#FFFFFF",
              "shape": { "cornerRadius": 12 },
              "children": [
                {
                  "type": "row",
                  "verticalAlignment": "top",
                  "modifier": {
                      "fillMaxWidth": true,
                      "padding": { "start": 16, "end": 16, "top": 8, "bottom": 8 }
                  },
                  "children": [
                    {
                      "type": "checkbox",
                      "isChecked": true,
                      "colors": { "checkedColor": "#000000", "uncheckedColor": "#000000", "disableColor": "#808080" },
                      "modifier": { "size": { "width": "21", "height": "21" } }
                    },
                    {
                      "type": "image",
                      "url": "https://sun9-77.userapi.com/s/v1/ig2/KeExlUQUq5eKWjUqliuzv6J4o84ppdJVAV7arT8fw5yE4cltAaSHvPtTJvfA9w7dJxx3yrXijPaghdvqRc0_6m0n.jpg?quality=95&as=32x43,48x64,72x96,108x144,160x213,240x320,360x480,480x640,540x720,640x853,720x960,1080x1440&from=bu&cs=1080x0",
                      "contentScale": "Crop",
                      "modifier": {
                        "size": { "width": "96", "height": "96" },
                        "padding": { "start": 12, "end": 12 },
                        "clip": { "cornerRadius": 12 }
                      }
                    },
                    {
                      "type": "spacer",
                      "modifier": { "height": "10" }
                    },
                    {
                      "type": "column",
                      "modifier": { "weight": 1 },
                      "children": [
                        {
                          "type": "text",
                          "text": "2490 ₽",
                          "style": { "fontWeight": "bold", "fontSize": 16 }
                        },
                        {
                          "type": "text",
                          "text": "SHOES AIR MAX",
                          "style": { "color": "#888888", "fontSize": 14 },
                          "maxLines": 2,
                          "overflow": "ellipsis"
                        },
                        {
                          "type": "spacer",
                          "modifier": { "height": "8" }
                        },
                        {
                          "id": "quantitySelector",
                          "type": "row",
                          "children": [
                            {
                              "type": "row",
                              "modifier": {
                                "clip": { "cornerRadius": 8 },
                                "background": "#F0F0F0",
                                "padding": { "top": 12, "bottom": 6 }
                              },
                              "children": [
                                {
                                  "type": "box",
                                  "modifier": {
                                    "padding": { "start": 12, "end": 12, "top": 6, "bottom": 6 },
                                    "clickable": true
                                  },
                                  "children": [
                                    { "type": "text", "text": "-", "style": { "fontSize": 18, "fontWeight": "bold" } }
                                  ]
                                },
                                {
                                  "type": "text",
                                  "text": "1",
                                  "style": { "fontSize": 16, "fontWeight": "medium" },
                                  "modifier": { "padding": { "start": 12, "end": 12, "top": 6 } }
                                },
                                {
                                  "type": "box",
                                  "modifier": {
                                    "padding": { "start": 12, "end": 12, "top": 6, "bottom": 6 },
                                    "clickable": true
                                  },
                                  "children": [
                                    { "type": "text", "text": "+", "style": { "fontSize": 18, "fontWeight": "bold" } }
                                  ]
                                }
                              ]
                            }
                          ]
                       },
                        {
                            "type": "spacer",
                            "modifier": { "height": "10" }
                         },
                        {
                          "type": "text",
                          "text": "Купить с доставкой",
                          "style": { "color": "#0099F7", "fontSize": 14 },
                          "modifier": { "padding": { "top": 8, "bottom": 8 } }
                        }
                      ]
                    },
                    {
                      "type": "row",
                      "id": "icons column",
                      "children": [
                        { "type": "spacer", "modifier": { "weight": 1 } },
                        {
                          "type": "column",
                          "children": [
                            { "type": "icon", "icon": "favorite_border" },
                            {
                              "type": "icon",
                              "icon": "delete",
                              "actions": [
                                { "action": "showSnackbar", "targetId": "deleteCartItemSnackbar" }
                              ]
                            }
                          ]
                        }
                      ]
                    }
                  ]
                }
              ]
        },
        {
          "type": "button",
          "id": "openPromo",
          "text": "Открыть купон",
          "actions": [
            { "action": "showBottomSheet", "targetId": "promoSheet" }
          ]
        },
        {
          "type": "bottomSheet",
          "id": "promoSheet",
          "dismissible": true,
          "children": [
            {
              "type": "column",
              "modifier": { "padding": { "start": 16, "end": 16, "top": 24, "bottom": 24 } },
              "children": [
                {
                  "type": "text",
                  "text": "Хотите скидку 10%?",
                  "style": { "fontSize": 20, "fontWeight": "bold" },
                  "modifier": { "padding": { "bottom": 12 } }
                },
                {
                  "type": "textField",
                  "id": "emailInput",
                  "placeholder": "Введите email",
                  "singleLine": true,
                  "style": { "fontSize": 16, "color": "#000000" },
                  "actions": [
                    { "action": "set_value", "targetId": "emailInput" }
                  ]
                },
                {
                  "type": "button",
                  "text": "Получить купон",
                  "style": {
                    "background": "#965EEB",
                    "textColor": "#FFFFFF",
                    "shape": { "cornerRadius": 12 }
                  },
                  "modifier": { "height": "48", "fillMaxWidth": true },
                  "actions": [
                    { "action": "showSnackbar", "targetId": "deleteCartItemSnackbar" }
                  ]
                }
              ]
            }
          ]
        }
              ],
              "snackbars": [
                {
                  "type": "snackbar",
                  "id": "deleteCartItemSnackbar",
                  "text": "Товар удалён из корзины",
                  "actionText": "Вернуть",
                  "actions": [
                    { "action": "restoreItem", "targetId": "cart_item" }
                  ]
                }
              ]
        }
        """

        viewModel.loadScreen(json)


        val dispatcher = remember {
            ActionDispatcher(state = viewModel.screenState) { screenId ->
                viewModel.navigateToScreenById(screenId)
            }.apply {
                registerDefaultActions()
            }
        }


        ScreenRenderer.Render(
            viewModel.screenModel,
            viewModel.screenState,
            dispatcher
        )

    }

}
