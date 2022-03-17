package id.rofyfirm.pokemonapps.ui.evo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.rofyfirm.pokemonapps.network.repository.Repository
import id.rofyfirm.pokemonapps.network.response.EvoResponse
import kotlinx.coroutines.launch

class EvoViewModel(private val repository: Repository): ViewModel() {

    val evoResponse: MutableLiveData<EvoResponse> = MutableLiveData()

    fun fetch(id: Int) = viewModelScope.launch {
        val response = repository.fetchPokemonEvo(id)
        evoResponse.value = response.body()
    }

}