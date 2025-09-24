package github.detrig.uikit.core

import kotlinx.serialization.Serializable

@Serializable
data class Style(
    val width: Size? = null,         // "wrap_content", "match_parent", "100dp"
    val height: Size? = null,
    val padding: Int? = null,
    val margin: Int? = null,
    val backgroundColor: String? = null,
    val gravity: String? = null,   // "center", "start", "end" (опционально)
    val cornerRadius: Int? = null,
    val visibility: String? = "visible" // visible, gone, invisible
)