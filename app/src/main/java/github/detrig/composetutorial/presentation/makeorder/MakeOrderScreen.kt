package github.detrig.composetutorial.presentation.makeorder

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import github.detrig.composetutorial.presentation.core.ProvideViewModel
import github.detrig.composetutorial.presentation.core.Screen
import github.detrig.uikit.components.screen.ScreenParser
import github.detrig.uikit.components.screen.ScreenRenderer
import github.detrig.uikit.core.ActionDispatcher


object MakeOrderScreen : Screen {
    @Composable
    override fun Show() {
        val viewModel = (LocalContext.current.applicationContext as ProvideViewModel).viewModel(
            MakeOrderViewModel::class.java
        )
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
                                  "verticalAlignment": "center",
                                  "children": [
                                    {
                                      "type": "checkbox",
                                      "isChecked": "true",
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
                                      "modifier": { "size": { "width": "14", "height": "14" } , "padding": { "start": 4 }, "align": "CenterVertically" },
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
                                      "text": "463",
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
                  "modifier": { "padding": { "start": 12, "end": 12, "top": 16, "bottom": 16 } },
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
                            "targetId": "cart"
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
            
              ]
        
        }
        """

        viewModel.loadScreen(json)

        val dispatcher = remember {
            ActionDispatcher(state = viewModel.screenState,
                navigate = { screenId ->
                    viewModel.navigateToScreenById(screenId)
                }).apply {
                registerDefaultActions()
            }
        }

        ScreenRenderer.Render(viewModel.screenModel, viewModel.screenState, dispatcher = dispatcher)
    }
}