@file:Suppress("unused")


import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import ru.eetk.mobileapp.extension.commonDependencies
import ru.eetk.mobileapp.internal.kmmExtension
import ru.eetk.mobileapp.internal.kotlinMultiplatformPluginId
import ru.eetk.mobileapp.internal.libraryExtension
import ru.eetk.mobileapp.internal.libraryPluginId
import ru.eetk.mobileapp.internal.libs

class AndroidKmpLibraryPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        apply(plugin = libraryPluginId)
        apply(plugin = kotlinMultiplatformPluginId)

        kmmExtension {
            targets.all {
                compilations.all {
                    kotlinOptions {
//                        jvmToolchain(17)
                        freeCompilerArgs += "-Xcontext-receivers"
                        freeCompilerArgs += "-Xexpect-actual-classes"
                        languageVersion = KotlinVersion.KOTLIN_1_9.version
                    }
                }
            }
        }

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

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_21
                targetCompatibility = JavaVersion.VERSION_21
            }
        }
    }
}