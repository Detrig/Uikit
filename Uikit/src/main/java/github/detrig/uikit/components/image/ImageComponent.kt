package github.detrig.uikit.components.image

import github.detrig.uikit.core.Action
import github.detrig.uikit.core.Component
import github.detrig.uikit.core.Style
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("image")
data class ImageComponent(
    override val id: String?, override val style: Style?, override val actions: Map<String, Action>?,
    val imageUrl: String? = null,
    val imageError: String? = null,
    val contentDescription: String? = null,
    val contentScale: String? = null
) : Component()


/**
enum class contentScale {
    Fill, FillHeight, Crop, FillWidth, Inside, None, FillBounds
}
*/