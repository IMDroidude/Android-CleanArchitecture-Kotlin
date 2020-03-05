package com.fernandocejas.sample.features.mindvalleys.useCases

import com.fernandocejas.sample.core.interactor.UseCase
import com.fernandocejas.sample.features.mindvalleys.models.ChannelPayload
import com.fernandocejas.sample.features.movies.MoviesRepository
import javax.inject.Inject

class GetChannels
@Inject constructor(private val moviesRepository: MoviesRepository) : UseCase<ChannelPayload, UseCase.None>() {

    override suspend fun run(params: None) = moviesRepository.channels()

    //data class Params(val id: Int)
}