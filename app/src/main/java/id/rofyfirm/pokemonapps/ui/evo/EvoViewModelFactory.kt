package id.rofyfirm.pokemonapps.ui.evo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.rofyfirm.pokemonapps.network.repository.Repository

class EvoViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EvoViewModel(repository) as T
    }
}