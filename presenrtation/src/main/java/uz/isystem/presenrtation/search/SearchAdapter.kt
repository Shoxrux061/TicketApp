package uz.isystem.presenrtation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.isystem.data.data.models.ticket_offer.TicketsOffer
import uz.isystem.presenrtation.databinding.ItemFlightsBinding

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {


    private val data = ArrayList<TicketsOffer>()

    fun setData(data: List<TicketsOffer>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemFlightsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: TicketsOffer) {

            for (i in 0..<data.time_range.size) {
                binding.time.text = binding.time.text.toString().plus(data.time_range[i]).plus("  ")
            }

            binding.title.text = data.title
            binding.price.text = "₽".plus(data.price.value.toString().plus(">"))

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemFlightsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(data[position])
    }
}