package com.fernandocejas.sample.features.databaseArchitecutre

import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.fernandocejas.sample.R
import com.fernandocejas.sample.core.exception.Failure
import com.fernandocejas.sample.core.extension.viewModel
import com.fernandocejas.sample.core.navigation.Navigator
import com.fernandocejas.sample.core.platform.BaseFragment
import com.fernandocejas.sample.features.mindvalleys.models.CategoryBO
import com.fernandocejas.sample.features.mindvalleys.rv_adapter.CategoriesAdapter
import com.fernandocejas.sample.features.mindvalleys.rv_adapter.ChannelsAdapter
import com.fernandocejas.sample.features.mindvalleys.rv_adapter.EpisodesAdapter
import com.fernandocejas.sample.features.movies.MovieFailure
import kotlinx.android.synthetic.main.fragment_mindvalley_dashboard.*
import javax.inject.Inject

class MindValleyFragmentNew : BaseFragment() {
    override fun layoutId(): Int = R.layout.fragment_mindvalley_dashboard

    @Inject
    lateinit var navigator: Navigator

    private lateinit var mindValleyViewModel: MindValleyViewModelNew

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

        mindValleyViewModel = viewModel(viewModelFactory) {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //mindValleyViewModel.loadDatabase(context!!)

        initializeView()
        loadCategoryList()

        mindValleyViewModel.categoryList.observe(this, Observer {
            val categories = it
            //display categories in list..
            categories?.let {
                context?.let { ctx ->
                    val adapter = CategoriesAdapter(ctx, categories)
                    rv_main_categories.adapter = adapter
                }
            }

        })


        mindValleyViewModel.episodesList.observe(this, Observer {
            it?.let {
                val linearLayoutManager = LinearLayoutManager(context)
                linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
                rv_main_episodes.layoutManager = linearLayoutManager
                context?.let { ctx ->
                    val adapter = EpisodesAdapter(ctx, it)
                    rv_main_episodes.adapter = adapter
                }
            }

        })




     /*   mindValleyViewModel.channelsList.observe(this, Observer {
            it?.let {
                val linearLayoutManager = LinearLayoutManager(context)
                linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
                rv_main_channel.layoutManager = linearLayoutManager
                context?.let { ctx ->
                    val adapter = ChannelsAdapter(ctx, it)
                    rv_main_channel.adapter = adapter
                }
            }

        })*/


    }

    private fun initializeView() {
        ///movieList.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        /*movieList.adapter = moviesAdapter
        moviesAdapter.clickListener = { movie, navigationExtras ->
            navigator.showMovieDetails(activity!!, movie, navigationExtras) }*/
    }

    private fun loadCategoryList() {
        mindValleyViewModel.loadCategories()
        mindValleyViewModel.loadEpisodes()

    }

    private fun renderMoviesList(categories: List<CategoryBO>) {
        //moviesAdapter.collection = movies.orEmpty()
//        hideProgress()
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
//        hideProgress()
        ///notifyWithAction(message, R.string.action_refresh, ::loadMoviesList)
    }
}