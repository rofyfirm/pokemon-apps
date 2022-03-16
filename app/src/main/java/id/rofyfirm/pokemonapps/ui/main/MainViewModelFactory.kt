package id.rofyfirm.pokemonapps.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.rofyfirm.pokemonapps.network.RequestApi

class MainViewModelFactory(private val requestApi: RequestApi): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(requestApi) as T
    }
}