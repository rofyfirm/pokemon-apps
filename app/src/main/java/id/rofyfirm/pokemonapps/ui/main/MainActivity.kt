package id.rofyfirm.pokemonapps.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.rofyfirm.pokemonapps.databinding.ActivityMainBinding
import id.rofyfirm.pokemonapps.network.response.MainResponse
import id.rofyfirm.pokemonapps.ui.detail.DetailActivity
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val viewModelFactory: MainViewModelFactory by instance()
    private lateinit var viewModel: MainViewModel
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
                startActivity(Intent(this@MainActivity, DetailActivity::class.java))
            }
        })

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mainAdapter
        }

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.mainResponse.observe(this) {
           mainAdapter.setData(it.results!!)
        }
    }

    private fun listener(){

    }
}