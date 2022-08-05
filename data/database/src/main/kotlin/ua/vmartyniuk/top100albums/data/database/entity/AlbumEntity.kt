package ua.vmartyniuk.top100albums.data.database.entity

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import java.util.*

class AlbumEntity: RealmObject {
    @PrimaryKey
    val id: String = ""
    val name: String = ""
    val artist: String = ""
    val imageUrl: String = ""
    val releaseDate: Date? = null
    val genres: RealmList<String> = realmListOf()
}