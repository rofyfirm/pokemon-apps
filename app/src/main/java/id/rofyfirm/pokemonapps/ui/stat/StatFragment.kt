package id.rofyfirm.pokemonapps.ui.stat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.rofyfirm.pokemonapps.R
import id.rofyfirm.pokemonapps.databinding.FragmentStatBinding

class StatFragment : Fragment() {

    private lateinit var binding: FragmentStatBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding =  FragmentStatBinding.inflate(inflater, container, false)
        return binding.root
    }
}