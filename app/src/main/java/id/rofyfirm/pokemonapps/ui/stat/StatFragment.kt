package id.rofyfirm.pokemonapps.ui.stat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import id.rofyfirm.pokemonapps.R
import id.rofyfirm.pokemonapps.databinding.FragmentStatBinding
import id.rofyfirm.pokemonapps.ui.detail.DetailViewModel

class StatFragment : Fragment() {

    private val viewModel by lazy { ViewModelProvider(requireActivity()).get(DetailViewModel::class.java) }
    private lateinit var binding: FragmentStatBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding =  FragmentStatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.titleBar.postValue("Status")

    }
}