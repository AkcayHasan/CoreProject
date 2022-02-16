plugins {
    id(Plugins.androidApplication)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.kotlinKapt)
    id(Plugins.daggerHilt)
    id(Plugins.navigation)
}

android {
    compileSdkVersion(Versions.androidCompileSdkVersion)
    buildToolsVersion(Versions.buildToolsVersion)

    defaultConfig {
        applicationId = "com.hasankcay.coreproject"
        minSdkVersion(Versions.androidMinSdkVersion)
        targetSdkVersion(Versions.androidTargetSdkVersion)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(Dependencies.CoreLibraries.ktx)
    implementation(Dependencies.CoreLibraries.kotlin)
    implementation(Dependencies.SupportLibraries.appCompat)
    implementation(Dependencies.SupportLibraries.materialDesign)
    implementation(Dependencies.SupportLibraries.constraintLayout)
    implementation(Dependencies.Libraries.navigationFragment)
    implementation(Dependencies.Libraries.navigationUi)
    implementation(Dependencies.Libraries.lottie)
    implementation(Dependencies.SupportLibraries.swipeRefresh)
    implementation(Dependencies.Libraries.retrofit)
    implementation(Dependencies.Libraries.retrofitLogger)
    implementation(Dependencies.Libraries.moshiRetrofit)
    implementation(Dependencies.Libraries.moshi)
    implementation(Dependencies.Libraries.coroutinesAndroid)
    implementation(Dependencies.Libraries.coroutinesCore)
    implementation(Dependencies.Libraries.coroutinesLifecycleRT)
    implementation(Dependencies.Libraries.coroutinesLifecycleVM)
    implementation(Dependencies.Libraries.picasso)
    implementation(Dependencies.Libraries.dataStore)
    implementation(Dependencies.Libraries.timber)
    implementation(Dependencies.Libraries.roomCoroutines)
    implementation(Dependencies.Libraries.roomRuntime)
    implementation(Dependencies.Libraries.hilt)
    implementation(Dependencies.Libraries.hiltViewModel)
    kapt(Dependencies.Libraries.hiltKapt)
    kapt(Dependencies.Libraries.hiltViewModelKapt)
    kapt(Dependencies.Libraries.roomCompiler)

    implementation(project(mapOf("path" to ":base")))

    //implementation "androidx.legacy:legacy-support-v4:1.0.0"

    //testImplementation "junit:junit:4.13.2"
    //androidTestImplementation "androidx.test.ext:junit:1.1.3"
    //androidTestImplementation "androidx.test.espresso:espresso-core:3.4.0"
}