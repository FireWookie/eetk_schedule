import ru.eetk.mobileapp.extension.commonDependencies
import ru.eetk.mobileapp.extension.iosTarget

plugins {
    alias(libs.plugins.eetk.kmplibrary)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "ru.eetk.feature.launch.domain"
}

kotlin {
    androidTarget()
    iosTarget()

    sourceSets {
        commonDependencies {

        }
    }
}
