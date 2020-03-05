package com.fernandocejas.sample.features.mindvalleys.useCases

import com.fernandocejas.sample.core.interactor.UseCase
import com.fernandocejas.sample.features.mindvalleys.models.CategoryPayload
import com.fernandocejas.sample.features.movies.MoviesRepository
import javax.inject.Inject

/*class GetCategories
@Inject constructor(private val moviesRepository: MoviesRepository) : UseCase<List<CategoryBO>, UseCase.None>() {

    override suspend fun run(params: None) = moviesRepository.categories()
}*/

class GetCategories
@Inject constructor(private val moviesRepository: MoviesRepository) : UseCase<CategoryPayload, UseCase.None>() {

    override suspend fun run(params: None) = moviesRepository.categories()

    //data class Params(val id: Int)
}
