package ua.vmartyniuk.top100albums.data.database.entity

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import ua.vmartyniuk.top100albums.core.model.AlbumModel
import ua.vmartyniuk.top100albums.data.database.entity.AlbumEntity.Companion.GENRE_SEPARATOR
import java.util.*

internal class AlbumEntity : RealmObject {
    @PrimaryKey
    var id: String = ""
    var name: String = ""
    var artist: String = ""
    var imageUrl: String = ""
    var url: String = ""
    var releaseDate: Date? = null
    var genres: String? = null

    companion object {
        const val GENRE_SEPARATOR = ","
    }
}

internal val AlbumEntity.asModel: AlbumModel
    get() = AlbumModel(
        id = id,
        name = name,
        artist = artist,
        imageUrl = imageUrl,
        releaseDate = releaseDate,
        url = url,
        genres = genres?.split(GENRE_SEPARATOR) ?: emptyList()
    )

internal val AlbumModel.asEntity: AlbumEntity
    get() {
        val model = this
        return AlbumEntity().apply {
            id = model.id
            name = model.name
            artist = model.artist
            imageUrl = model.imageUrl
            releaseDate = model.releaseDate
            url = model.url
            genres = model.genres.joinToString(GENRE_SEPARATOR)
        }
    }