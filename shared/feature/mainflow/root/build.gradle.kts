import ru.eetk.mobileapp.extension.commonDependencies
import ru.eetk.mobileapp.extension.iosTarget

plugins {
    alias(libs.plugins.eetk.kmplibrary)
    alias(libs.plugins.eetk.compose.multiplatform)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "ru.eetk.feature.mainflow.root"
}

kotlin {
    androidTarget()
    iosTarget()

    sourceSets {
        commonDependencies {
            implementation(projects.shared.libraries.coroutines)

            implementation(projects.shared.feature.mainflow.settings.presentation)
            implementation(projects.shared.feature.mainflow.schedule.presentation)
            implementation(projects.shared.feature.mainflow.review.presentation)
            implementation(projects.shared.compose.resources)
            implementation(projects.shared.compose.components)

            implementation(libs.decompose)
            implementation(libs.decompose.compose)


        }
    }
}
