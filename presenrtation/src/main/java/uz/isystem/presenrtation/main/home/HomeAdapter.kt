package uz.isystem.presenrtation.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.isystem.data.data.models.Offer
import uz.isystem.presenrtation.R
import uz.isystem.presenrtation.databinding.ItemMusicOfferBinding

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {


    private val data = ArrayList<Offer>()

    fun setData(data: List<Offer>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemMusicOfferBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: Offer) {
            binding.price.text = data.price.value.toString()
            binding.city.text = data.town
            binding.title.text = data.title
            when(data.id){
                1->{binding.image.setImageResource(R.drawable.music_offer1)}
                2->{binding.image.setImageResource(R.drawable.music_offer2)}
                3->{binding.image.setImageResource(R.drawable.music_offer3)}
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMusicOfferBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(data[position])
    }
}