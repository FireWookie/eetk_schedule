import ru.eetk.mobileapp.extension.commonDependencies
import ru.eetk.mobileapp.extension.iosTarget

plugins {
    alias(libs.plugins.eetk.kmplibrary)
    alias(libs.plugins.eetk.compose.multiplatform)
}

android {
    namespace = "ru.eetk.libraries.flow"
}

kotlin {
    androidTarget()
    iosTarget()
    sourceSets {
        commonDependencies {
            implementation(libs.koin.core)
        }
    }
}
