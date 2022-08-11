package ua.vmartyniuk.top100albums.data.network.model.serializer

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import ua.vmartyniuk.top100albums.core.common.format
import ua.vmartyniuk.top100albums.core.common.toDate
import java.util.*

object DateSerializer : KSerializer<Date?> {

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor(
        serialName = "Date",
        kind = PrimitiveKind.STRING
    )

    override fun serialize(encoder: Encoder, value: Date?) {
        value?.let { encoder.encodeString(value.format()) }
    }

    override fun deserialize(decoder: Decoder): Date? =
        decoder.decodeString().toDate()

}