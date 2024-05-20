import ru.eetk.mobileapp.extension.commonDependencies
import ru.eetk.mobileapp.extension.iosTarget

plugins {
    alias(libs.plugins.eetk.kmplibrary)
    alias(libs.plugins.eetk.compose.multiplatform)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "ru.eetk.feature.root"
}

kotlin {
    androidTarget()
    iosTarget()

    sourceSets {
        commonDependencies {
            implementation(projects.shared.feature.launch.presentation)
            implementation(projects.shared.feature.mainflow.root)

            implementation(libs.decompose)
            implementation(libs.decompose.compose)
            implementation(libs.koin.core)
        }
    }
}
