package com.fernandocejas.sample.features.mindvalleys.localDB

import androidx.lifecycle.LiveData
import com.fernandocejas.sample.features.mindvalleys.models.CategoryBO

class MindValleyRepository(private val mindValleyDao: MindValleyDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allWords: LiveData<List<CategoryBO>> = mindValleyDao.getCategories()

    suspend fun insert(word: CategoryBO) {
        mindValleyDao.insert(word)
    }
}