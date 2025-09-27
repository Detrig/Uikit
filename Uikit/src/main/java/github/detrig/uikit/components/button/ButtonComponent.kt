package github.detrig.uikit.components.button

import github.detrig.uikit.components.utils.Component
import github.detrig.uikit.components.utils.ModifierModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("button")
data class ButtonComponent(
    override val id: String? = null,
    override val modifier: ModifierModel? = null,
    val style: ButtonStyle? = null,
    val text: String? = null,            // Текст кнопки
    val onClick: String? = null,         // ID действия
    val enabled: Boolean = true,         // Включена ли
    val icon: String? = null             // Если кнопка с иконкой
) : Component()