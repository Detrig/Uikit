package github.detrig.uikit.components.text

import kotlinx.serialization.Serializable

@Serializable
data class TextStyle(
    val fontSize: Int? = null,             // sp
    val fontWeight: String? = null,        // normal, bold, medium
    val fontStyle: String? = null,         // normal, italic
    val color: String? = null,             // #HEX
    val lineHeight: Int? = null,           // dp
    val letterSpacing: Float? = null,      // em/dp
    val textDecoration: String? = null,    // none, underline, lineThrough
    val textAlign: String? = null,         // start, center, end, justify
    val maxLines: Int? = null,             // максимальное количество строк
    val overflow: String? = null           // clip, ellipsis, visible
)
