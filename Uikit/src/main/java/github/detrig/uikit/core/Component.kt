package github.detrig.uikit.core

import kotlinx.serialization.Serializable

@Serializable
abstract class Component {
    abstract val id: String?
    abstract val style: Style?
    abstract val actions: Map<String, Action>?
}