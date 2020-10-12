package com.example.booksapitest.model

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object BooksApi {
    fun initRetrofit(): API{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(addOkHttpClient())
            .build()
        return retrofit.create(API::class.java)
    }

    private fun addOkHttpClient(): OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(addLoggingInterceptor())
            .build()
    }

    private fun addLoggingInterceptor()
            : Interceptor{
        val logger = HttpLoggingInterceptor()
        logger.level =
            HttpLoggingInterceptor.Level.BASIC
        return logger
    }
}
//https://www.googleapis.com/ ->baseUrl
//books/v1/volumes -> endpoint
// ?q=bible&maxResults=5 -> Query Params
interface API{
    @GET("books/v1/volumes")
    fun getThemBooks(
        @Query("q") input: String,
        @Query("filter") filterSpinner: String,
        @Query("printType") printTypeRB: String,
        @Query("maxResults") maxResults: Int = 5
    ): Call<BooksResponse>
}