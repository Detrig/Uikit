package github.detrig.uikit.components.image

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import github.detrig.uikit.components.screen.ScreenState
import github.detrig.uikit.components.utils.toComposeModifier

object ImageRenderer {

    @Composable
    fun Render(component: ImageComponent, state: ScreenState) {
        val modifier = component.modifier?.toComposeModifier() ?: Modifier

        AsyncImage(
            model = component.url ?: component.placeholder,
            contentDescription = component.contentDescription,
            modifier = modifier,
            contentScale = when (component.contentScale) {
                ContentScaleType.Fill -> ContentScale.FillBounds
                ContentScaleType.FillHeight -> ContentScale.FillHeight
                ContentScaleType.FillWidth -> ContentScale.FillWidth
                ContentScaleType.Inside -> ContentScale.Inside
                ContentScaleType.None -> ContentScale.None
                ContentScaleType.FillBounds -> ContentScale.FillBounds
                ContentScaleType.Crop, null -> ContentScale.Crop
            },
            //placeholder = component.placeholder?.let { painterResource(id = getImageRes(it)) }, //TODO add local and url image
            //error = component.error?.let { painterResource(id = getImageRes(it)) }
        )
    }

}
