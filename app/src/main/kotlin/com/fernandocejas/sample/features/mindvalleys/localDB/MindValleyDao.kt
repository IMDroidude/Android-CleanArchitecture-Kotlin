package com.fernandocejas.sample.features.mindvalleys.localDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fernandocejas.sample.features.mindvalleys.models.CategoryBO
import com.fernandocejas.sample.features.mindvalleys.models.ChannelBO
import com.fernandocejas.sample.features.mindvalleys.models.EpisodeBO

@Dao
interface MindValleyDao {

    @Query("SELECT * from CategoryEntity ORDER BY id ASC")
    fun getCategories(): LiveData<List<CategoryBO>>

    @Query("SELECT * from EpisodeEntity ORDER BY id ASC")
    fun getEpisodes(): LiveData<List<EpisodeBO>>

    @Query("SELECT * from ChannelEntity ORDER BY mID ASC")// ORDER BY id ASC
    fun getChannels(): LiveData<List<ChannelBO>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertCategory(categoryBO: CategoryBO)
    //suspend fun insert(categoryBO: CategoryBO)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertCategories(categoryBOList: List<CategoryBO>)


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertChannels(channelBOList: List<ChannelBO>)

    //suspend fun insert(categoryBO: CategoryBO)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertEpisodes(episodeBOList: List<EpisodeBO>)
}