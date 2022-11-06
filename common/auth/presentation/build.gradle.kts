plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:auth:api"))
                implementation(project(":common:games:api"))
                implementation(project(":common:core"))
                implementation(Dependencies.Other.ViewModel.core)
            }
        }
        androidMain {
            dependencies {
                implementation(Dependencies.Android.Compose.ui)
                implementation(Dependencies.Android.Compose.material)
                implementation(Dependencies.Android.Compose.icons)
                implementation(Dependencies.Android.Compose.tooling)
            }
        }
    }
}