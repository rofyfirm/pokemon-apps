package id.rofyfirm.pokemonapps.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import id.rofyfirm.pokemonapps.databinding.ItemMainBinding
import id.rofyfirm.pokemonapps.network.response.MainResponse

class MainAdapter(
    val results: ArrayList<MainResponse.Results>,
    val listener: OnAdapterListener): RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = results[position]
        holder.binding.name.text = result.name
        holder.binding.itemLayout.setOnClickListener {
            listener.OnClick(result)
        }
    }

    override fun getItemCount(): Int {
        return results.size
    }

    class ViewHolder(val binding: ItemMainBinding): RecyclerView.ViewHolder(binding.root)

    interface OnAdapterListener{
        fun OnClick(result: MainResponse.Results)
    }

    fun setData(data: List<MainResponse.Results>){
        results.clear()
        results.addAll(data)
        notifyDataSetChanged()
    }
}