// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version PluginVersion.agpVersion apply false
    id("org.jetbrains.kotlin.android") version PluginVersion.kotlinVersion apply false
    id("com.android.library") version PluginVersion.agpVersion apply false
    kotlin("kapt") version PluginVersion.kotlinVersion apply false
    id("com.google.dagger.hilt.android") version PluginVersion.hiltVersion apply false
    id("org.jlleitschuh.gradle.ktlint") version PluginVersion.ktlintVersion apply false
    id("com.google.gms.google-services") version "4.4.0" apply false
    id("com.google.firebase.crashlytics") version "2.9.9" apply false
}