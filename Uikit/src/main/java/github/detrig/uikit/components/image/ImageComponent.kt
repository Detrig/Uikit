package github.detrig.uikit.components.image

import github.detrig.uikit.core.Action
import github.detrig.uikit.components.utils.Component
import github.detrig.uikit.components.utils.ModifierModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("image")
data class ImageComponent(
    override val id: String? = null,
    override val modifier: ModifierModel? = null,

    val url: String? = null,                  // URL или локальный ресурс
    val contentDescription: String? = null,   // Accessibility описание
    val contentScale: ContentScaleType? = null, // Масштабирование
    val placeholder: String? = null,          // Placeholder (ресурс или url)
    val error: String? = null,                // Ошибка (ресурс или url)
    val scaleType: String? = null             // Альтернативное scale (если нужно)
) : Component()



@Serializable
enum class ContentScaleType {
    Fill,
    FillHeight,
    Crop,
    FillWidth,
    Inside,
    None,
    FillBounds
}