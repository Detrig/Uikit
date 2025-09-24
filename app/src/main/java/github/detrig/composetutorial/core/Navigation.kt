package github.detrig.composetutorial.core

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface Navigation {

    interface Read {
        fun screen(): StateFlow<Screen>
    }

    interface Update {
        fun update(screen: Screen)
    }

    interface Mutable : Read, Update

    class Base(
        private val state: MutableStateFlow<Screen> = MutableStateFlow<Screen>(Screen.Empty)
    ) : Mutable {
        override fun screen(): StateFlow<Screen> = state

        override fun update(screen: Screen) {
            state.value = screen
        }

    }
}