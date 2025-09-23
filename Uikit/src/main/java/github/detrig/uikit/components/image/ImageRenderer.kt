package github.detrig.uikit.components.image

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import github.detrig.uikit.utils.applyStyle

object ImageRenderer {

    @Composable
    fun Render(component: ImageComponent) {
        val scale = when (component.contentScale) {
            "fill" -> ContentScale.FillBounds
            "crop" -> ContentScale.Crop
            "fit" -> ContentScale.Fit
            "inside" -> ContentScale.Inside
            else -> ContentScale.Fit
        }

        AsyncImage(
            model = component.imageUrl,
            contentDescription = component.contentDescription,
            contentScale = scale,
            modifier = Modifier
                .applyStyle(component.style)
        )
    }
}