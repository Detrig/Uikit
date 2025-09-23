package github.detrig.uikit.utils

import github.detrig.uikit.core.Size
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object SizeSerializer : KSerializer<Size> {
    override val descriptor = PrimitiveSerialDescriptor("Size", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Size) {
        val str = when (value) {
            is Size.Dp -> value.value.toString()
            Size.WrapContent -> "wrap_content"
            Size.MatchParent -> "match_parent"
        }
        encoder.encodeString(str)
    }

    override fun deserialize(decoder: Decoder): Size {
        return when (val str = decoder.decodeString()) {
            "wrap_content" -> Size.WrapContent
            "match_parent" -> Size.MatchParent
            else -> Size.Dp(str.toInt())
        }
    }
}