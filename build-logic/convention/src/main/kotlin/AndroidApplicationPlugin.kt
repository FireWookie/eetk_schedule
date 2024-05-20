@file:Suppress("unused")

import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import ru.eetk.mobileapp.extension.kotlinOptions
import ru.eetk.mobileapp.internal.applicationExtension
import ru.eetk.mobileapp.internal.applicationPluginId
import ru.eetk.mobileapp.internal.configureKotlinAndroidToolchain
import ru.eetk.mobileapp.internal.kotlinPluginId

class AndroidApplicationPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        apply(plugin = applicationPluginId)
        apply(plugin = kotlinPluginId)

        applicationExtension {
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_21
                targetCompatibility = JavaVersion.VERSION_21
            }

            kotlinOptions {
                freeCompilerArgs = listOf("-Xcontext-receivers")
                languageVersion = KotlinVersion.KOTLIN_1_9.version
            }

            buildTypes {
                release {
                    isMinifyEnabled = true
                    isShrinkResources = true
                    proguardFiles(
                        "proguard-rules.pro",
                        getDefaultProguardFile("proguard-android-optimize.txt")
                    )
                }
            }
        }
        configureKotlinAndroidToolchain()
    }
}