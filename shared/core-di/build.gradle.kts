import ru.eetk.mobileapp.extension.androidDependencies
import ru.eetk.mobileapp.extension.commonDependencies
import ru.eetk.mobileapp.extension.iosTarget

plugins {
    alias(libs.plugins.eetk.kmplibrary)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "ru.eetk.core-di"
}

kotlin {
    androidTarget()
    iosTarget()

    sourceSets {
        commonDependencies {
            api(libs.koin.core)

            implementation(projects.shared.libraries.datastore)
        }
        androidDependencies {
            api(libs.koin.androidx.compose)
        }
    }
}
