import ru.eetk.mobileapp.extension.commonDependencies
import ru.eetk.mobileapp.extension.iosTarget

plugins {
    alias(libs.plugins.eetk.kmplibrary)
    alias(libs.plugins.eetk.compose.multiplatform)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "ru.eetk.feature.settings.presentation"
}

kotlin {
    androidTarget()
    iosTarget()

    sourceSets {
        commonDependencies {
            implementation(libs.koin.core)

            implementation(projects.shared.libraries.coroutines)
            implementation(projects.shared.libraries.flow)

            implementation(projects.shared.compose.resources)
            implementation(projects.shared.compose.components)
            implementation(projects.shared.compose.theme)
            implementation(projects.shared.compose.animation)

            implementation(libs.mvikotlin.extensions)
            implementation(libs.mvikotlin)
            implementation(libs.mvikotlin.main)

        }
    }
}
