package com.wreker.collegemajorproject.epoxy

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.wreker.collegemajorproject.api.RetrofitInstance
import com.wreker.collegemajorproject.api.domain.ArticleMapper
import com.wreker.collegemajorproject.api.model.DomainArticle
import com.wreker.collegemajorproject.tools.Constants

class NewsItemPagingSource : PagingSource<Int, DomainArticle>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DomainArticle> {
        val pageNumber = params.key ?:1

        val pageRequest = RetrofitInstance.apiClient.getHealthArticles(pageNumber)

        pageRequest.exception?.let {
            return LoadResult.Error(it)
        }

        return LoadResult.Page(
            data = pageRequest.body.articles.map {
                ArticleMapper.buildFrom(it)
            },
            prevKey = null,
            nextKey = getNextPage(pageNumber)
        )

    }

    override fun getRefreshKey(state: PagingState<Int, DomainArticle>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?:state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    private fun getNextPage(pageNumber : Int) : Int?{
        return if(pageNumber < Constants.maxPage){
            pageNumber.plus(1)
        }else{
            null
        }
    }

}