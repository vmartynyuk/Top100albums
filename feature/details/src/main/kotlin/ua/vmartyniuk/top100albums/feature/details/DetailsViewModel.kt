package ua.vmartyniuk.top100albums.feature.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import ua.vmartyniuk.top100albums.core.model.AlbumModel
import ua.vmartyniuk.top100albums.domain.interactor.AlbumDetailsInteractor
import ua.vmartyniuk.top100albums.feature.details.navigation.DetailsDestination
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    albumDetailsInteractor: AlbumDetailsInteractor
) : ViewModel() {

    private val albumId: String = checkNotNull(savedStateHandle[DetailsDestination.albumIdArg])

    val album: Flow<AlbumModel> = albumDetailsInteractor.getAlbum(albumId)
}