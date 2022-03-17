package id.rofyfirm.pokemonapps.network.repository

import id.rofyfirm.pokemonapps.network.RequestApi

class Repository(private val requestApi: RequestApi) {

    suspend fun fetchPokemonList() = requestApi.pokemonList()

    suspend fun fetchPokemonDetail(id: Int) = requestApi.pokemonDetail(id)

    suspend fun fetchPokemonEvo(id: Int) = requestApi.pokemonEvo(id)
}