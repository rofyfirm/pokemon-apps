package id.rofyfirm.pokemonapps.ui.evo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import id.rofyfirm.pokemonapps.databinding.FragmentEvoBinding

class EvoFragment : Fragment() {

    private val viewModel by lazy { ViewModelProvider(requireActivity())[EvoViewModel::class.java] }
    private lateinit var binding: FragmentEvoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding =  FragmentEvoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val string = viewModel.getPref("evo")
        viewModel.fetch(string!!)
        viewModel.evoResponse.observe(viewLifecycleOwner){
            binding.evo1.text = it?.chain?.species?.name
            if (!it?.chain?.evolvesTo.isNullOrEmpty()){
                binding.evo2.text = it?.chain?.evolvesTo?.get(0)?.species?.name
            }

            if (!it?.chain?.evolvesTo?.get(0)?.evolvesTo.isNullOrEmpty()){
                binding.evo3.text = it?.chain?.evolvesTo?.get(0)?.evolvesTo?.get(0)?.species?.name
            }
        }
    }
}