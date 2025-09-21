package github.detrig.uikit.core


import kotlinx.serialization.Serializable

@Serializable
sealed class Component {
    abstract val id: String?
    abstract val style: Style?
    abstract val actions: List<Action>?
}