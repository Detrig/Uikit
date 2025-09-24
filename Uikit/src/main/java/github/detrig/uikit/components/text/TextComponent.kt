package github.detrig.uikit.components.text

import github.detrig.uikit.core.Action
import github.detrig.uikit.core.Component
import github.detrig.uikit.core.Style
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("text")
data class TextComponent(
    override val id: String? = null,
    override val style: Style? = null,
    override val actions: List<Action>? = null,
    val value: String? = null,
    val dataKey: String? = null,
    val fontSize: Int? = null,
    val color: String? = null,
    val bold: Boolean = false,
    val italic: Boolean = false
) : Component()