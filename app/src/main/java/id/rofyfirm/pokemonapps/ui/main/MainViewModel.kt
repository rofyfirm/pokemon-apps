package id.rofyfirm.pokemonapps.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.rofyfirm.pokemonapps.network.RequestApi
import id.rofyfirm.pokemonapps.network.response.MainResponse
import kotlinx.coroutines.launch

class MainViewModel(val requestApi: RequestApi): ViewModel() {

    val response: MutableLiveData<MainResponse> = MutableLiveData()

    init {
        fetch()
    }

    fun fetch() = viewModelScope.launch {
        response.value = requestApi.pokemonList().body()
    }
}