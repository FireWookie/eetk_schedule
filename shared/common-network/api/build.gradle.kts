import ru.eetk.mobileapp.extension.androidDependencies
import ru.eetk.mobileapp.extension.commonDependencies
import ru.eetk.mobileapp.extension.iosDependencies
import ru.eetk.mobileapp.extension.iosTarget

plugins {
    alias(libs.plugins.eetk.kmplibrary)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "ru.eetk.common.network"
}

kotlin {
    androidTarget()
    iosTarget()

    sourceSets {
        commonDependencies {
            api(libs.ktor.core)
            implementation(libs.koin.core)
            implementation(libs.kotlinx.serialization.json)
        }
    }
}
