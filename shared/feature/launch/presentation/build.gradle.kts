import ru.eetk.mobileapp.extension.commonDependencies
import ru.eetk.mobileapp.extension.iosTarget

plugins {
    alias(libs.plugins.eetk.kmplibrary)
    alias(libs.plugins.eetk.compose.multiplatform)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "ru.eetk.feature.launch.presentation"
}

kotlin {
    androidTarget()
    iosTarget()

    sourceSets {
        commonDependencies {
            implementation(projects.shared.feature.launch.domain)

            implementation(projects.shared.compose.animation)
            implementation(projects.shared.compose.components)
            
            implementation(libs.decompose)
            implementation(libs.decompose.compose)
            implementation(libs.koin.core)

            implementation(libs.mvikotlin.extensions)
            implementation(libs.mvikotlin)
        }
    }
}
