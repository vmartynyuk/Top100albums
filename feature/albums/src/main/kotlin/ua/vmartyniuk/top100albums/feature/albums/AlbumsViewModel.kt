package ua.vmartyniuk.top100albums.feature.albums

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ua.vmartyniuk.top100albums.core.model.AlbumModel
import ua.vmartyniuk.top100albums.core.ui.common.AppUiState
import ua.vmartyniuk.top100albums.domain.interactor.AbumsInteractor
import javax.inject.Inject

@HiltViewModel
class AlbumsViewModel @Inject constructor(
    private val albumInteractor: AbumsInteractor
): ViewModel() {

    val albums: StateFlow<AppUiState<List<AlbumModel>>> = albumInteractor.albums
        .mapToUIState()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = AppUiState.Loading
        )

    init {
        loadAlbums()
    }

    fun loadAlbums() {
        viewModelScope.launch {
            albumInteractor.loadAlbums(DEFAULT_LOCALE, PAGE_SIZE)
        }
    }

    companion object {
        private const val DEFAULT_LOCALE = "us"
        private const val PAGE_SIZE = 100
    }
}

internal fun Flow<List<AlbumModel>>.mapToUIState(): Flow<AppUiState<List<AlbumModel>>> {
    return map { list -> AppUiState.Success(list) }
}