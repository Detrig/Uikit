package github.detrig.uikit.core

import kotlinx.serialization.Serializable

@Serializable
data class Style(
    val width: String? = null,         // "wrap_content", "match_parent", "100dp"
    val height: String? = null,
    val padding: Int? = null,          // px или dp (можно усложнить позже)
    val margin: Int? = null,
    val backgroundColor: String? = null,
    val cornerRadius: Int? = null,
    val visibility: String? = "visible" // visible, gone, invisible
)