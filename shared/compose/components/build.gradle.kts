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
}
