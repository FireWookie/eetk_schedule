plugins {
    `kotlin-dsl`
}

group = "ru.eetk.mobileapp"

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
    implementation(libs.compose.gradle.plugin)

    compileOnly(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        register("eetk.library") {
            id = "eetk.library"
            implementationClass = "AndroidLibraryPlugin"
        }
        register("eetk.kmplibrary") {
            id = "eetk.kmplibrary"
            implementationClass = "AndroidKmpLibraryPlugin"
        }
        register("eetk.compose-multiplatform") {
            id = "eetk.compose-multiplatform"
            implementationClass = "ComposeMultiplatformPlugin"
        }
        register("eetk.compose") {
            id = "eetk.compose"
            implementationClass = "AndroidComposePlugin"
        }
        register("eetk.application") {
            id = "eetk.application"
            implementationClass = "AndroidApplicationPlugin"
        }

        register("eetk.compose.main") {
            id = "eetk.compose.main"
            implementationClass = "ComposePlugin"
        }
    }
}

