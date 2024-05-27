import ru.eetk.mobileapp.extension.commonDependencies
import ru.eetk.mobileapp.extension.iosTarget

plugins {
    alias(libs.plugins.eetk.kmplibrary)
    alias(libs.plugins.eetk.compose.multiplatform)
}

android {
    namespace = "ru.eetk.compose.animation"
}

kotlin {
    androidTarget()
    iosTarget()

    sourceSets {
        commonDependencies {
            implementation(libs.decompose.compose)
            api(libs.cupertino.decompose)
            implementation(libs.decompose)
        }
    }
}
