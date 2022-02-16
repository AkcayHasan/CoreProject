object Dependencies {
    /**
     * Core Libraries
     */
    object CoreLibraries {
        val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}" }
        val ktx by lazy { "androidx.core:core-ktx:${Versions.ktxVersion}" }
    }

    /**
     * Support Libraries
     */
    object SupportLibraries {
        val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompatVersion}" }
        val recyclerView by lazy { "androidx.recyclerview:recyclerview:${Versions.recyclerViewVersion}" }
        val materialDesign by lazy { "com.google.android.material:material:${Versions.materialVersion}" }
        val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}" }
        val swipeRefresh by lazy { "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayoutVersion}" }
        val lifecycleExt by lazy { "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtVersion}" }
        val fragmentExt by lazy { "androidx.fragment:fragment-ktx:${Versions.fragmentExtVersion}" }
    }

    /**
     * Common Libraries
     */
    object Libraries {
        val hilt by lazy { "com.google.dagger:hilt-android:${Versions.hiltVersion}" }
        val hiltKapt by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}" }
        val hiltViewModel by lazy { "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewModelsVersion}" }
        val hiltViewModelKapt by lazy { "androidx.hilt:hilt-compiler:${Versions.hiltViewModelsVersion}" }
        val navigationFragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}" }
        val navigationUi by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}" }
        val dataStore by lazy { "androidx.datastore:datastore-preferences:${Versions.dataStoreVersion}" }
        val roomRuntime by lazy { "androidx.room:room-runtime:${Versions.roomVersion}" }
        val roomCompiler by lazy { "androidx.room:room-compiler:${Versions.roomVersion}" }
        val roomCoroutines by lazy { "androidx.room:room-ktx:${Versions.roomVersion}" }
        val picasso by lazy { "com.squareup.picasso:picasso:${Versions.picassoVersion}" }
        val lottie by lazy { "com.airbnb.android:lottie:${Versions.lottie_version}" }
        val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}" }
        val retrofitLogger by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.retrofitLoggerVersion}" }
        val moshi by lazy { "com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}" }
        val gson by lazy { "com.google.code.gson:gson:${Versions.gsonVersion}" }
        val moshiRetrofit by lazy { "com.squareup.retrofit2:converter-moshi:${Versions.moshiRetrofitVersion}" }
        val coroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutineVersion}" }
        val coroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutineVersion}" }
        val coroutinesLifecycleVM by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.coroutineLifecycleVersion}" }
        val coroutinesLifecycleRT by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.coroutineLifecycleVersion}" }
        val timber by lazy { "com.jakewharton.timber:timber:${Versions.timberVersion}" }
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