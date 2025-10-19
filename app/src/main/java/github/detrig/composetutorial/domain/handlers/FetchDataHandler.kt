package github.detrig.composetutorial.domain.handlers

import android.util.Log
import github.detrig.composetutorial.data.NetworkRepository
import github.detrig.uikit.components.screen.ScreenComponent
import github.detrig.uikit.components.screen.ScreenParser
import github.detrig.uikit.components.screen.ScreenState
import github.detrig.uikit.core.Action
import github.detrig.uikit.core.ActionDispatcher
import github.detrig.uikit.core.ActionHandler
import github.detrig.uikit.core.DataBinder
import github.detrig.uikit.core.FetchResponseProcessor
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject

class FetchDataHandler(
    private val repository: NetworkRepository,
    private val dispatcher: ActionDispatcher,
    private val state: ScreenState,
    private val screenComponent: ScreenComponent?,
    private val processors: List<FetchResponseProcessor>
) : ActionHandler<Action.FetchData> {

    override fun canHandle(action: Action): Boolean = action is Action.FetchData

    override suspend fun handle(action: Action.FetchData) {
        try {
            val response = repository.fetch(action.endpoint)
            Log.d("alz-fetch", "response $response")
            val dataJson = Json.parseToJsonElement(response).jsonObject
            Log.d("alz-fetch", "dataJson $dataJson")
            val cartItem = dataJson["cartItems"]?.jsonArray?.firstOrNull()?.jsonObject
            Log.d("alz-fetch", "cartItem $cartItem")
            if (cartItem != null) {
                DataBinder.bindDataToScreen(screenComponent ?: ScreenParser.parse(response), cartItem)
            }

            // Универсальная обработка результата
            //processors.firstOrNull { it.canProcess(action.endpoint) }?.process(response, state)

        } catch (e: Exception) {
            Log.e("alz-fetch", "Error fetching data from ${action.endpoint}: $e", e)
        }
    }
}
