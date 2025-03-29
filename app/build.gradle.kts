plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.hilt)
    kotlin("kapt")
}

android {
    namespace = "com.dev.carl.simplelistapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.dev.carl.simplelistapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Navigation Dependencies
    implementation(libs.kotlinx.serialization)
    implementation(libs.androidx.nav.compose)
    implementation(libs.androidx.nav.fragment)
    implementation(libs.androidx.nav.ui)
    implementation(libs.androidx.nav.dynamic.features.fragment)

    // Dagger Hilt Dependencies
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    // Retrofit Dependencies
    implementation(libs.retrofit)
    implementation(libs.retrofit.moshi)

    // OkHttp Dependencies
    implementation(libs.okHttp)
    implementation(libs.okHttp.logging)

}

kapt {
    correctErrorTypes = true
}