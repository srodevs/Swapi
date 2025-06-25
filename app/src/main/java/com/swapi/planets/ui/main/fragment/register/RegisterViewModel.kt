package com.swapi.planets.ui.main.fragment.register

import android.util.Printer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swapi.planets.core.SharedPrefs
import com.swapi.planets.domain.CreateNewUserUseCase
import com.swapi.planets.ui.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val createNewUserUseCase: CreateNewUserUseCase,
    private val sharedPrefs: SharedPrefs
) : ViewModel() {

    fun insertUser(userModel: UserModel, result: (Boolean) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            createNewUserUseCase.invoke(userModel)
            sharedPrefs.setValueLogin(true)
            result(true)
        }
    }
}