package com.fernandocejas.sample.features.mindvalleys

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.annotation.StringRes
import android.view.View
import com.fernandocejas.sample.R
import com.fernandocejas.sample.core.exception.Failure
import com.fernandocejas.sample.core.extension.*
import com.fernandocejas.sample.core.navigation.Navigator
import com.fernandocejas.sample.core.platform.BaseFragment
import com.fernandocejas.sample.features.mindvalleys.models.CategoryPayload
import com.fernandocejas.sample.features.mindvalleys.models.ChannelPayload
import com.fernandocejas.sample.features.mindvalleys.models.EpisodePayload
import com.fernandocejas.sample.features.movies.MovieFailure
import javax.inject.Inject

class MindValleyFragment :BaseFragment(){
    override fun layoutId(): Int = R.layout.fragment_mindvalley_dashboard

    @Inject
    lateinit var navigator: Navigator

    private lateinit var mindValleyViewModel: MindValleyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)


        mindValleyViewModel = viewModel(viewModelFactory){
            observe(categoryPayload, ::renderMoviesList)
            failure(categoryFailure,::handleFailure)
            observe(episodePayload, ::renderEpisodeList)
            //failure(episodeFailure, ::handleFai)
            observe(channelPayload,::renderChannelList)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
        //loadCategoryList()
        loadEpisodeList()
        //loadChannelsList()

        /*mindValleyViewModel.categories.listen(this){

        }*/
        mindValleyViewModel.categoryPayload.observe(this, Observer {
            val mlist = it
        })

        /*mindValleyViewModel.categories.listen(this){
            renderMoviesList(it)
        }*/
        ///mindValleyViewModel.categories.observe(this, {})
    }

    private fun initializeView() {
        ///movieList.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        /*movieList.adapter = moviesAdapter
        moviesAdapter.clickListener = { movie, navigationExtras ->
            navigator.showMovieDetails(activity!!, movie, navigationExtras) }*/
    }

    private fun loadCategoryList() {
        //emptyView.invisible()
        //movieList.visible()
        showProgress()
        mindValleyViewModel.loadCategories()
    }

    private fun loadEpisodeList() {
        //emptyView.invisible()
        //movieList.visible()
        showProgress()
        mindValleyViewModel.loadEpisodes()
    }

    private fun loadChannelsList() {
        //emptyView.invisible()
        //movieList.visible()
        showProgress()
        mindValleyViewModel.loadChannels()
    }
    private fun renderMoviesList(categoryPayload: CategoryPayload?) {
        //moviesAdapter.collection = movies.orEmpty()
        hideProgress()
    }

    private fun renderEpisodeList(categoryPayload: EpisodePayload?) {
        //moviesAdapter.collection = movies.orEmpty()
        hideProgress()
    }

    private fun renderChannelList(categoryPayload: ChannelPayload?) {
        //moviesAdapter.collection = movies.orEmpty()
        hideProgress()
    }

    private fun handleFailure(failure: Failure?) {
        when (failure) {
            is Failure.NetworkConnection -> renderFailure(R.string.failure_network_connection)
            is Failure.ServerError -> renderFailure(R.string.failure_server_error)
            is MovieFailure.ListNotAvailable -> renderFailure(R.string.failure_movies_list_unavailable)
        }
    }

    private fun renderFailure(@StringRes message: Int) {
        //movieList.invisible()
        ///emptyView.visible()
        hideProgress()
        ///notifyWithAction(message, R.string.action_refresh, ::loadMoviesList)
    }
}