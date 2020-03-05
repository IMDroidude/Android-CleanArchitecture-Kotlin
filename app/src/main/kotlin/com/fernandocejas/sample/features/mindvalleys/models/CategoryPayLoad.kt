package com.fernandocejas.sample.features.mindvalleys.models

import com.fernandocejas.sample.features.mindvalleys.WebResponse
import com.google.gson.annotations.SerializedName

data class CategoryPayload(@SerializedName("categories") val categories:List<CategoryBO>){

    companion object {
        //fun empty() = CategoryPayload(ArrayList<CategoryBO>())
        fun emptyResponse() = WebResponse<CategoryPayload>(CategoryPayload(ArrayList<CategoryBO>()))

    }

    fun toCategoryList() :List<CategoryBO> {
        return this.categories
    }

    fun toEmptyList() :List<CategoryBO> {
        return ArrayList<CategoryBO>()
    }
}

data class CategoryBO(val name:String)