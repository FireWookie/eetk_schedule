import org.jetbrains.kotlin.utils.addToStdlib.safeAs
import ru.eetk.mobileapp.extension.commonDependencies
import ru.eetk.mobileapp.extension.iosTarget

plugins {
    alias(libs.plugins.eetk.kmplibrary)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "ru.eetk.feature.schedule.data"
}

kotlin {
    androidTarget()
    iosTarget()

    sourceSets {
        commonDependencies {
            implementation(projects.shared.feature.mainflow.schedule.domain)
            implementation(projects.shared.commonNetwork)

            implementation(libs.koin.core)
            implementation(libs.kotlinx.serialization.json)
        }
    }
}
