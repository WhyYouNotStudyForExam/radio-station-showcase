package com.example.radiostationshowcase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.radiostationshowcase.R
import com.example.radiostationshowcase.domain.model.Playable

class RadioStationsAdapter(
    private var items: List<Playable>
) : RecyclerView.Adapter<RadioStationsAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val logoImageView: ImageView = view.findViewById(R.id.logoImageView)
        private val nameTextView: TextView = view.findViewById(R.id.playableName)
        private var cityNameTextView: TextView = view.findViewById(R.id.cityName)
        private var genreTextView: TextView = view.findViewById(R.id.genre)
        private var topicsTextView: TextView = view.findViewById(R.id.topics)

        fun bind(item: Playable) {
            nameTextView.text = item.name
            cityNameTextView.text =
                itemView.context.getString(R.string.city_country_name, item.city, item.country)
            genreTextView.text = "Genres: " + item.genres?.joinToString(", ")
            topicsTextView.text = "Themen: " + item.topics?.joinToString(", ")

            Glide.with(itemView.context)
                .load(item.logo300x300)
                .into(logoImageView)
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
        holder.itemView.apply {
            setOnClickListener {
                onItemClickListener?.let { it(items[position]) }
            }
        }
    }

    fun updateItems(newItems: List<Playable>) {
        items = newItems
        notifyDataSetChanged()
    }

    private var onItemClickListener: ((Playable) -> Unit)? = null

    fun setOnItemClickListener(listener: (Playable) -> Unit) {
        onItemClickListener = listener
    }
}