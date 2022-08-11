package ua.vmartyniuk.top100albums.domain.repository

import android.util.Log
import kotlinx.coroutines.flow.*
import ua.vmartyniuk.top100albums.core.model.AlbumModel
import ua.vmartyniuk.top100albums.data.database.RealmDatabase
import ua.vmartyniuk.top100albums.data.network.service.ApiService
import ua.vmartyniuk.top100albums.domain.model.asModelList
import javax.inject.Inject

class AlbumsRepository @Inject constructor(
    private val apiService: ApiService,
    private val realmDatabase: RealmDatabase
) {

    val albums: Flow<List<AlbumModel>> = realmDatabase.getAllAlbumsAsFlow()

    suspend fun loadAlbums(countryCode: String, count: Int) {
        val result = apiService.getAlbums(countryCode, count)
        result.onSuccess { response ->
            realmDatabase.clearAllAlbums()
            realmDatabase.saveAlbums(response.asModelList)
        }.onFailure { error ->
            Log.d("TAG", "loadAlbums: ${error.message}")
        }
    }

    fun getAlbum(albumId: String): Flow<AlbumModel> = realmDatabase.getAlbumByIdFlow(albumId)
}