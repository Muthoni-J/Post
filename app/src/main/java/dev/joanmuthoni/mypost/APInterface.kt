package dev.joanmuthoni.mypost

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.sql.RowId

interface APInterface {
        @GET("/posts")
        fun getPosts(): Call<List<Post>>

        @GET("/posts/{id}")
        fun getPostById(@Path("id")postId: Int):Call<Post>
    }

