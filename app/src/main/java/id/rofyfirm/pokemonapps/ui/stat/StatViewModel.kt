package id.rofyfirm.pokemonapps.ui.stat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.rofyfirm.pokemonapps.network.repository.Repository
import id.rofyfirm.pokemonapps.network.response.StatResponse
import kotlinx.coroutines.launch

class StatViewModel(private val repository: Repository): ViewModel() {

    private val statResponse: MutableLiveData<StatResponse> = MutableLiveData()

    fun fetch(id: Int) = viewModelScope.launch {
        val response = repository.fetchPokemonDetail(id)
        statResponse.value = response.body()
    }
}