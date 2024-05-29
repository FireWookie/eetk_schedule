import ru.eetk.mobileapp.extension.androidDependencies
import ru.eetk.mobileapp.extension.commonDependencies
import ru.eetk.mobileapp.extension.iosTarget

plugins {
    alias(libs.plugins.eetk.kmplibrary)
    alias(libs.plugins.eetk.compose.multiplatform)
}

android {
    namespace = "ru.eetk.libraries.platform"
}

kotlin {
    androidTarget()
    iosTarget()
    sourceSets {
        commonDependencies {
            implementation(libs.koin.core)

            implementation(projects.shared.coreDi)
        }

        androidDependencies {
            implementation("androidx.core:core-ktx:1.12.0")
        }
    }
}
