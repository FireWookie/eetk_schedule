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
include(":shared:core-di")
include(
    ":shared:libraries:coroutines",
    ":shared:libraries:datastore",
    ":shared:libraries:flow",
    ":shared:libraries:platform"
)
include(
    ":shared:compose:theme",
    ":shared:compose:components",
    ":shared:compose:animation",
    ":shared:compose:resources",
    ":shared:compose:components-sheet"
)
include(
    ":shared:feature:launch:data",
    ":shared:feature:launch:domain",
    ":shared:feature:launch:presentation"
)
include(":shared:feature:photo-selector")
include("shared:feature:root")
include("shared:feature:splash")
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