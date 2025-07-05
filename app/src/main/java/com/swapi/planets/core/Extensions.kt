package com.swapi.planets.core

import android.app.Activity
import android.graphics.Typeface
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import com.google.android.material.snackbar.Snackbar

fun Activity.xSnackBar(idView: Int, text: String, length: Int = Snackbar.LENGTH_LONG) {
    Snackbar.make(findViewById(idView), text, length).show()
}

fun String.xInBold(): SpannableString {
    return SpannableString(this).apply {
        setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            this.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }
}
