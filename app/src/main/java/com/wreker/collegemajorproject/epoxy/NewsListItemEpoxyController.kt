package com.wreker.collegemajorproject.epoxy

import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.paging3.PagingDataEpoxyController
import com.squareup.picasso.Picasso
import com.wreker.collegemajorproject.R
import com.wreker.collegemajorproject.api.model.DomainArticle
import com.wreker.collegemajorproject.databinding.ModelNewsItemBinding

class NewsListItemEpoxyController : PagingDataEpoxyController<DomainArticle>() {

    override fun buildItemModel(currentPosition: Int, item: DomainArticle?): EpoxyModel<*> {

        return NewsListItemEpoxyModel(
            domainArticle = item!!
        ).id("article_id${item.title}")

    }

    override fun addModels(models: List<EpoxyModel<*>>) {

        if(models.isEmpty()){
            LoadingEpoxyController().id("loading").addTo(this)
            return
        }

        super.addModels(models)
    }

    data class NewsListItemEpoxyModel(
        val domainArticle : DomainArticle
    ) : ViewBindingKotlinModel<ModelNewsItemBinding>(R.layout.model_news_item){

        override fun ModelNewsItemBinding.bind() {
            ttvTitle.text = domainArticle.title
            ttvDescription.text = domainArticle.subTitle

            domainArticle.imageUrl?.let {

                if(it.isEmpty()){
                    Picasso.get().load(R.drawable.no_picture).into(imgArticle)
                }else{
                    Picasso.get().load(it).into(imgArticle)
                }

            }

        }

    }

}