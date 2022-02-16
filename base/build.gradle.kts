plugins {
    id(Plugins.androidLibrary)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.kotlinKapt)
    id(Plugins.daggerHilt)
}

android {
    compileSdkVersion (Versions.androidCompileSdkVersion)
    buildToolsVersion (Versions.buildToolsVersion)

    defaultConfig {
        minSdkVersion (Versions.androidMinSdkVersion)
        targetSdkVersion (Versions.androidTargetSdkVersion)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
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
    implementation(Dependencies.Libraries.gson)
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

    //implementation(project(mapOf("path" to ":app")))

}