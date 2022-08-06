package ua.vmartyniuk.top100albums.core.model

import java.util.*

data class AlbumModel(
    val id: String,
    val name: String,
    val artist: String,
    val imageUrl: String,
    val releaseDate: Date?,
    val genres: List<String>
) {
    val smallImageUrl: String
        get() = imageUrl.replace("100x100bb.jpg", "500x500bb.jpg")

    val largeImageUrl: String
        get() = imageUrl.replace("100x100bb.jpg", "1000x1000bb.jpg")
}