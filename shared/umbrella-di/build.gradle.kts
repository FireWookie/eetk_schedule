import ru.eetk.mobileapp.extension.androidDependencies
import ru.eetk.mobileapp.extension.commonDependencies
import ru.eetk.mobileapp.extension.iosTarget

plugins {
    alias(libs.plugins.eetk.kmplibrary)
    alias(libs.plugins.eetk.compose.multiplatform)
}

android {
    namespace = "ru.eetk.umbrella_di"
}

kotlin {
    androidTarget()
    iosTarget()
    sourceSets {
        commonDependencies {
        }
    }
}
