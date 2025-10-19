package github.detrig.uikit.custom_components.lazy_column

import github.detrig.uikit.components.utils.Component
import github.detrig.uikit.components.utils.ModifierModel
import github.detrig.uikit.core.Action
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("lazyColumn")
data class LazyColumnComponent(
    override val id: String? = null,
    override val modifier: ModifierModel? = null,
    override val actions: List<Action>? = null,

    val template: String,  // "cartItem", "deliveryPoint", "productCard"
    val endpoint: String,  // URL для получения данных
    val verticalArrangement: String? = null,
    val horizontalAlignment: String? = null
) : Component()