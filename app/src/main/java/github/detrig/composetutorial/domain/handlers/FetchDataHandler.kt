package github.detrig.composetutorial.domain.handlers

import android.util.Log
import github.detrig.composetutorial.data.NetworkRepository
import github.detrig.uikit.components.screen.ScreenState
import github.detrig.uikit.core.Action
import github.detrig.uikit.core.ActionDispatcher
import github.detrig.uikit.core.ActionHandler
import kotlinx.serialization.json.Json

class FetchDataHandler(
    private val repository: NetworkRepository,
    private val dispatcher: ActionDispatcher,
    private val state: ScreenState
) : ActionHandler<Action.FetchData> {

    override fun canHandle(action: Action): Boolean = action is Action.FetchData

    override suspend fun handle(action: Action.FetchData) {
        try {
            Log.d("alz-fetch", "Fetching data from ${action.endpoint}")
            val response = repository.fetch(action.endpoint)

            // Универсальная обработка результата


        } catch (e: Exception) {
            Log.e("alz-fetch", "Error fetching data from ${action.endpoint}", e)
        }
    }


}
