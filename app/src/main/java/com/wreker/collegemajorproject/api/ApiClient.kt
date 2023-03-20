package com.wreker.collegemajorproject.api

import com.wreker.collegemajorproject.model.GetTopNewsHeadlines
import com.wreker.collegemajorproject.tools.NewsResponse
import retrofit2.Response

class ApiClient(private val newsApi: NewsApi) {

    suspend fun getHealthArticles(pageIndex : Int) : NewsResponse<GetTopNewsHeadlines>{
        return safeApiCall {
            newsApi.getTopNews(pageIndex = pageIndex)
        }
    }

    private inline fun <T> safeApiCall(apiCall : () -> Response<T>) : NewsResponse<T>{
        return try {
            NewsResponse.success(apiCall.invoke())
        }catch (e : Exception){
            NewsResponse.failure(e)
        }
    }

}