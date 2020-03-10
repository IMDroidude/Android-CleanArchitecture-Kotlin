package com.fernandocejas.sample.features.databaseArchitecutre

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.fernandocejas.sample.core.exception.Failure
import com.fernandocejas.sample.core.interactor.UseCase
import com.fernandocejas.sample.core.platform.BaseViewModel
import com.fernandocejas.sample.features.mindvalleys.localDB.MindValleyDao
import com.fernandocejas.sample.features.mindvalleys.localDB.MindValleyDatabase
import com.fernandocejas.sample.features.mindvalleys.models.CategoryBO
import com.fernandocejas.sample.features.mindvalleys.models.CategoryPayload
import com.fernandocejas.sample.features.mindvalleys.useCases.GetCategories
import javax.inject.Inject

class MindValleyViewModelNew @Inject constructor(private val getCategories: GetCategories) : BaseViewModel() {

    //var movies: MutableLiveData<List<MovieView>> = MutableLiveData()
    var categoryList: MutableLiveData<List<CategoryBO>> = MutableLiveData()
    private lateinit var mindValleyDao:MindValleyDao
    /*var episodePayload: MutableLiveData<EpisodePayload> = MutableLiveData()
    var channelPayload: MutableLiveData<ChannelPayload> = MutableLiveData()

    var categoryFailure: MutableLiveData<Failure> = MutableLiveData()
    var episodeFailure: MutableLiveData<Failure> = MutableLiveData()
    var channelFailure: MutableLiveData<Failure> = MutableLiveData()*/

    fun loadDatabase(mContext:Context){
        mindValleyDao = MindValleyDatabase.getDatabase(mContext).mindValleyDao()
        categoryList.postValue(mindValleyDao.getCategories().value)
    }

    fun loadCategories() = getCategories(UseCase.None()) { it.fold(::handleCategoryFailure, ::handleCategories) }//getCategories(UseCase.None()) { it.fold(::handleFailure, ::handleCategories) }
    /*fun loadCategories() = getCategories(UseCase.None()) { it.fold(::handleCategoryFailure, ::handleCategories) }//getCategories(UseCase.None()) { it.fold(::handleFailure, ::handleCategories) }
    fun loadEpisodes() = getEpisodes(UseCase.None()) { it.fold(::handleEpisodeFailure, ::handleEpisodes) }//getCategories(UseCase.None()) { it.fold(::handleFailure, ::handleCategories) }
    fun loadChannels() = getChannels(UseCase.None()) { it.fold(::handleChannelFailure, ::handleChannels) }//getCategories(UseCase.None()) { it.fold(::handleFailure, ::handleCategories) }*/


    /*private fun handleEpisodes(episodePayload: EpisodePayload) {
        this.episodePayload.value = episodePayload//movies.map { MovieView(it.id, it.poster) }
    }

    private fun handleChannels(channelPayload: ChannelPayload) {
        this.channelPayload.value = channelPayload//movies.map { MovieView(it.id, it.poster) }
    }

    protected fun handleCategoryFailure(failure: Failure) {
        this.categoryFailure.value = failure
    }

    protected fun handleEpisodeFailure(failure: Failure) {
        this.episodeFailure.value = failure
    }
    protected fun handleChannelFailure(failure: Failure) {
        this.channelFailure.value = failure
    }*/

    protected fun handleCategoryFailure(failure: Failure) {
        //this.categoryFailure.value = failure
    }

    private fun handleCategories(categoryPayload: CategoryPayload?){

        categoryPayload?.let {
            mindValleyDao.insert(it.categories)
        }
    }
}