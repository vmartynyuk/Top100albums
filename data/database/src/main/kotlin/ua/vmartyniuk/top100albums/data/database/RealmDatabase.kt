package ua.vmartyniuk.top100albums.data.database

import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ua.vmartyniuk.top100albums.core.model.AlbumModel
import ua.vmartyniuk.top100albums.data.database.entity.AlbumEntity
import ua.vmartyniuk.top100albums.data.database.entity.asEntity
import ua.vmartyniuk.top100albums.data.database.entity.asModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RealmDatabase @Inject constructor() {
    private val realm: Realm by lazy {
        val configuration = RealmConfiguration.create(schema = setOf(AlbumEntity::class))
        Realm.open(configuration)
    }

    fun getAllAlbumsAsFlow(): Flow<List<AlbumModel>> {
        return realm.query<AlbumEntity>().asFlow()
            .map { it.list.map { entity -> entity.asModel } }
    }

    fun saveAlbums(albums: List<AlbumModel>) {
        realm.writeBlocking {
            albums.forEach { album ->
                copyToRealm(album.asEntity)
            }
        }
    }

    fun clearAllAlbums() {
        realm.writeBlocking {
            delete(query<AlbumEntity>())
        }
    }
}