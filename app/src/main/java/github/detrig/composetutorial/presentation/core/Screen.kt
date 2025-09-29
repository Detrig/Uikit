package github.detrig.composetutorial.presentation.core

import androidx.compose.runtime.Composable

interface Screen {

    @Composable
    fun Show()

    object Empty: Screen {
        @Composable
        override fun Show() = Unit
    }

}