package ru.alexnimas.core_api.providers

import okhttp3.OkHttpClient
import retrofit2.Retrofit

interface NetworkProvider {
    fun provideOkHttpClient(): OkHttpClient
    fun provideRetrofit(): Retrofit
}