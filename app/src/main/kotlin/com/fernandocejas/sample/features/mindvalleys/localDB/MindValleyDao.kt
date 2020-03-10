package com.fernandocejas.sample.features.mindvalleys.localDB

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
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

    /*@Query("DELETE FROM word_table")
    suspend fun deleteAll()*/
}