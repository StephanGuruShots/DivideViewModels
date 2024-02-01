object Dependencies {

    object Android {
        private const val lifecycleVersion = "2.6.2"

        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion"
        const val lifecycleProcess = "androidx.lifecycle:lifecycle-process:$lifecycleVersion"

        const val coreKtx = "androidx.core:core-ktx:1.12.0"
        const val appcompat = "androidx.appcompat:appcompat:1.6.1"
    }

    object Compose {
        private const val version = "1.5.4"

        const val activity = "androidx.activity:activity-compose:1.8.2"
        const val ui = "androidx.compose.ui:ui:$version"
        const val uiGraphics = "androidx.compose.ui:ui-graphics:$version"
        const val uiPreview = "androidx.compose.ui:ui-tooling-preview:$version"
        const val material3 = "androidx.compose.material3:material3:1.1.2"
        const val navigation = "androidx.navigation:navigation-compose:2.7.6"
        const val googleFonts = "androidx.compose.ui:ui-text-google-fonts:$version"

        const val debugUi = "androidx.compose.ui:ui-tooling:$version"
        const val debugManifest = "androidx.compose.ui:ui-test-manifest:$version"

        const val testJunit = "androidx.compose.ui:ui-test-junit4:$version"
    }

    object Test {
        const val junit = "junit:junit:4.13.2"
        const val junitExt = "androidx.test.ext:junit:1.1.5"
        const val espresso = "androidx.test.espresso:espresso-core:3.5.1"
    }

    object Hilt {
        private const val version = "2.48.1"

        const val android = "com.google.dagger:hilt-android:$version"
        const val androidCompiler = "com.google.dagger:hilt-android-compiler:$version"
        const val test = "com.google.dagger:hilt-android-testing:$version"
        const val compiler = "androidx.hilt:hilt-compiler:1.1.0"
        const val composeNavigation = "androidx.hilt:hilt-navigation-compose:1.1.0"
    }

    object SocketIO {
        const val socketIo = "io.socket:socket.io-client:2.1.0"
    }

    object GSON {
        const val gson = "com.google.code.gson:gson:2.10.1"
    }

    object OrbitMVI {
        private const val version = "6.1.0"

        const val viewModel = "org.orbit-mvi:orbit-viewmodel:$version"
        const val compose = "org.orbit-mvi:orbit-compose:$version"
        const val test = "org.orbit-mvi:orbit-test:$version"
    }

    object Retrofit {
        private const val version = "2.9.0"

        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:$version"
        const val retrofitSqlbrite = "com.squareup.sqlbrite:sqlbrite:1.1.2"
    }

    object OkHttp {
        private const val version = "4.10.0"

        const val okHttp = "com.squareup.okhttp3:okhttp:$version"
        const val okHttpUrlConnection = "com.squareup.okhttp3:okhttp-urlconnection:$version"
        const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
        const val okHttpProfiler = "com.localebro:okhttpprofiler:1.0.8"
    }

    object Room {
        private const val version = "2.6.0"

        const val kaptRoomCompiler = "androidx.room:room-compiler:$version"
        const val annotationRoomCompiler = "androidx.room:room-compiler:$version"
        const val roomRuntime = "androidx.room:room-runtime:$version"
        const val roomKtx = "androidx.room:room-ktx:$version"
    }

    object Firebase {
        const val bom = "com.google.firebase:firebase-bom:32.7.1"
        const val crashlytics = "com.google.firebase:firebase-crashlytics"
        const val analytics = "com.google.firebase:firebase-analytics"
    }

    const val glide = "com.github.skydoves:landscapist-glide:2.2.10"
    const val lottie = "com.airbnb.android:lottie-compose:6.2.0"
}