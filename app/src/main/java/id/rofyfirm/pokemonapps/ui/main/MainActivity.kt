package id.rofyfirm.pokemonapps.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.rofyfirm.pokemonapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
        listener()
    }

    private fun init(){

    }

    private fun listener(){

    }
}