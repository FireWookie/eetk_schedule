import ru.eetk.mobileapp.extension.androidDependencies
import ru.eetk.mobileapp.extension.iosTarget

plugins {
    alias(libs.plugins.eetk.kmplibrary)
    alias(libs.plugins.eetk.compose.multiplatform)
}

android {
    namespace = "ru.eetk.compose.components"
}

kotlin {
    androidTarget()
    iosTarget()

    sourceSets {
        androidDependencies {
            implementation(libs.androidx.camera)
            implementation(libs.androidx.camera.lifecycle)
            implementation(libs.androidx.camera.view)
            implementation(libs.androidx.activityCompose)
        }
    }
}
