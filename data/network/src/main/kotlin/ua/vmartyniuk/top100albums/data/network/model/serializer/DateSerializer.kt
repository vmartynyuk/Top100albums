package ua.vmartyniuk.top100albums.data.network.model.serializer

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.util.*

object DateSerializer : KSerializer<Date> {

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor(
        serialName = "Date",
        kind = PrimitiveKind.LONG
    )

    override fun serialize(encoder: Encoder, value: Date) =
        encoder.encodeLong(value.time)

    override fun deserialize(decoder: Decoder): Date =
        Date(decoder.decodeLong())
}