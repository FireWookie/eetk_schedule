import ru.eetk.mobileapp.extension.androidDependencies
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

    androidDependencies {
        implementation(libs.androidx.activityCompose)
    }
}
