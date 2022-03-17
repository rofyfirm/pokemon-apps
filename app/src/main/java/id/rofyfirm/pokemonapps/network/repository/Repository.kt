package id.rofyfirm.pokemonapps.network.repository

import id.rofyfirm.pokemonapps.db.pref.Preferences
import id.rofyfirm.pokemonapps.db.pres.MainEntity
import id.rofyfirm.pokemonapps.db.pres.PokemonDatabase
import id.rofyfirm.pokemonapps.network.RequestApi

class Repository(
    private val requestApi: RequestApi,
    private val preferences: Preferences,
    private val db: PokemonDatabase) {

    suspend fun fetchPokemonList() = requestApi.pokemonList(24)

    suspend fun fetchPokemonDetail(id: Int) = requestApi.pokemonDetail(id)

    suspend fun fetchPokemonSpecies(id: Int) = requestApi.pokemonSpecies(id)

    suspend fun fetchPokemonEvo(url: String) = requestApi.pokemonEvo(url)

    fun savePref(name: String, value: String){
        preferences.put(name, value)
    }

    fun getPref(name: String): String?{
        return preferences.getString(name)
    }

    suspend fun save( mainEntity: MainEntity) {
        db.mainDao().insert( mainEntity )
    }

    fun get() = db.mainDao().select()
}