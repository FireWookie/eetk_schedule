import ru.eetk.mobileapp.extension.androidDependencies
import ru.eetk.mobileapp.extension.commonDependencies
import ru.eetk.mobileapp.extension.iosTarget

plugins {
    alias(libs.plugins.eetk.kmplibrary)
    alias(libs.plugins.eetk.compose.multiplatform)
}

android {
    namespace = "ru.eetk.compose.theme"
}

kotlin {
    androidTarget()
    iosTarget()

    commonDependencies {
        api(libs.decompose)
        api(libs.decompose.compose)

        implementation(projects.shared.libraries.coroutines)
        implementation(libs.koin.core)
    }

    androidDependencies {
        implementation(libs.androidx.activityCompose)
    }
}
