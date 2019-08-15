package com.fs.retrofirsample.rest

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class Network {

    companion object {

        const val BASE_URL: String = "https://bff-mock.glitch.me"

        fun provideLoginApi(): LoginApi {
            return provideRetrofitInterface().create(LoginApi::class.java)
        }

        private fun provideOkHttpClient(): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
                .connectTimeout(45, TimeUnit.SECONDS)
                .readTimeout(45, TimeUnit.SECONDS)
                .build()
        }

        private fun provideRetrofitInterface(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .client(provideOkHttpClient())
                .build()
        }
    }

}