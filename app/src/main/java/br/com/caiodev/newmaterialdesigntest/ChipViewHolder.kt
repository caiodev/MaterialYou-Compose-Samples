package br.com.caiodev.newmaterialdesigntest

import androidx.recyclerview.widget.RecyclerView
import br.com.caiodev.newmaterialdesigntest.databinding.ChipListItemBinding

class ChipViewHolder(private val binding: ChipListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(content: String) {
        binding.chip.text = content
    }
}
