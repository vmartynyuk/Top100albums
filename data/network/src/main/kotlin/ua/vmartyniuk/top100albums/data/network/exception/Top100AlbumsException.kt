package ua.vmartyniuk.top100albums.data.network.exception

import java.io.IOException

open class Top100AlbumsApiException(
    val code: Int,
    override val message: String?,
    cause: Throwable? = null
) : IOException(message, cause)

open class Top100AlbumsConnectionException(
    message: String?,
    cause: Throwable? = null
) : Top100AlbumsApiException(Top100AlbumsApiErrorCodes.CONNECTION_FAILURE, message, cause)

object Top100AlbumsApiErrorCodes {
    const val UNKNOWN_ERROR = -2
    const val EMPTY_BODY = -1
    const val CONNECTION_FAILURE = 0
}