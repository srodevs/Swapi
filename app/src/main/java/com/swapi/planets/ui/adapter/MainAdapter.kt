package com.swapi.planets.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.swapi.planets.R
import com.swapi.planets.core.Constants
import com.swapi.planets.data.network.response.PlanetResponse
import com.swapi.planets.databinding.ItemPlanetBinding

class MainAdapter(
    private var listPlanets: List<PlanetResponse>,
    private val listenerPlanet: (String, String) -> Unit
) : RecyclerView.Adapter<MainAdapter.PlanetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        return PlanetViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_planet, parent, false)
        )
    }

    override fun getItemCount() = listPlanets.size

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        holder.bindPlanet(listPlanets[position], listenerPlanet)
    }

    inner class PlanetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemPlanetBinding.bind(itemView)

        fun bindPlanet(
            planetResponse: PlanetResponse,
            listPlanets: (String, String) -> Unit
        ) {
            val selectedImg = Constants.getListImg().random()
            binding.itemPlanetTvTitle.text = planetResponse.name
            Glide.with(binding.root.context).load(selectedImg)
                .centerCrop()
                .into(binding.itemPlanetIv)
            binding.itemPlanetCvContainer.setOnClickListener {
                listPlanets(planetResponse.url.orEmpty(), selectedImg)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(listPlanet: List<PlanetResponse>) {
        this.listPlanets = listPlanet
        notifyDataSetChanged()
    }
}