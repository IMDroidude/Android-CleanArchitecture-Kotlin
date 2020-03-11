package com.fernandocejas.sample.features.databaseArchitecutre

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.content.Context
import com.fernandocejas.sample.core.exception.Failure
import com.fernandocejas.sample.core.interactor.UseCase
import com.fernandocejas.sample.core.platform.BaseViewModel
import com.fernandocejas.sample.features.mindvalleys.localDB.MindValleyDao
import com.fernandocejas.sample.features.mindvalleys.localDB.MindValleyDatabase
import com.fernandocejas.sample.features.mindvalleys.models.CategoryBO
import com.fernandocejas.sample.features.mindvalleys.models.CategoryPayload
import com.fernandocejas.sample.features.mindvalleys.useCases.GetCategories
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MindValleyViewModelNew @Inject constructor(private val mindValleyDao: MindValleyDao,private val getCategories: GetCategories) : BaseViewModel() {

    var categoryList: LiveData<List<CategoryBO>> = mindValleyDao.getCategories()

    /*fun loadDatabase(mContext:Context){
        ///mindValleyDao = MindValleyDatabase.getDatabase(mContext).mindValleyDao()

        GlobalScope.launch(Dispatchers.IO) {
            mindValleyDao.insert(CategoryBO(0,"first item"))
        }
        categoryList = mindValleyDao.getCategories()
    }*/

    fun loadCategories() = getCategories(UseCase.None()) { it.fold(::handleCategoryFailure, ::handleCategories) }//getCategories(UseCase.None()) { it.fold(::handleFailure, ::handleCategories) }

    protected fun handleCategoryFailure(failure: Failure) {
        //this.categoryFailure.value = failure
    }

    private fun handleCategories(categoryPayload: CategoryPayload?){
        categoryPayload?.let {
            mindValleyDao.insert(it.categories)
        }
    }
}