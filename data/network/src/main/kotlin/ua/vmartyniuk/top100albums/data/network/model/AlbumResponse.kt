package ua.vmartyniuk.top100albums.data.network.model

import kotlinx.serialization.Serializable
import ua.vmartyniuk.top100albums.data.network.model.serializer.DateSerializer
import java.util.*

@Serializable
data class AlbumResponse(
    val id: String,
    val artistName: String,
    val name: String,
    val artworkUrl100: String,
    @Serializable(DateSerializer::class)
    val releaseDate: Date?,
    val genres: List<GenreResponse> = emptyList()
)