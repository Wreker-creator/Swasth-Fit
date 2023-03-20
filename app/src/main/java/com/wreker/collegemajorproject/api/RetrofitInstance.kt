package com.wreker.collegemajorproject.api

import com.wreker.collegemajorproject.tools.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance() {

    companion object{

        private val retrofit by lazy {
            Retrofit.Builder().baseUrl(Constants.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getLoggingHttpClient())
                .build()
        }

        private val newsApi : NewsApi by lazy {
            retrofit.create(NewsApi::class.java)
        }

        val apiClient = ApiClient(newsApi)


        private fun getLoggingHttpClient() : OkHttpClient {
            val builder = OkHttpClient.Builder()

            builder.addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            })

            return builder.build()
        }

    }

}