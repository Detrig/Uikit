package github.detrig.uikit.components.card

import github.detrig.uikit.components.utils.Component
import github.detrig.uikit.components.utils.ModifierModel
import github.detrig.uikit.components.utils.Shape
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("card")
data class CardComponent(
    override val id: String? = null,
    override val modifier: ModifierModel? = null,

    val elevation: Int? = null,                 // Высота тени (dp)
    val shape: Shape? = null,                   // Скругление углов
    val background: String? = null,             // Цвет фона карты
    val children: List<Component> = emptyList() // Вложенные компоненты
) : Component()