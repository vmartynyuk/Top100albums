package ua.vmartyniuk.top100albums.data.network.service

import retrofit2.http.GET
import retrofit2.http.Path
import ua.vmartyniuk.top100albums.data.network.model.FeedResponse

interface ApiService {

    @GET("/api/v2/{countryCode}/music/most-played/{count}/albums.json")
    suspend fun getAlbums(
        @Path("countryCode") countryCode: String,
        @Path("count") count: Int
    ): Result<FeedResponse>
}