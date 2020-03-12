package com.fernandocejas.sample.features.mindvalleys.localDB

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import androidx.room.TypeConverters
import com.fernandocejas.sample.features.mindvalleys.converters.Converters
import com.fernandocejas.sample.features.mindvalleys.models.*

@Database(entities = arrayOf(CategoryBO::class,EpisodeBO::class,ChannelBO::class), version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class MindValleyDatabase : RoomDatabase(){

    abstract fun mindValleyDao(): MindValleyDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: MindValleyDatabase? = null

        fun getDatabase(context: Context): MindValleyDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        MindValleyDatabase::class.java,
                        "mindvalley_database"
                ).allowMainThreadQueries()
                        .fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}