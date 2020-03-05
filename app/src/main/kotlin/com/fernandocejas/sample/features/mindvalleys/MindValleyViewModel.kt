package com.fernandocejas.sample.features.mindvalleys

import android.arch.lifecycle.MutableLiveData
import com.fernandocejas.sample.core.exception.Failure
import com.fernandocejas.sample.core.interactor.UseCase
import com.fernandocejas.sample.core.platform.BaseViewModel
import com.fernandocejas.sample.features.mindvalleys.models.CategoryPayload
import com.fernandocejas.sample.features.mindvalleys.models.ChannelPayload
import com.fernandocejas.sample.features.mindvalleys.models.EpisodePayload
import com.fernandocejas.sample.features.mindvalleys.useCases.GetCategories
import com.fernandocejas.sample.features.mindvalleys.useCases.GetChannels
import com.fernandocejas.sample.features.mindvalleys.useCases.GetEpisodes
import javax.inject.Inject

class MindValleyViewModel @Inject constructor(private val getCategories: GetCategories,
private val getEpisodes: GetEpisodes,private val getChannels: GetChannels) : BaseViewModel() {

    //var movies: MutableLiveData<List<MovieView>> = MutableLiveData()
    var categoryPayload: MutableLiveData<CategoryPayload> = MutableLiveData()
    var episodePayload: MutableLiveData<EpisodePayload> = MutableLiveData()
    var channelPayload: MutableLiveData<ChannelPayload> = MutableLiveData()

    var categoryFailure: MutableLiveData<Failure> = MutableLiveData()
    var episodeFailure: MutableLiveData<Failure> = MutableLiveData()
    var channelFailure: MutableLiveData<Failure> = MutableLiveData()

    fun loadCategories() = getCategories(UseCase.None()) { it.fold(::handleCategoryFailure, ::handleCategories) }//getCategories(UseCase.None()) { it.fold(::handleFailure, ::handleCategories) }
    fun loadEpisodes() = getEpisodes(UseCase.None()) { it.fold(::handleEpisodeFailure, ::handleEpisodes) }//getCategories(UseCase.None()) { it.fold(::handleFailure, ::handleCategories) }
    fun loadChannels() = getChannels(UseCase.None()) { it.fold(::handleChannelFailure, ::handleChannels) }//getCategories(UseCase.None()) { it.fold(::handleFailure, ::handleCategories) }


    private fun handleCategories(categoryPayload: CategoryPayload) {
        this.categoryPayload.value = categoryPayload//movies.map { MovieView(it.id, it.poster) }
    }

    private fun handleEpisodes(episodePayload: EpisodePayload) {
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
    }
}