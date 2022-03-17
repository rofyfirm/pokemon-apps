package id.rofyfirm.pokemonapps.ui.stat

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import id.rofyfirm.pokemonapps.databinding.FragmentStatBinding


class StatFragment : Fragment() {

    private val viewModel by lazy { ViewModelProvider(requireActivity())[StatViewModel::class.java] }
    private lateinit var binding: FragmentStatBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding =  FragmentStatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val id = requireActivity().intent.getIntExtra("id", 0)
        viewModel.fetch(id)
        viewModel.statResponse.observe(viewLifecycleOwner){
            Glide.with(this)
                .load(Uri.parse(it.sprites?.other?.officialArtwork?.frontDefault))
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .into(binding.image)
            binding.name.text = it.name

        }

        viewModel.fetchSpecies(id)
        viewModel.speciesResponse.observe(viewLifecycleOwner){
            binding.form.text = it.flavorTextEntries[0].flavorText

            it.evolutionChain?.url?.let { it1 -> viewModel.savePreferences("evo", it1) }
        }
    }
}