// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.ksp) apply false
    alias(libs.plugins.hilt.android) apply false
    alias(libs.plugins.safeargs.navigation) apply false
}