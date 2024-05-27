import com.android.build.api.dsl.ManagedVirtualDevice
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSetTree
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.multiplatform)

    alias(libs.plugins.compose.main)
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlinx.serialization)

    alias(libs.plugins.moko.resources)
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                    freeCompilerArgs.add("-Xjdk-release=${JavaVersion.VERSION_1_8}")
                }
            }
        }
        //https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-test.html
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        instrumentedTestVariant {
            sourceSetTree.set(KotlinSourceSetTree.test)
            dependencies {
                debugImplementation(libs.androidx.testManifest)
                implementation(libs.androidx.junit4)
            }
        }
    }

    composeCompiler {
        enableStrongSkippingMode = true
    }
    val xcFramework = XCFramework("ComposeApp")
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
            xcFramework.add(this)

            export(projects.shared.compose.theme)
            export(projects.shared.feature.root)
            export(projects.shared.coreDi)
            export(projects.shared.compose.resources)
            export(projects.shared.feature.mainflow.root)
            export(projects.shared.feature.mainflow.review.presentation)
            export(projects.shared.feature.mainflow.schedule.presentation)
            export(projects.shared.feature.mainflow.settings.presentation)
            export(projects.shared.libraries.coroutines)
            export(projects.shared.libraries.flow)
            export(projects.shared.libraries.datastore)

            export(libs.decompose)
            export(libs.decompose.compose)
            export(libs.essenty)
            export(libs.essenty.backHandler)
        }
    }

    sourceSets {
        all {
            languageSettings {
                optIn("org.jetbrains.compose.resources.ExperimentalResourceApi")
            }
        }
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.decompose.compose)
            implementation(libs.composeImageLoader)
            implementation(libs.napier)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.kotlinx.datetime)
            implementation(libs.koin.core)


            implementation(libs.decompose)
            implementation(libs.essenty)
            implementation(libs.essenty.backHandler)
            implementation(projects.shared.compose.theme)
            implementation(projects.shared.feature.root)
            implementation(projects.shared.coreDi)

            implementation(projects.shared.feature.mainflow.root)
            implementation(projects.shared.feature.mainflow.review.presentation)
            implementation(projects.shared.feature.mainflow.schedule.presentation)
            implementation(projects.shared.feature.mainflow.settings.presentation)
            implementation(projects.shared.libraries.coroutines)
            implementation(projects.shared.persistent)
            implementation(projects.shared.libraries.flow)
            implementation(projects.shared.libraries.datastore)
            implementation(projects.shared.compose.resources)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
            implementation(libs.kotlinx.coroutines.test)
        }

        androidMain.dependencies {
            implementation(libs.androidx.activityCompose)
            implementation(libs.kotlinx.coroutines.android)
            implementation(libs.ktor.client.okhttp)
        }

        iosMain.dependencies {
            api(projects.shared.compose.theme)
            api(projects.shared.feature.root)
            api(projects.shared.coreDi)

            api(projects.shared.feature.mainflow.root)
            api(projects.shared.feature.mainflow.review.presentation)
            api(projects.shared.feature.mainflow.schedule.presentation)
            api(projects.shared.feature.mainflow.settings.presentation)
            api(projects.shared.libraries.coroutines)
            api(projects.shared.libraries.flow)
            api(projects.shared.libraries.datastore)
            api(projects.shared.compose.resources)

            api(libs.decompose)
            api(libs.decompose.compose)
            api(libs.essenty)
            api(libs.essenty.backHandler)

        }

    }
}

android {
    namespace = "ru.eetk.mobileapp"
    compileSdk = 34

    defaultConfig {
        minSdk = 28
        targetSdk = 34

        applicationId = "ru.eetk.mobileapp.androidApp"
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    sourceSets["main"].apply {
        manifest.srcFile("src/androidMain/AndroidManifest.xml")
        res.srcDirs("src/androidMain/res")
    }
    //https://developer.android.com/studio/test/gradle-managed-devices
    @Suppress("UnstableApiUsage")
    testOptions {
        managedDevices.devices {
            maybeCreate<ManagedVirtualDevice>("pixel5").apply {
                device = "Pixel 5"
                apiLevel = 34
                systemImageSource = "aosp"
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
        //
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.11"
    }
}
