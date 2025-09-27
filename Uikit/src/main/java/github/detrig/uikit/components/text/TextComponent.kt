package github.detrig.uikit.components.text

import github.detrig.uikit.components.utils.Component
import github.detrig.uikit.components.utils.ModifierModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("text")
data class TextComponent(
    override val id: String? = null,
    override val modifier: ModifierModel? = null,   // универсальный модификатор
    val style: TextStyle? = null,     // отдельный стиль текста
    val text: String? = null,                  // Сам текст
    val format: String? = null,                // Форматирование "(%s)"
 //   val binding: String? = null                // Привязка к данным (например reviews)
) : Component()