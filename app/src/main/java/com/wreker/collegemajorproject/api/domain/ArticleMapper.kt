package com.wreker.collegemajorproject.api.domain

import com.wreker.collegemajorproject.api.model.DomainArticle
import com.wreker.collegemajorproject.model.Article
import java.text.SimpleDateFormat
import java.util.*

object ArticleMapper {

    fun buildFrom(response : Article) : DomainArticle {
        return DomainArticle(
            title = response.title
        )
    }

//    private fun getPublishedDate(date : String) : String{
//        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH)
//        val dateAndTime = dateFormat.parse(date)
//        val final = SimpleDateFormat("dd LLL,yyyy", Locale.ENGLISH).format(dateAndTime)
//        return final.toString()
//    }

}