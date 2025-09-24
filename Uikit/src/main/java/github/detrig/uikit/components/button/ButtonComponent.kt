package github.detrig.uikit.components.button

import github.detrig.uikit.core.Action
import github.detrig.uikit.core.Component
import github.detrig.uikit.core.Style
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("button")
data class ButtonComponent(
    override val id: String? = null,
    override val style: Style? = null,
    override val actions: List<Action>? = null,
    val text: String? = null,
    val textBold: Boolean = false,
    val fontSize: Int? = null,
    val contentPadding: Int? = null,
    val textColor: String? = null,
    val bold: Boolean = false,
    val backgroundHex: String? = null,
    val dataKey: String? = null,
    val action: Action? = null
) : Component()