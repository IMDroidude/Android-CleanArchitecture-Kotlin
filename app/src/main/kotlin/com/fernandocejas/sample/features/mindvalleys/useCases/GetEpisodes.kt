package com.fernandocejas.sample.features.mindvalleys.useCases

import com.fernandocejas.sample.core.interactor.UseCase
import com.fernandocejas.sample.features.mindvalleys.models.EpisodePayload
import com.fernandocejas.sample.features.movies.MoviesRepository
import javax.inject.Inject

class GetEpisodes
@Inject constructor(private val moviesRepository: MoviesRepository) : UseCase<EpisodePayload, UseCase.None>() {

    override suspend fun run(params: None) = moviesRepository.episodes()
    //data class Params(val id: Int)
}