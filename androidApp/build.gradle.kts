plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "dev.leotoloza.marvelkmmapp.android"
    compileSdk = 35
    defaultConfig {
        applicationId = "dev.leotoloza.marvelkmmapp.android"
        minSdk = 29
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
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
    implementation(projects.shared)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.material3.android)
    implementation(libs.androidx.room.compiler)
    debugImplementation(libs.compose.ui.tooling)
    implementation(libs.coil.compose)

    implementation(libs.koin.compose)
//    implementation(libs.koin.compose.viewmodel)
//    implementation(libs.koin.compose.viewmodel.navigation)
    implementation (libs.koin.androidx.compose)

    configurations.all {
        exclude(group = "com.intellij", module = "annotations")
    }
}