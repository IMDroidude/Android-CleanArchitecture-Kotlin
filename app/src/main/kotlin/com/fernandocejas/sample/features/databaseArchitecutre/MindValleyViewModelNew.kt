package com.fernandocejas.sample.features.databaseArchitecutre

import androidx.lifecycle.LiveData
import com.fernandocejas.sample.core.exception.Failure
import com.fernandocejas.sample.core.interactor.UseCase
import com.fernandocejas.sample.core.platform.BaseViewModel
import com.fernandocejas.sample.features.mindvalleys.localDB.MindValleyDao
import com.fernandocejas.sample.features.mindvalleys.models.*
import com.fernandocejas.sample.features.mindvalleys.useCases.GetCategories
import com.fernandocejas.sample.features.mindvalleys.useCases.GetChannels
import com.fernandocejas.sample.features.mindvalleys.useCases.GetEpisodes
import javax.inject.Inject

class MindValleyViewModelNew @Inject constructor(private val mindValleyDao: MindValleyDao,
                                                 private val getCategories: GetCategories,
                                                 private val getEpisodes: GetEpisodes,
                                                 private val getChannels: GetChannels
                                                 ) : BaseViewModel() {

    var categoryList: LiveData<List<CategoryBO>> = mindValleyDao.getCategories()
    var episodesList: LiveData<List<EpisodeBO>> = mindValleyDao.getEpisodes()
    ///var channelsList: LiveData<List<ChannelBO>> = mindValleyDao.getChannels()

    /*fun loadDatabase(mContext:Context){
        ///mindValleyDao = MindValleyDatabase.getDatabase(mContext).mindValleyDao()

        GlobalScope.launch(Dispatchers.IO) {
            mindValleyDao.insert(CategoryBO(0,"first item"))
        }
        categoryList = mindValleyDao.getCategories()
    }*/

    fun loadCategories() = getCategories(UseCase.None()) { it.fold(::handleCategoryFailure, ::handleCategories) }//getCategories(UseCase.None()) { it.fold(::handleFailure, ::handleCategories) }
    fun loadEpisodes() = getEpisodes(UseCase.None()) { it.fold(::handleCategoryFailure, ::handleEpisodes) }//getCategories(UseCase.None()) { it.fold(::handleFailure, ::handleCategories) }
    fun loadChannels() = getChannels(UseCase.None()) { it.fold(::handleEpisodeFailure, ::handleChannels) }//getCategories(UseCase.None()) { it.fold(::handleFailure, ::handleCategories) }

    protected fun handleCategoryFailure(failure: Failure) {
        //this.categoryFailure.value = failure
    }

    protected fun handleChannelFailure(failure: Failure) {
        //this.categoryFailure.value = failure
    }


    protected fun handleEpisodeFailure(failure: Failure) {
        //this.categoryFailure.value = failure
    }

    private fun handleCategories(categoryPayload: CategoryPayload?) {
        categoryPayload?.let {
            mindValleyDao.insertCategories(it.categories)
        }
    }



    private fun handleChannels(categoryPayload: ChannelPayload?) {
        categoryPayload?.let {
            mindValleyDao.insertChannels(it.payload)
        }
    }


    private fun handleEpisodes(categoryPayload: EpisodePayload?) {
        categoryPayload?.let {
            mindValleyDao.insertEpisodes(it.media)
        }
    }
}