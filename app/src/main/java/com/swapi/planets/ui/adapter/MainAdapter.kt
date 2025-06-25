package com.swapi.planets.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.swapi.planets.R
import com.swapi.planets.data.network.model.PlanetResponse
import com.swapi.planets.databinding.ItemPlanetBinding

class MainAdapter(
    private var listPlanets: List<PlanetResponse>,
    private val listenerPlanet: (String, String) -> Unit
) : RecyclerView.Adapter<MainAdapter.WallViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WallViewHolder {
        return WallViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_planet, parent, false)
        )
    }

    override fun getItemCount() = listPlanets.size

    override fun onBindViewHolder(holder: WallViewHolder, position: Int) {
        holder.bindWalls(listPlanets[position], listenerPlanet)
    }

    inner class WallViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemPlanetBinding.bind(itemView)

        fun bindWalls(
            planetResponse: PlanetResponse,
            listPlanets: (String, String) -> Unit
        ) {
            val selectedImg = getRandomImg()
            binding.itemPlanetTvTitle.text = planetResponse.name
            Glide.with(binding.root.context).load(selectedImg)
                .centerCrop()
                .apply(RequestOptions.circleCropTransform())
                .into(binding.itemPlanetIv)
            binding.itemPlanetCvContainer.setOnClickListener {
                listPlanets(planetResponse.url.orEmpty(), selectedImg)
            }
        }
    }

    private fun getRandomImg(): String {
        val listPlanets = listOf(
            "https://images.unsplash.com/photo-1701014159251-f86a81a6fe13?q=80&w=963&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1701014159141-639d07c4eba4?q=80&w=963&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1614732414444-096e5f1122d5?q=80&w=1674&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1639653279211-09958a51fb00?q=80&w=1480&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1639477878754-4119b60fb02a?q=80&w=1480&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1639477734993-44982980229e?q=80&w=1480&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1639393455114-84df73f758cd?q=80&w=1480&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1639548206689-1a5238f8d5bb?q=80&w=1480&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1545156521-77bd85671d30?q=80&w=1480&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1481819613568-3701cbc70156?q=80&w=1480&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        )
        return listPlanets.random()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(listPlanet: List<PlanetResponse>) {
        this.listPlanets = listPlanet
        notifyDataSetChanged()
    }
}