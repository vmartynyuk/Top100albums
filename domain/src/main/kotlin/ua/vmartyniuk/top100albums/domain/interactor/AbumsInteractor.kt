package ua.vmartyniuk.top100albums.domain.interactor

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn
import ua.vmartyniuk.top100albums.domain.di.IoDispatcher
import ua.vmartyniuk.top100albums.domain.repository.AlbumsRepository
import javax.inject.Inject

class AbumsInteractor @Inject constructor(
    private val albumsRepository: AlbumsRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) {
    val albums = albumsRepository.albums
        .flowOn(ioDispatcher)

    suspend fun loadAlbums(countryCode: String, count: Int) {
        albumsRepository.loadAlbums(countryCode, count)
    }
}