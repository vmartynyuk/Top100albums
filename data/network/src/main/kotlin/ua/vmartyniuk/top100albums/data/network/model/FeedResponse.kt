package ua.vmartyniuk.top100albums.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class FeedResponse(
    val feed: FeedDetailsResponse
)

@Serializable
data class FeedDetailsResponse(
    val results: List<AlbumResponse> = emptyList()
)