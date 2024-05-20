plugins {
    alias(libs.plugins.multiplatform).apply(false)
//    alias(libs.plugins.compose.compiler).apply(false)
    alias(libs.plugins.compose.main).apply(false)
    alias(libs.plugins.android.application).apply(false)
    alias(libs.plugins.kotlinx.serialization).apply(false)
}

allprojects {
    tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java).configureEach {
        kotlinOptions {
            jvmTarget = "17"
        }
    }

}