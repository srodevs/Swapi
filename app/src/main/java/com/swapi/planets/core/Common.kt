package com.swapi.planets.core

import android.content.Context.INPUT_METHOD_SERVICE
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

object Common {

    fun closeKeyboardFragment(fragment: Fragment) {
        val view = fragment.view?.findFocus() ?: View(fragment.requireContext())
        val inputMethodManager =
            fragment.requireContext().getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}