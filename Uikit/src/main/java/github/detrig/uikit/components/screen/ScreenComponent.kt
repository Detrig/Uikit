package github.detrig.uikit.components.screen

import github.detrig.uikit.components.utils.Component
import github.detrig.uikit.components.utils.ModifierModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("screen")
data class ScreenComponent(
    override val id: String?,
    override val modifier: ModifierModel?,
    val name: String,
    val background: String? = null,
    val topBar: List<Component> = emptyList(),
    val content: List<Component> = emptyList(),
    val bottomBar: List<Component> = emptyList()
) : Component()