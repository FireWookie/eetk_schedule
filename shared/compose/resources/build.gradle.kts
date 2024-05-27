import ru.eetk.mobileapp.extension.commonDependencies
import ru.eetk.mobileapp.extension.iosTarget

plugins {
    alias(libs.plugins.eetk.kmplibrary)
    alias(libs.plugins.eetk.compose.multiplatform)
    alias(libs.plugins.moko.resources)
}

android {
    namespace = "ru.eetk.compose.resources"
}

kotlin {
    androidTarget()
    iosTarget()

    sourceSets {
        commonDependencies {
            implementation(libs.moko.resources)
            api(libs.compose.icons.extended)
            api(libs.moko.resources.compose)
        }
    }
}

multiplatformResources {
    iosBaseLocalizationRegion = "ru" // optional, default "en"
    resourcesClassName.set("EetkRes")
    resourcesPackage.set("ru.eetk.resources")

}
