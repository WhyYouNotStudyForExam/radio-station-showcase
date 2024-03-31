package com.example.radiostationshowcase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.radiostationshowcase.R
import com.example.radiostationshowcase.domain.model.RadioStation

class RadioStationsAdapter(
    private var items: List<RadioStation>
) : RecyclerView.Adapter<RadioStationsAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nameTextView: TextView = view.findViewById(R.id.title)

        fun bind(item: RadioStation) {
            nameTextView.text = item.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.radiostation_item,
                parent,
                false
            )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun updateItems(newItems: List<RadioStation>) {
        items = newItems
        notifyDataSetChanged()
    }
}