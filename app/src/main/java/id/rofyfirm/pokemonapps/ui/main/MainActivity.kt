package id.rofyfirm.pokemonapps.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.rofyfirm.pokemonapps.databinding.ActivityMainBinding
import id.rofyfirm.pokemonapps.network.ApiService
import id.rofyfirm.pokemonapps.network.response.MainResponse
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val apiService by lazy { ApiService.getClient() }
    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: MainViewModelFactory
    private lateinit var mainAdapter: MainAdapter
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
        mainAdapter = MainAdapter(arrayListOf(), object: MainAdapter.OnAdapterListener{
            override fun OnClick(result: MainResponse.Results) {

            }
        })

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mainAdapter
        }

        viewModelFactory = MainViewModelFactory(apiService)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.response.observe(this) {
           mainAdapter.setData(it.results!!)
        }
    }

    private fun listener(){

    }
}