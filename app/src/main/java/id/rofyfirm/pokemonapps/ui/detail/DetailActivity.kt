package id.rofyfirm.pokemonapps.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import id.rofyfirm.pokemonapps.databinding.ActivityDetailBinding
import id.rofyfirm.pokemonapps.ui.stat.StatViewModel
import id.rofyfirm.pokemonapps.ui.stat.StatViewModelFactory
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class DetailActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val statViewModelFactory: StatViewModelFactory by instance()
    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
        initViewModel()
    }

    private fun init(){
        val titles = arrayOf("Stat","Evolution")
        val tabAdapter = DetailTabAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = tabAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab, position ->
            tab.text = titles[position]
        }.attach()
    }

    private fun initViewModel(){
        ViewModelProvider(this, statViewModelFactory)[StatViewModel::class.java]
    }
}