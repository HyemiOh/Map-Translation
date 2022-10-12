plugins {
    id(Plugins.ANDROID_LIBRARY)
    id(Plugins.JETBRAINS_ANDROID)
    kotlin(Plugins.KAPT)
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }

    buildTypes {
        release {
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
}

dependencies {

    implementation(Libraries.AndroidX.CORE)
    implementation(Libraries.AndroidX.APP_COMPAT)
    implementation(Libraries.AndroidX.MATERIAL)
    testImplementation(Libraries.Test.JUNIT)
    androidTestImplementation(Libraries.AndroidX.JUNIT)
    androidTestImplementation(Libraries.AndroidX.ESPRESSO_CORE)

    // ExcelReader
    implementation(Libraries.ExcelReader.JEXCEL)

    // Coroutine
    implementation(Libraries.Coroutine.COROUTINE_ANDROID)

    // Room
    implementation(Libraries.Room.ROOM_RUNTIME)
    kapt(Libraries.Room.ROOM_COMPILER)
    implementation(Libraries.Room.ROOM_KTX)

    // Network
    implementation(Libraries.Retrofit.RETROFIT)
    implementation(Libraries.Retrofit.CONVERTER_GSON)
    implementation(Libraries.Retrofit.OKHTTP)
    implementation(Libraries.Retrofit.OKHTTP_LOGGING)

    // Hilt
    implementation(Libraries.Hilt.HILT_ANDROID)
    implementation(Libraries.Hilt.HILT_VIEWMODEL)
    kapt(Libraries.Hilt.HILT_COMPILER)

    debugImplementation(Libraries.Canary.LEAK_CANARY)

    implementation(project(":domainLayer"))
}