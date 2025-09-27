package github.detrig.uikit.components.lazycolumn

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import github.detrig.uikit.components.screen.RenderComponent
import github.detrig.uikit.components.screen.ScreenState
import github.detrig.uikit.components.utils.Component
import github.detrig.uikit.components.utils.ModifierModel
import github.detrig.uikit.components.utils.toComposeModifier
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

//@Composable
//fun RenderLazyColumn(component: LazyColumnComponent, state: ScreenState) {
//    LazyColumn(modifier = component.modifier?.toComposeModifier() ?: Modifier.fillMaxSize()) {
//        component.header?.let { header ->
//            item { RenderComponent(header, state) }
//        }
//        component.items?.let { itemComp ->
//            val list = state.getValue<List<Any>>(itemComp.id ?: "") ?: emptyList()
//            items(list) { data ->
//                RenderComponent(itemComp, state.withData(data))
//            }
//        }
//    }
//}