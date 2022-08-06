package ua.vmartyniuk.top100albums.domain.model

import ua.vmartyniuk.top100albums.core.model.AlbumModel
import ua.vmartyniuk.top100albums.data.network.model.FeedResponse

internal val FeedResponse.asModelList: List<AlbumModel>
    get() = this.feed.results.map { response ->
        AlbumModel(
            id = response.id,
            name = response.name,
            artist = response.artistName,
            imageUrl = response.artworkUrl100,
            releaseDate = response.releaseDate,
            genres = response.genres.map { it.name }
        )
    }