package com.fernandocejas.sample.features.databaseArchitecutre

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.annotation.StringRes
import android.view.View
import com.fernandocejas.sample.R
import com.fernandocejas.sample.core.exception.Failure
import com.fernandocejas.sample.core.extension.observe
import com.fernandocejas.sample.core.extension.viewModel
import com.fernandocejas.sample.core.navigation.Navigator
import com.fernandocejas.sample.core.platform.BaseFragment
import com.fernandocejas.sample.features.mindvalleys.localDB.MindValleyDatabase
import com.fernandocejas.sample.features.mindvalleys.models.CategoryBO
import com.fernandocejas.sample.features.movies.MovieFailure
import javax.inject.Inject

class MindValleyFragmentNew : BaseFragment(){
    override fun layoutId(): Int = R.layout.fragment_mindvalley_dashboard

    @Inject
    lateinit var navigator: Navigator

    private lateinit var mindValleyViewModel: MindValleyViewModelNew

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

        mindValleyViewModel = viewModel(viewModelFactory){

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

    private fun renderMoviesList(categories:List<CategoryBO>) {
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