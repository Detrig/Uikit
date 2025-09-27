package github.detrig.uikit.components.column

import github.detrig.uikit.components.utils.Component
import github.detrig.uikit.components.utils.ModifierModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("column")
data class ColumnComponent(
    override val id: String? = null,
    override val modifier: ModifierModel? = null,

    val verticalArrangement: String? = null,     // top, center, bottom, spaceBetween, spaceAround, spaceEvenly
    val horizontalAlignment: String? = null,     // start, center, end
    val children: List<Component> = emptyList()  // Дочерние компоненты
) : Component()