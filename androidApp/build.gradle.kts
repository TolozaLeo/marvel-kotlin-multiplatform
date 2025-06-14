import java.util.Properties
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.compose.compiler)
}

val localProperties = Properties()
val localPropertiesFile = rootProject.file("local.properties")
if (localPropertiesFile.exists()) {
    localProperties.load(localPropertiesFile.inputStream())
}

val marvelPublicKey = localProperties.getProperty("MARVEL_PUBLIC_KEY", "")
val marvelPrivateKey = localProperties.getProperty("MARVEL_PRIVATE_KEY", "")

android {
    namespace = "dev.leotoloza.marvelkmmapp.android"
    compileSdk = 35
    defaultConfig {
        applicationId = "dev.leotoloza.marvelkmmapp.android"
        minSdk = 29
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        buildConfigField("String", "MARVEL_PUBLIC_KEY", "\"$marvelPublicKey\"")
        buildConfigField("String", "MARVEL_PRIVATE_KEY", "\"$marvelPrivateKey\"")
    }
    buildFeatures {
        buildConfig = true
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
    implementation(libs.koin.android)
}