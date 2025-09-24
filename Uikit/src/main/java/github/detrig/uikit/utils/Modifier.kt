package github.detrig.uikit.utils

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import github.detrig.uikit.core.Size
import github.detrig.uikit.core.Style

fun Modifier.applyStyle(style: Style?): Modifier {
    var modifier = this

    modifier = when (style?.width) {
        is Size.Dp -> modifier.width(style.width.value.dp)
        Size.WrapContent -> modifier.wrapContentWidth()
        Size.MatchParent -> modifier.fillMaxWidth()
        null -> modifier
    }

    modifier = when (val h = style?.height) {
        is Size.Dp -> modifier.height(h.value.dp)
        Size.WrapContent -> modifier.wrapContentHeight()
        Size.MatchParent -> modifier.fillMaxHeight()
        else -> modifier
    }

    modifier = style?.padding?.let { modifier.padding(it.dp) } ?: modifier

    return modifier
}
