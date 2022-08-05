package ua.vmartyniuk.top100albums.data.network.common

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ua.vmartyniuk.top100albums.data.network.exception.Top100AlbumsApiErrorCodes
import ua.vmartyniuk.top100albums.data.network.exception.Top100AlbumsApiException
import ua.vmartyniuk.top100albums.data.network.exception.Top100AlbumsConnectionException
import java.io.IOException
import java.net.SocketTimeoutException

internal class ResultCall<T>(proxy: Call<T>) : CallDelegate<T, Result<T>>(proxy) {

    override fun enqueueImpl(callback: Callback<Result<T>>) {
        proxy.enqueue(ResultCallback(this, callback))
    }

    override fun cloneImpl() = ResultCall(proxy.clone())

    private class ResultCallback<T>(
        private val proxy: ResultCall<T>,
        private val callback: Callback<Result<T>>
    ) : Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            if (response.isSuccessful) {
                val result = response.body()
                if (result != null) {
                    callback.onResponse(proxy, Response.success(Result.success(result)))
                } else {
                    val error = Top100AlbumsApiException(
                        Top100AlbumsApiErrorCodes.EMPTY_BODY,
                        response.message()
                    )
                    callback.onResponse(proxy, Response.success(Result.failure(error)))
                }
            } else {
                val error = Top100AlbumsApiException(
                    response.code(),
                    response.message()
                )
                callback.onResponse(proxy, Response.success(Result.failure(error)))
            }
        }

        override fun onFailure(call: Call<T>, error: Throwable) {
            val result = when (error) {
                is retrofit2.HttpException -> Top100AlbumsApiException(error.code(), error.message(), error)
                is IOException,
                is SocketTimeoutException -> Top100AlbumsConnectionException(error.message, error)
                else -> Top100AlbumsApiException(Top100AlbumsApiErrorCodes.UNKNOWN_ERROR, error.message, error)
            }
            callback.onResponse(proxy, Response.success(Result.failure(result)))
        }
    }

    override fun timeout() = proxy.timeout()
}