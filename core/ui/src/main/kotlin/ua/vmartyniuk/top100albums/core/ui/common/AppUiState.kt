package ua.vmartyniuk.top100albums.core.ui.common

sealed class AppUiState<out T : Any> {
    object Loading : AppUiState<Nothing>()
    data class Success<out T : Any>(val data: T): AppUiState<T>()
}