package github.detrig.uikit.components.checkbox

import github.detrig.uikit.components.utils.Component
import github.detrig.uikit.components.utils.ModifierModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("checkbox")
data class CheckboxComponent(
    override val id: String? = null,
    override val modifier: ModifierModel? = null,

    val isChecked: Boolean = false,          // Текущее состояние чекбокса
    val onCheckedChange: String? = null,     // Экшен при изменении состояния
    val enabled: Boolean = true,             // Можно ли взаимодействовать
    val colors: CheckboxColors? = null       // Цвета
) : Component()

@Serializable
data class CheckboxColors(
    val checkedColor: String? = null,        // Цвет при checked
    val uncheckedColor: String? = null,      // Цвет при unchecked
    val disabledColor: String? = null        // Цвет при disabled
)