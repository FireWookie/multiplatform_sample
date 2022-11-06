pluginManagement {
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

rootProject.name = "MobileDeveloperCourse"
include(":androidApp")
include(":common:auth")
include(":common:auth:api")
include(":common:auth:data")
include(":common:auth:presentation")
include(":common:auth:compose")
include(":common:tournaments")
include(":common:tournaments:api")
include(":common:tournaments:presentation")
include(":common:tournaments:data")
include(":common:tournaments:compose")
include(":common:games:api")
include(":common:games:presentation")
include(":common:games:data")
include(":common:games:compose")
include(":common:main:api")
include(":common:main:presentation")
include(":common:main:compose")
include(":common:main:data")
include(":common:core")
include(":common:core-compose")
include(":common:core-utils")
include(":common:umbrella-ios")
include(":common:umbrella-compose")
include(":common:umbrella-core")