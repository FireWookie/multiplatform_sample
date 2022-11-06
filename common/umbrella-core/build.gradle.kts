plugins {
    id("android-setup")
    id("multiplatform-setup")
}


kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))

                implementation(project(":common:auth:data"))
                implementation(project(":common:games:data"))


                implementation(Dependencies.Koin.core)
            }
        }
    }
}
