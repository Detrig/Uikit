package github.detrig.composetutorial.core

import github.detrig.composetutorial.core.navigation.Navigation
import github.detrig.composetutorial.data.ScreenRepositoryImpl
import github.detrig.composetutorial.data.ScreenService
import github.detrig.composetutorial.domain.repository.ScreenRepository
import github.detrig.uikit.core.ActionDispatcher
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.websocket.WebSockets

interface Core : ProvideNavigation {

    fun screenRepository() : ScreenRepository

    class Base : Core {
        private val navigation: Navigation.Mutable = Navigation.Base()
        private val dispatcher = ActionDispatcher()

        val client = HttpClient(OkHttp) {
            install(WebSockets) {
                maxFrameSize = Long.MAX_VALUE
                contentConverter = null
            }
        }
        private val screenService = ScreenService.Base(client)
        private val screenRepository = ScreenRepositoryImpl(screenService)

        override fun screenRepository(): ScreenRepository = screenRepository

        override fun navigation(): Navigation.Mutable = navigation
        override fun actionDispatcher(): ActionDispatcher = dispatcher
    }
}

interface ProvideNavigation {
    fun navigation(): Navigation.Mutable
    fun actionDispatcher(): ActionDispatcher
}

