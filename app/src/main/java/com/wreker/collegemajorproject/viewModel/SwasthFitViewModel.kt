package com.wreker.collegemajorproject.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.wreker.collegemajorproject.epoxy.NewsItemPagingSource
import com.wreker.collegemajorproject.model.GetTopNewsHeadlines
import com.wreker.collegemajorproject.repository.SwasthFitRepository
import com.wreker.collegemajorproject.tools.Constants
import kotlinx.coroutines.launch

class SwasthFitViewModel : ViewModel(){

    val flow = Pager(
        PagingConfig(
            pageSize = Constants.pageSize,
            prefetchDistance = Constants.prefetchDistance,
            enablePlaceholders = false
        )
    ){
        NewsItemPagingSource()
    }.flow
        .cachedIn(viewModelScope)


}