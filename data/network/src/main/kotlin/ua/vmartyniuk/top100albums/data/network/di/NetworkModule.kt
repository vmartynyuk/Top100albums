package ua.vmartyniuk.top100albums.data.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Converter
import retrofit2.Retrofit
import ua.vmartyniuk.top100albums.data.network.common.ResultAdapterFactory
import ua.vmartyniuk.top100albums.data.network.service.ApiService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val API_URL = "https://rss.applemarketingtools.com"

    @Provides
    @Singleton
    fun provideConverter(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun provideConverterFactory(converter: Json): Converter.Factory =
        converter.asConverterFactory("application/json".toMediaType())

    @Provides
    @Singleton
    fun provideRetrofit(converterFactory: Converter.Factory) =
        Retrofit.Builder()
            .baseUrl(API_URL)
            .addCallAdapterFactory(ResultAdapterFactory())
            .addConverterFactory(converterFactory)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}