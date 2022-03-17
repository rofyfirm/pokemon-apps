package id.rofyfirm.pokemonapps.ui.evo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.rofyfirm.pokemonapps.network.repository.Repository
import id.rofyfirm.pokemonapps.network.response.EvoResponse
import kotlinx.coroutines.launch

class EvoViewModel(private val repository: Repository): ViewModel() {

    val evoResponse: MutableLiveData<EvoResponse> = MutableLiveData()

    fun fetch(url: String) = viewModelScope.launch {
        val response = repository.fetchPokemonEvo(url)
        evoResponse.value = response.body()
    }

    fun getPref(name: String): String?{
        return repository.getPref(name)
    }
}