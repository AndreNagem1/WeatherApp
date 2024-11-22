plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    id(libs.plugins.kapt.get().pluginId)
    id(libs.plugins.hilt.get().pluginId) version "2.49" apply true
}
kapt {
    correctErrorTypes = true
}
hilt {
    enableAggregatingTask = false
}
android {
    namespace = "praonde.com.wheatherapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "praonde.com.wheatherapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.extension.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
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

    // -- Navigation -- //
    implementation(libs.navigation.compose)
    implementation(libs.kotlinx.serialization.json)

    // -- Hilt -- //
    implementation(libs.dagger.hilt.android)
    implementation(libs.androidX.hilt)
    kapt(libs.dagger.hilt.compiler)

    // -- Retrofit -- //
    implementation(libs.retrofit.lib)
    implementation(libs.retrofit.gson)
    implementation(libs.retrofit.interceptor)

    implementation(project(":uikit"))
}