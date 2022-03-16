package id.rofyfirm.pokemonapps.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import id.rofyfirm.pokemonapps.databinding.ActivityMainBinding
import id.rofyfirm.pokemonapps.network.ApiService
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val apiService by lazy { ApiService.getClient() }
    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: MainViewModelFactory
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
        listener()
    }

    override fun onNavigateUp(): Boolean {
        onBackPressed()
        return super.onNavigateUp()
    }

    private fun init(){
        viewModelFactory = MainViewModelFactory(apiService)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.response.observe(this) {
            Timber.d("$it")
        }
    }

    private fun listener(){

    }
}