package com.swapi.planets.ui.main.fragment.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.swapi.planets.R
import com.swapi.planets.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initComponents()
    }

    private fun initComponents() {
        viewModel.validateLogin { isLogin ->
            requireActivity().runOnUiThread {
                if (isLogin) {
                    val navOptions = NavOptions.Builder()
                        .setPopUpTo(R.id.splashFragment, true)
                        .build()
                    findNavController().navigate(
                        SplashFragmentDirections.actionSplashFragmentToCatalogFragment(),
                        navOptions
                    )
                } else {
                    val navOptions = NavOptions.Builder()
                        .setPopUpTo(R.id.splashFragment, true)
                        .build()
                    findNavController().navigate(
                        SplashFragmentDirections.actionSplashFragmentToRegisterFragment(),
                        navOptions
                    )
                }
            }

        }
    }
}