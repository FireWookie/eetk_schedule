@file:Suppress("unused")

import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import ru.eetk.mobileapp.extension.kotlinOptions
import ru.eetk.mobileapp.internal.configureKotlinAndroidToolchain
import ru.eetk.mobileapp.internal.kotlinPluginId
import ru.eetk.mobileapp.internal.libraryExtension
import ru.eetk.mobileapp.internal.libraryPluginId
import ru.eetk.mobileapp.internal.libs

class AndroidLibraryPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        apply(plugin = libraryPluginId)
        apply(plugin = kotlinPluginId)

        libraryExtension {
            defaultConfig {
                minSdk = libs.versions.minSdk.get().toInt()
                compileSdk = libs.versions.compileSdk.get().toInt()

                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

                consumerProguardFiles("consumer-rules.pro")
            }

            buildTypes {
                release {
                    isMinifyEnabled = true
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }

            kotlinOptions {
                freeCompilerArgs += "-Xcontext-receivers"
                languageVersion = KotlinVersion.KOTLIN_1_9.version
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_21
                targetCompatibility = JavaVersion.VERSION_21
            }
        }

        configureKotlinAndroidToolchain()
    }
}