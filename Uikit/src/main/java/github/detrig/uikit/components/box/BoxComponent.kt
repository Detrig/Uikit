package github.detrig.uikit.components.box

import github.detrig.uikit.components.utils.Component
import github.detrig.uikit.components.utils.ModifierModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("box")
data class BoxComponent(
    override val id: String? = null,
    override val modifier: ModifierModel? = null,
    val children: List<Component> = emptyList()
) : Component()