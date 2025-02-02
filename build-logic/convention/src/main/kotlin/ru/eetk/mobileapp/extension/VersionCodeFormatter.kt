package ru.eetk.mobileapp.extension

import java.io.FileInputStream
import java.util.Properties

fun provideVersionCode(path: String): Int {
    val properties: Properties = loadVersionProperties(path)
    val major = properties.propertyInt("VERSION")
    val minor = properties.propertyInt("SUB_VERSION")
    val patch = properties.propertyInt("BUILD_VERSION")

    return calcVersionCode(major, minor, patch)
}

fun provideVersionName(path: String): String {
    val properties: Properties = loadVersionProperties(path)
    val major = properties.propertyInt("VERSION")
    val minor = properties.propertyInt("SUB_VERSION")
    val patch = properties.propertyInt("BUILD_VERSION")

    return "$major.$minor.$patch"
}

private fun calcVersionCode(major: Int, minor: Int, patch: Int): Int =
    major * 100000 + minor * 1000 + patch

fun loadVersionProperties(path: String): Properties =
    FileInputStream(path).use { inputStream ->
        Properties().apply {
            load(inputStream)
        }
    }