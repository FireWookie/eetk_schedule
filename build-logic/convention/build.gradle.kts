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
        register("eetk.kmplibrary") {
            id = "eetk.kmplibrary"
            implementationClass = "AndroidKmpLibraryPlugin"
        }
        register("eetk.compose-multiplatform") {
            id = "eetk.compose-multiplatform"
            implementationClass = "ComposeMultiplatformPlugin"
        }
    }
}

