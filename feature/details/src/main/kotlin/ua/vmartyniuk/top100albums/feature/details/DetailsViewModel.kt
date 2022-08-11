package ua.vmartyniuk.top100albums.feature.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import ua.vmartyniuk.top100albums.core.model.AlbumModel
import ua.vmartyniuk.top100albums.core.ui.common.AppUiState
import ua.vmartyniuk.top100albums.domain.interactor.AlbumDetailsInteractor
import ua.vmartyniuk.top100albums.feature.details.navigation.DetailsDestination
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    albumDetailsInteractor: AlbumDetailsInteractor
) : ViewModel() {

    private val albumId: String = checkNotNull(savedStateHandle[DetailsDestination.albumIdArg])

    val album: StateFlow<AppUiState<AlbumModel>> = albumDetailsInteractor.getAlbum(albumId)
        .mapToUIState()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = AppUiState.Loading
        )
}

internal fun Flow<AlbumModel>.mapToUIState(): Flow<AppUiState<AlbumModel>> {
    return map { model -> AppUiState.Success(model) }
}