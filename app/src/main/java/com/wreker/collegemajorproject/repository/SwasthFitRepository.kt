package com.wreker.collegemajorproject.repository

import com.wreker.collegemajorproject.api.RetrofitInstance
import com.wreker.collegemajorproject.model.GetTopNewsHeadlines
import retrofit2.Retrofit

class SwasthFitRepository {

    suspend fun getArticles(pageIndex : Int) : GetTopNewsHeadlines?{
        val request = RetrofitInstance.apiClient.getHealthArticles(pageIndex)

        if(request.failed || !request.success){
            return null
        }

        return request.body

    }

}