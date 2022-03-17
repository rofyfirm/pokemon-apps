package id.rofyfirm.pokemonapps.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.rofyfirm.pokemonapps.db.pres.MainEntity
import id.rofyfirm.pokemonapps.network.repository.Repository
import id.rofyfirm.pokemonapps.network.response.MainResponse
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {

    val mainResponse: MutableLiveData<MainResponse> = MutableLiveData()
    val main: LiveData<List<MainEntity>> = repository.get()

    init {
        fetch()
    }

    fun fetch() = viewModelScope.launch {
        val response = repository.fetchPokemonList()
        mainResponse.value = response.body()
        save(response.body()?.results)
    }

    private fun save(mainResponse: ArrayList<MainResponse.Results>?) = viewModelScope.launch {
        for (i in 0..(mainResponse?.size?.minus(1)!!)){
            mainResponse[i].name?.let { MainEntity(name = it) }?.let { repository.save(it) }
        }
    }
}