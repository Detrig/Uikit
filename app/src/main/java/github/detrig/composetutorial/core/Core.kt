package github.detrig.composetutorial.core

import github.detrig.uikit.core.NavigationHandler

interface Core : ProvideNavigation {

    class Base : Core {
        private val navigation: Navigation.Mutable = Navigation.Base()
        private val navigationHandler = NavigationHandlerFromJson(navigation)

        override fun navigation(): Navigation.Mutable = navigation

        override fun navigationHandler() = navigationHandler
    }
}

interface ProvideNavigation {
    fun navigation(): Navigation.Mutable
    fun navigationHandler() : NavigationHandler
}

