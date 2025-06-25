package com.swapi.planets.core

import android.app.Activity
import com.google.android.material.snackbar.Snackbar

fun Activity.xSnackBar(idView: Int, text: String, length: Int = Snackbar.LENGTH_LONG) {
    Snackbar.make(findViewById(idView), text, length).show()
}