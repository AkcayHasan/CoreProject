object Dependencies {
    /**
     * Core Libraries
     */
    object CoreLibraries {
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
        const val ktx = "androidx.core:core-ktx:${Versions.ktxVersion}"
    }

    /**
     * Support Libraries
     */
    object SupportLibraries {
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
        const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerViewVersion}"
        const val materialDesign = "com.google.android.material:material:${Versions.materialVersion}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
        const val swipeRefresh = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayoutVersion}"
        const val lifecycleExt = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtVersion}"
        const val fragmentExt = "androidx.fragment:fragment-ktx:${Versions.fragmentExtVersion}"
    }

    /**
     * Common Libraries
     */
    object Libraries {
        const val hilt = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
        const val hiltKapt = "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}"
        const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewModelsVersion}"
        const val hiltViewModelKapt = "androidx.hilt:hilt-compiler:${Versions.hiltViewModelsVersion}"
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
        const val dataStore = "androidx.datastore:datastore-preferences:${Versions.dataStoreVersion}"
        const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
        const val roomCoroutines = "androidx.room:room-ktx:${Versions.roomVersion}"
        const val picasso = "com.squareup.picasso:picasso:${Versions.picassoVersion}"
        const val lottie = "com.airbnb.android:lottie:${Versions.lottie_version}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
        const val retrofitLogger = "com.squareup.okhttp3:logging-interceptor:${Versions.retrofitLoggerVersion}"
        const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}"
        const val moshiRetrofit = "com.squareup.retrofit2:converter-moshi:${Versions.moshiRetrofitVersion}"
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutineVersion}"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutineVersion}"
        const val coroutinesLifecycleVM = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.coroutineLifecycleVersion}"
        const val coroutinesLifecycleRT = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.coroutineLifecycleVersion}"
        const val timber = "com.jakewharton.timber:timber:${Versions.timberVersion}"
    }

    /**
     * Test Libraries
     */
    object TestLibraries {
        const val jUnit = "junit:junit:${Versions.junitVersion}"
        //const val runner = "androidx.test:runner:${Versions.testRunnerVersion}"
        //const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
    }
}