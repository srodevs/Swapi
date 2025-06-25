package com.swapi.planets.ui.main.fragment.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.swapi.planets.data.network.model.PlanetResponse
import com.swapi.planets.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()
    private lateinit var argUrl: String
    private lateinit var argImg: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        argUrl = args.planetUrl
        argImg = args.urlImg
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initComponents()
        initListeners()
        initVm()
    }

    private fun initComponents() {
        binding.detailPb.isVisible = true
        Glide.with(binding.root.context).load(argImg)
            .centerCrop()
            .apply(RequestOptions.circleCropTransform())
            .into(binding.detailIvPlanet)
    }

    private fun initListeners() {
        binding.detailIvBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initVm() {
        val planetId = extractIdFromUrl(argUrl).orEmpty()
        viewModel.getInfoPlanet(planetId) {
            requireActivity().runOnUiThread {
                showInfo(it)
            }
        }
    }

    private fun showInfo(planetResponse: PlanetResponse) {
        binding.detailPb.isVisible = false
        binding.detailTvTitle.text = planetResponse.name
    }

    private fun extractIdFromUrl(url: String): String? {
        return url.trimEnd('/').split("/").lastOrNull()
    }
}