plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.viewmodeldivideexample"
    compileSdk = AppSetup.compileSdk

    defaultConfig {
        applicationId = "com.example.viewmodeldivideexample"
        minSdk = AppSetup.minSdk
        targetSdk = AppSetup.targetSdk
        versionCode = AppSetup.versionCode
        versionName = AppSetup.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.6"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Dependencies.glide)
    implementation(Dependencies.lottie)

    implementation(Dependencies.Android.coreKtx)
    implementation(Dependencies.Android.lifecycle)

    implementation(Dependencies.Compose.activity)
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.uiGraphics)
    implementation(Dependencies.Compose.uiPreview)
    implementation(Dependencies.Compose.material3)
    implementation(Dependencies.Compose.googleFonts)
    debugImplementation(Dependencies.Compose.debugUi)
    debugImplementation(Dependencies.Compose.debugManifest)

    testImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.Test.junitExt)
    androidTestImplementation(Dependencies.Test.espresso)
    androidTestImplementation(Dependencies.Compose.testJunit)

    implementation(Dependencies.Hilt.android)
    kapt(Dependencies.Hilt.androidCompiler)
    kapt(Dependencies.Hilt.compiler)
    implementation(Dependencies.Hilt.composeNavigation)

    implementation(Dependencies.GSON.gson)

    implementation(Dependencies.OrbitMVI.compose)
    implementation(Dependencies.OrbitMVI.viewModel)

    implementation(Dependencies.SocketIO.socketIo) {
        exclude(group = "org.json", module = "json")
    }

    implementation(Dependencies.OkHttp.okHttp)
    implementation(Dependencies.OkHttp.okHttpUrlConnection)
    implementation(Dependencies.OkHttp.okHttpLoggingInterceptor)

    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.retrofitGsonConverter)
    implementation(Dependencies.Retrofit.retrofitSqlbrite)
}