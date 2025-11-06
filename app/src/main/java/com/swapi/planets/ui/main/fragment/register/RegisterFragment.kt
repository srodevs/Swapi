package com.swapi.planets.ui.main.fragment.register

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.swapi.planets.R
import com.swapi.planets.core.Common
import com.swapi.planets.core.DatePickerFragment
import com.swapi.planets.core.xSnackBar
import com.swapi.planets.databinding.FragmentRegisterBinding
import com.swapi.planets.ui.model.UserModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@AndroidEntryPoint
class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RegisterViewModel by viewModels()

    companion object {
        private const val TAG = "RegisterFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        ViewCompat.setOnApplyWindowInsetsListener(binding.registerMainCL) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        binding.registerBtnRegister.setOnClickListener { validateData() }
        binding.registerTietBorn.setOnClickListener { selectDate() }
    }

    private fun selectDate() {
        Common.closeKeyboardFragment(this)
        val dateStartPicker =
            DatePickerFragment { day, month, year ->
                val calendar = Calendar.getInstance()
                calendar[Calendar.DAY_OF_MONTH] = day
                calendar[Calendar.MONTH] = month
                calendar[Calendar.YEAR] = year


                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val txtStartDate = dateFormat.format(calendar.time)

                binding.registerTilBorn.editText?.setText(txtStartDate)
            }
        dateStartPicker.show(requireActivity().supportFragmentManager, "date")
    }

    private fun validateData() {
        //todo se debe condicionar que el born sea valida
        Common.closeKeyboardFragment(this)
        val txtName = binding.registerTilName.editText?.text.toString()
        val txtLastnameFather = binding.registerTilLastnameFather.editText?.text.toString()
        val txtLastnameMother = binding.registerTilLastnameMother.editText?.text.toString()
        val txtBorn = binding.registerTilBorn.editText?.text.toString()
        val txtCountry = binding.registerCodeCountry.selectedCountryName.toString()
        if (txtName.isNotEmpty()
            && txtLastnameFather.isNotEmpty()
            && txtLastnameMother.isNotEmpty()
            && txtBorn.isNotEmpty()
            && txtCountry.isNotEmpty()
        ) {
            val userModel = UserModel(
                name = txtName,
                lastnameFather = txtLastnameFather,
                lastnameMother = txtLastnameMother,
                born = txtBorn,
                country = txtCountry
            )
            Log.d(TAG, "la info es:$userModel")
            viewModel.insertUser(userModel) {
                requireActivity().runOnUiThread {
                    if (it) {
                        val navOptions = NavOptions.Builder()
                            .setPopUpTo(R.id.registerFragment, true)
                            .build()
                        findNavController().navigate(
                            RegisterFragmentDirections.actionRegisterFragmentToCatalogFragment(),
                            navOptions
                        )
                    }
                }
            }
        } else {
            requireActivity().xSnackBar(
                R.id.registerMainCL,
                getString(R.string.register_msg_fill_all)
            )
        }
    }
}