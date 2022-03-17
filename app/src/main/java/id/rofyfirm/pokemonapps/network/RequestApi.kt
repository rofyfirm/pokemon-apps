package id.rofyfirm.pokemonapps.network

import id.rofyfirm.pokemonapps.network.response.EvoResponse
import id.rofyfirm.pokemonapps.network.response.StatResponse
import id.rofyfirm.pokemonapps.network.response.MainResponse
import id.rofyfirm.pokemonapps.network.response.SpeciesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface RequestApi {

    @GET("pokemon/")
    suspend fun pokemonList(): Response<MainResponse>

    @GET("pokemon/{id}")
    suspend fun pokemonDetail(
        @Path("id") id: Int?,
    ): Response<StatResponse>

    @GET("pokemon-species/{id}")
    suspend fun pokemonSpecies(
        @Path("id") id: Int?,
    ): Response<SpeciesResponse>

    @GET
    suspend fun pokemonEvo(
        @Url url: String?,
    ): Response<EvoResponse>
}