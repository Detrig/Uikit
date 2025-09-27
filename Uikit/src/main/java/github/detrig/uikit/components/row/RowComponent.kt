package github.detrig.uikit.components.row

import github.detrig.uikit.components.utils.Component
import github.detrig.uikit.components.utils.ModifierModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("row")
data class RowComponent(
    override val id: String? = null,
    override val modifier: ModifierModel? = null,

    val verticalAlignment: String? = null,       // Top, CenterVertically, Bottom
    val horizontalArrangement: String? = null,   // start, center, end, spaceBetween, spaceAround, spaceEvenly
    val children: List<Component> = emptyList()  // Дочерние компоненты внутри Row
) : Component()
