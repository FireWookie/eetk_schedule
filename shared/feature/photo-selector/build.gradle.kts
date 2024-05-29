import ru.eetk.mobileapp.extension.commonDependencies
import ru.eetk.mobileapp.extension.iosTarget

plugins {
    alias(libs.plugins.eetk.kmplibrary)
    alias(libs.plugins.eetk.compose.multiplatform)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "ru.eetk.feature.photo_selector"
}

kotlin {
    androidTarget()
    iosTarget()

    sourceSets {
        commonDependencies {
            implementation(projects.shared.compose.components)
            implementation(projects.shared.compose.componentsSheet)
            implementation(projects.shared.compose.resources)
            implementation(projects.shared.compose.theme)

            implementation(projects.shared.libraries.platform)
            implementation(projects.shared.libraries.flow)

            implementation(libs.mvikotlin)
            implementation(libs.mvikotlin.extensions)

            implementation(libs.koin.core)
        }
    }
}
