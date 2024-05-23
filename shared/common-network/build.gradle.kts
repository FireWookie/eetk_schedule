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
    jvmToolchain(17)
    androidTarget()
    iosTarget()

    sourceSets {
        commonDependencies {
            implementation(projects.shared.commonNetwork)
            implementation(libs.koin.core)
            implementation(libs.kotlinx.serialization.json)
        }
        androidDependencies {
            implementation(libs.ktor.client.okhttp)
        }
        iosDependencies {
            implementation(libs.ktor.client.darwin)
        }
    }
}
