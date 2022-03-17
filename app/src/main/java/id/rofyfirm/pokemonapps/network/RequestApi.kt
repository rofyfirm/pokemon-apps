package id.rofyfirm.pokemonapps.network

import id.rofyfirm.pokemonapps.network.response.DetailResponse
import id.rofyfirm.pokemonapps.network.response.MainResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RequestApi {

    @GET("pokemon/")
    suspend fun pokemonList(): Response<MainResponse>

    @GET("pokemon/{id}")
    suspend fun pokemonDetail(
        @Path("id") id: Int?,
    ): Response<DetailResponse>
}