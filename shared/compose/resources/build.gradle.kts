import ru.eetk.mobileapp.extension.commonDependencies
import ru.eetk.mobileapp.extension.iosTarget

plugins {
    alias(libs.plugins.eetk.kmplibrary)
    alias(libs.plugins.eetk.compose.multiplatform)
//    alias(libs.plugins.compose.jb)
}

android {
    namespace = "ru.eetk.compose.resources"
}

kotlin {
    androidTarget()
    iosTarget()

    sourceSets {
        all {
            languageSettings {
                optIn("org.jetbrains.compose.resources.ExperimentalResourceApi")
            }
        }
        commonDependencies {
            api(libs.compose.resources)
        }
    }
}

compose.resources {
    publicResClass = true
}