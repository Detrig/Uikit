package github.detrig.uikit.components.utils

import kotlinx.serialization.Serializable

@Serializable
abstract class Component {
    abstract val id: String?
    abstract val modifier: ModifierModel?
    //abstract val actions: Map<String, Action>?
}