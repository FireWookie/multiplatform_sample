plugins {
    id("android-setup")
    id("multiplatform-compose")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core-compose"))
                implementation(project(":common:core"))
                implementation(project(":common:auth:compose"))
                implementation(project(":common:main:compose"))
                implementation(project(":common:auth:data"))
                implementation(project(":common:games:data"))
                implementation(project(":common:tournaments:data"))
                implementation(project(":common:core-utils"))

                implementation(Dependencies.Other.ViewModel.odyssey)
                implementation(Dependencies.Other.Navigation.compose)
                implementation(Dependencies.Other.Navigation.core)
            }
        }

        androidMain {
            dependencies {
                implementation(project(":common:core-compose"))
                implementation(Dependencies.Android.composeActivity)
            }
        }
    }
}