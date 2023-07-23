package com.example.testfetchdata

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Path

//api request handler
interface JsonPlaceholderApi {

    @GET("posts")
    fun getPosts(): Call<List<PostDataModel>>

    @GET("posts/{postId}/comments")
    fun getComments(@Path("postId") postId: Int): Call<List<CommentDataModel>> //path is used to tie the {postId} to the postId variable

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        fun create(): JsonPlaceholderApi{
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

            return retrofit.create(JsonPlaceholderApi::class.java)
        }
    }



}