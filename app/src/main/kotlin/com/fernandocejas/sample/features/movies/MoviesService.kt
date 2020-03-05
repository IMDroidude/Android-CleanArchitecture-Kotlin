/**
 * Copyright (C) 2018 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fernandocejas.sample.features.movies

import com.fernandocejas.sample.features.mindvalleys.*
import com.fernandocejas.sample.features.mindvalleys.models.ChannelPayload
import com.fernandocejas.sample.features.mindvalleys.models.EpisodePayload
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesService
@Inject constructor(retrofit: Retrofit) : MoviesApi {
    private val moviesApi by lazy { retrofit.create(MoviesApi::class.java) }

    override fun movies() = moviesApi.movies()
    override fun movieDetails(movieId: Int) = moviesApi.movieDetails(movieId)

    override fun categories()  = moviesApi.categories()
    override fun episodes(): Call<WebResponse<EpisodePayload>>  = moviesApi.episodes()

    override fun channels(): Call<WebResponse<ChannelPayload>> = moviesApi.channels()


}
