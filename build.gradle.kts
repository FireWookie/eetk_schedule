plugins {
    alias(libs.plugins.multiplatform).apply(false)
//    alias(libs.plugins.compose.compiler).apply(false)
    alias(libs.plugins.compose.main).apply(false)
    alias(libs.plugins.android.application).apply(false)
    alias(libs.plugins.kotlinx.serialization).apply(false)
    alias(libs.plugins.moko.resources).apply(false)
}


buildscript {
    dependencies {
        classpath(libs.moko.resources.generator)
    }
}