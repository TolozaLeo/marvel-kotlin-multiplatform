import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.util.Properties

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.sqldelightPlugin)
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.serialization.kotlinx.json)
                implementation(libs.kotlinx.serialization.json)
                implementation(project.dependencies.platform(libs.koin.bom))
                implementation(libs.koin.core)
                implementation(libs.sqldelight.coroutines)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.ktor.client.okhttp)
                implementation(libs.sqldelight.android)
            }
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting

        val iosMain by creating {
            dependsOn(commonMain)
            dependencies{
                implementation(libs.ktor.client.darwin)
                implementation(libs.sqldelight.native)
            }
        }

        iosX64Main.dependsOn(iosMain)
        iosArm64Main.dependsOn(iosMain)
        iosSimulatorArm64Main.dependsOn(iosMain)
    }
}

android {
    namespace = "dev.leotoloza.marvelkmmapp"
    compileSdk = 35
    defaultConfig {
        minSdk = 29
        val props = Properties()
        props.load(project.rootProject.file("local.properties").inputStream())
        val marvelPublicKey = props.getProperty("MARVEL_PUBLIC_KEY") ?: ""
        val marvelPrivateKey = props.getProperty("MARVEL_PRIVATE_KEY") ?: ""
        // Inyectar como campos de BuildConfig
        buildConfigField("String", "MARVEL_PUBLIC_KEY", "\"$marvelPublicKey\"")
        buildConfigField("String", "MARVEL_PRIVATE_KEY", "\"$marvelPrivateKey\"")
    }

    buildFeatures { buildConfig = true }  // asegurar generación de BuildConfig

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

sqldelight {
    databases {
        create("MarvelDatabase") {// Nombre de la base de datos
            packageName.set("dev.leotoloza.marvelkmmapp.cache") // Paquete donde se creará la base de datos
        }
    }
}