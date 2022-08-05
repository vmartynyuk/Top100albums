package ua.vmartyniuk.top100albums.data.database

import io.realm.kotlin.ext.query
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ua.vmartyniuk.top100albums.data.database.entity.AlbumEntity

class RealmDatabase {
    private val realm: Realm by lazy {
        val configuration = RealmConfiguration.create(schema = setOf(AlbumEntity::class))
        Realm.open(configuration)
    }

    fun getAllAlbumsAsFlow(): Flow<List<AlbumEntity>> {
        return realm.query<AlbumEntity>().asFlow().map { it.list }
    }

    fun saveAlbums(albums: List<AlbumEntity>) {
        realm.writeBlocking {
            albums.forEach { album ->
                copyToRealm(album)
            }
        }
    }

    fun clearAllAlbums() {
        realm.writeBlocking {
            delete(query<AlbumEntity>())
        }
    }
}