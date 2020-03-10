package com.fernandocejas.sample.features.mindvalleys.localDB

import com.fernandocejas.sample.features.mindvalleys.models.CategoryPayload
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomService @Inject constructor(val mindValleyDao: MindValleyDao) : RoomApi{

    override fun categories(): CategoryPayload {
        return CategoryPayload(mindValleyDao.getCategories().value!!)
    }

}