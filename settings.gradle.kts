rootProject.name = "EETK_APP"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

include(":composeApp")

include(":shared:common-network")
include(":shared:umbrella-ios")
include(":shared:core-di")
include(
    ":shared:libraries:coroutines",
    ":shared:libraries:datastore"
)
include(":shared:compose:theme")
include(":shared:compose:components")
include(
    ":shared:feature:launch:data",
    ":shared:feature:launch:domain",
    ":shared:feature:launch:presentation"
)
include("shared:feature:root")
include(
    ":shared:feature:mainflow:schedule:data",
    ":shared:feature:mainflow:schedule:domain",
    ":shared:feature:mainflow:schedule:presentation"
)
include(":shared:feature:mainflow:root")
include(
    ":shared:feature:mainflow:review:data",
    ":shared:feature:mainflow:review:domain",
    ":shared:feature:mainflow:review:presentation"
)
include(
    ":shared:feature:mainflow:settings:data",
    ":shared:feature:mainflow:settings:domain",
    ":shared:feature:mainflow:settings:presentation"
)
include(":shared:persistent")