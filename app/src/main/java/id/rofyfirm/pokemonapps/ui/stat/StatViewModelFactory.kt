package id.rofyfirm.pokemonapps.ui.stat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.rofyfirm.pokemonapps.network.repository.Repository

class StatViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return StatViewModel(repository) as T
    }
}