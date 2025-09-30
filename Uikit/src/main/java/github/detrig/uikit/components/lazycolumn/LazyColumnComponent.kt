package github.detrig.uikit.components.lazycolumn

import github.detrig.uikit.components.utils.Component
import github.detrig.uikit.components.utils.ModifierModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("lazyColumn")
data class LazyColumnComponent(
    override val id: String? = null,
    override val modifier: ModifierModel? = null,
    val header: Component? = null,  // Один элемент сверху
    val items: Component? = null    // Повторяющийся элемент с привязкой к списку
) : Component()

