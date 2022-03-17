package id.rofyfirm.pokemonapps.network.repository

import id.rofyfirm.pokemonapps.db.pref.Preferences
import id.rofyfirm.pokemonapps.network.RequestApi

class Repository(
    private val requestApi: RequestApi,
    private val preferences: Preferences) {

    suspend fun fetchPokemonList() = requestApi.pokemonList()

    suspend fun fetchPokemonDetail(id: Int) = requestApi.pokemonDetail(id)

    suspend fun fetchPokemonSpecies(id: Int) = requestApi.pokemonSpecies(id)

    suspend fun fetchPokemonEvo(url: String) = requestApi.pokemonEvo(url)

    fun savePref(name: String, value: String){
        preferences.put(name, value)
    }

    fun getPref(name: String): String?{
        return preferences.getString(name)
    }
}