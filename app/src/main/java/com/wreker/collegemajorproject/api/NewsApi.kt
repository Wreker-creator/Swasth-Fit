package com.wreker.collegemajorproject.api

import com.wreker.collegemajorproject.model.GetTopNewsHeadlines
import com.wreker.collegemajorproject.tools.Constants.Companion.ApiKey
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    suspend fun getTopNews(
        @Query("country")
        country : String = "in",
        @Query("page")
        pageIndex : Int,
        @Query("apiKey")
        apiKey : String = ApiKey,
        @Query("category")
        category : String = "health"
    ) : Response<GetTopNewsHeadlines>

}