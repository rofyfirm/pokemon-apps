package id.rofyfirm.pokemonapps.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import id.rofyfirm.pokemonapps.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProvider(this).get(DetailViewModel::class.java) }
    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
        listener()
    }

    private fun init(){
        val titles = arrayOf("Stat","Evolution")
        val tabAdapter = DetailTabAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = tabAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab, position ->
            tab.text = titles[position]
        }.attach()
    }

    private fun listener(){

    }
}