plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    kotlin("plugin.serialization") version "2.0.21"
}

android {

    buildFeatures {
        viewBinding = true
    }

    namespace = "com.example.week2"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.week2"
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
}

dependencies {
    val fragment_version = "1.8.6"

    implementation("androidx.navigation:navigation-compose:2.8.9")

    implementation("androidx.navigation:navigation-ui:2.8.9")
    implementation("androidx.navigation:navigation-fragment:2.8.9")

    implementation("androidx.navigation:navigation-dynamic-features-fragment:2.8.9")

    implementation("androidx.navigation:navigation-testing:2.8.9")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")

    implementation("androidx.fragment:fragment:$fragment_version")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}