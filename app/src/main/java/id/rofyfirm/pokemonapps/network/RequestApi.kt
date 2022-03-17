package id.rofyfirm.pokemonapps.network

import id.rofyfirm.pokemonapps.network.response.StatResponse
import id.rofyfirm.pokemonapps.network.response.MainResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RequestApi {

    @GET("pokemon/")
    suspend fun pokemonList(): Response<MainResponse>

    @GET("pokemon/{id}")
    suspend fun pokemonDetail(
        @Path("id") id: Int?,
    ): Response<StatResponse>

    @GET("pokemon/{id}")
    suspend fun pokemonEvo(
        @Path("id") id: Int?,
    ): Response<StatResponse>
}