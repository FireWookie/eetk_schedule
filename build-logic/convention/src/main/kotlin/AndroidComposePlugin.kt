@file:Suppress("unused")

import ru.eetk.mobileapp.internal.applicationExtension
import ru.eetk.mobileapp.internal.applicationPluginId
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import ru.eetk.mobileapp.internal.implementation
import ru.eetk.mobileapp.internal.libraryExtension
import ru.eetk.mobileapp.internal.libraryPluginId
import ru.eetk.mobileapp.internal.libs

class AndroidComposePlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {

        pluginManager.withPlugin(applicationPluginId) {
            applicationExtension {
                buildFeatures {
                    compose = true
                }

                composeOptions {
                    kotlinCompilerExtensionVersion = libs.compose.runtime.get().version
                }
                dependencies {
//                    implementation(platform(libs.androidx.compose.bom))
                }
            }
        }
        pluginManager.withPlugin(libraryPluginId) {
            libraryExtension {
                buildFeatures {
                    compose = true
                }

                composeOptions {
                    kotlinCompilerExtensionVersion = libs.compose.runtime.get().version
                }
                dependencies {

                }
            }
        }
//        pluginManager.withPlugin(applicationPluginId) {
//            applicationExtension {
//                buildFeatures {
//                    compose = true
//                }
//
//                composeOptions {
//                    kotlinCompilerExtensionVersion = libs.compose.gradle.plugin.get().version
//                }
//                dependencies {
//                    implementation(platform(libs.androidx.compose.bom))
//                }
//            }
//        }
//        pluginManager.withPlugin(libraryPluginId) {
//            libraryExtension {
//                buildFeatures {
//                    compose = true
//                }
//
//                composeOptions {
//                    kotlinCompilerExtensionVersion = libs.compose.gradle.plugin.get().version
//                }
//                dependencies {
//                    implementation(platform(libs.androidx.compose.bom))
//                }
//            }
//        }
    }
}