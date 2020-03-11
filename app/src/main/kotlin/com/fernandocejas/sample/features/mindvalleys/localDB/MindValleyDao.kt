package com.fernandocejas.sample.features.mindvalleys.localDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fernandocejas.sample.features.mindvalleys.models.CategoryBO

@Dao
interface MindValleyDao {

    @Query("SELECT * from CategoryEntity ORDER BY id ASC")
    fun getCategories(): LiveData<List<CategoryBO>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(categoryBO: CategoryBO)
    //suspend fun insert(categoryBO: CategoryBO)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(categoryBOList: List<CategoryBO>)
}