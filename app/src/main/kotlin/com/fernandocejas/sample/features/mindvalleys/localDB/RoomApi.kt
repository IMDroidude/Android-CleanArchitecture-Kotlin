package com.fernandocejas.sample.features.mindvalleys.localDB

import com.fernandocejas.sample.features.mindvalleys.models.CategoryPayload

internal interface RoomApi{

    fun categories(): CategoryPayload
    //fun episodes(): EpisodePayload
    //fun channels(): ChannelPayload
}