package com.swapi.planets.ui.main.fragment.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.swapi.planets.R
import com.swapi.planets.databinding.FragmentCatalogBinding
import com.swapi.planets.ui.adapter.MainAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class CatalogFragment : Fragment() {
    private var _binding: FragmentCatalogBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CatalogViewModel by viewModels()
    private lateinit var mainAdapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatalogBinding.inflate(inflater, container, false)
        ViewCompat.setOnApplyWindowInsetsListener(binding.catalogMainCl) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initComponents()
        initVm()
    }

    private fun initComponents() {
        binding.catalogToolbar.tvTitle.isVisible = true
        binding.catalogToolbar.tvTitle.text = getString(R.string.app_name)

        mainAdapter = MainAdapter(
            listPlanets = emptyList(),
            listenerPlanet = { toDetailPlanet(it) }
        )
        binding.catalogRv.apply {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun initVm() {
        viewModel.getListPlanet()
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect {
                    when (it) {
                        CatalogViewModel.UiSateCatalog.Loading -> binding.catalogPb.isVisible = true
                        is CatalogViewModel.UiSateCatalog.Success -> {
                            binding.catalogPb.isVisible = false
                            mainAdapter.updateList(it.listPlanet)
                        }
                    }
                }
            }
        }
    }

    private fun toDetailPlanet(url: String) {
        findNavController().navigate(
            CatalogFragmentDirections.actionCatalogFragmentToDetailFragment(url)
        )
    }
}