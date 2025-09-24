package github.detrig.uikit.core

import github.detrig.uikit.utils.SizeSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = SizeSerializer::class)
sealed class Size {
    @Serializable
    @SerialName("dp")
    data class Dp(val value: Int) : Size()

    @Serializable
    @SerialName("wrap_content")
    object WrapContent : Size()

    @Serializable
    @SerialName("match_parent")
    object MatchParent : Size()
}