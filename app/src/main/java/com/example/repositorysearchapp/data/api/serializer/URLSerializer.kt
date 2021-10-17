package com.example.repositorysearchapp.data.api.serializer

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.net.URL

object URLSerializer: KSerializer<URL> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("URLSerializer", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): URL = URL(decoder.decodeString())
    override fun serialize(encoder: Encoder, value: URL) {
        encoder.encodeString(value.toString())
    }
}