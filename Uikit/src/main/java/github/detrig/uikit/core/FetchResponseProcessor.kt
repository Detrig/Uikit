package github.detrig.uikit.core

import github.detrig.uikit.components.screen.ScreenState

interface FetchResponseProcessor {
    fun canProcess(endpoint: String): Boolean
    fun process(response: String, state: ScreenState)
}