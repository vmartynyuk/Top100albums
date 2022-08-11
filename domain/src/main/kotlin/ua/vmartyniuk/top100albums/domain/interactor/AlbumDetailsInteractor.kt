package ua.vmartyniuk.top100albums.domain.interactor

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import ua.vmartyniuk.top100albums.core.model.AlbumModel
import ua.vmartyniuk.top100albums.domain.di.IoDispatcher
import ua.vmartyniuk.top100albums.domain.repository.AlbumsRepository
import javax.inject.Inject

class AlbumDetailsInteractor @Inject constructor(
    private val albumsRepository: AlbumsRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) {

    fun getAlbum(albumId: String): Flow<AlbumModel> {
        return albumsRepository.getAlbum(albumId)
            .flowOn(ioDispatcher)
    }
}