package com.fernandocejas.sample.features.mindvalleys

import com.google.gson.annotations.SerializedName

data class WebResponse<T>(@SerializedName("data")val payload: T){

    /*companion object{
        fun emptyResponse(val T){
            return WebResponse<T>(T(emptyList()))
            //return WebResponse<T>(T(emptyList<T>()))
        }
    }*/


    /*companion object {
        fun emptyItem() = T()
        fun emptyList() = ArrayList<T>()
    }*/

}