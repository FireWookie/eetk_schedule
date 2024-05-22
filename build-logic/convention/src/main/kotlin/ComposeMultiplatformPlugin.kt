@file:Suppress("unused")

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.apply
import org.jetbrains.compose.compose
import ru.eetk.mobileapp.extension.commonDependencies
import ru.eetk.mobileapp.internal.applicationExtension
import ru.eetk.mobileapp.internal.applicationPluginId
import ru.eetk.mobileapp.internal.composeMainPluginId
import ru.eetk.mobileapp.internal.composePluginId
import ru.eetk.mobileapp.internal.implementation
import ru.eetk.mobileapp.internal.kmmExtension
import ru.eetk.mobileapp.internal.libraryExtension
import ru.eetk.mobileapp.internal.libraryPluginId
import ru.eetk.mobileapp.internal.libs

class ComposeMultiplatformPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        apply(plugin = composePluginId)
        apply(plugin = composeMainPluginId)

        pluginManager.withPlugin(composePluginId) {
            apply(plugin = composeMainPluginId)
            kmmExtension {
                commonDependencies {
                    implementation(libs.compose.runtime)
                    implementation(libs.compose.foundation)
                    implementation(libs.compose.material3)
                    implementation(libs.compose.ui)
                }
            }
        }

        pluginManager.withPlugin(applicationPluginId) {
            applicationExtension {
                buildFeatures {
                    compose = true
                }

                composeOptions {
                    kotlinCompilerExtensionVersion = "1.5.14"
                }
                dependencies {
                    implementation(platform(libs.androidx.compose.bom))
                }
            }
        }
        pluginManager.withPlugin(libraryPluginId) {
            libraryExtension {
                buildFeatures {
                    compose = true
                }

                composeOptions {
                    kotlinCompilerExtensionVersion = "1.5.14"
                }
                dependencies {
                    implementation(platform(libs.androidx.compose.bom))
                }
            }
        }
    }
}