package ua.vmartyniuk.top100albums.feature.details.fake

import ua.vmartyniuk.top100albums.core.model.AlbumModel
import java.util.*

object DetailsFakeData {

    val albumDetails = AlbumModel(
        id = "123",
        name = "Fake Album",
        artist = "Fake artist",
        imageUrl = "",
        releaseDate = Date(),
        url = "",
        genres = listOf("Pop", "Rock", "Techno")
    )
}