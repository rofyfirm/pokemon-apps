package id.rofyfirm.pokemonapps.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.rofyfirm.pokemonapps.network.RequestApi
import id.rofyfirm.pokemonapps.network.repository.Repository
import id.rofyfirm.pokemonapps.network.response.MainResponse
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {

    val mainResponse: MutableLiveData<MainResponse> = MutableLiveData()

    init {
        fetch()
    }

    fun fetch() = viewModelScope.launch {
        val response = repository.fetchPokemonList()
        mainResponse.value = response.body()
    }
}