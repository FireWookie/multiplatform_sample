plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("plugin.serialization")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(Dependencies.Kotlin.Serialization.serialization)
                api(Dependencies.Kotlin.Coroutines.core)

                api(Dependencies.Ktor.core)

                implementation(Dependencies.Ktor.json)
                implementation(Dependencies.Ktor.serialization)
                implementation(Dependencies.Ktor.negotiation)
                implementation(Dependencies.Ktor.kotlin_json)
                implementation(Dependencies.Ktor.logging)

                api(Dependencies.Other.ViewModel.core)


                api(Dependencies.Koin.core)

                api(Dependencies.Settings.core)
                implementation(Dependencies.Settings.noargs)

                api(Dependencies.SqlDelight.core)
            }
        }

        androidMain {
            dependencies {
                api(Dependencies.Koin.android)
                implementation(Dependencies.Ktor.android)
                api(Dependencies.SqlDelight.android)
            }
        }

        iosMain {
            dependencies {
                implementation(Dependencies.Ktor.ios)
                api(Dependencies.SqlDelight.ios)
            }
        }

        desktopMain {
            dependencies {
                implementation(Dependencies.Ktor.okhttp)
                api(Dependencies.SqlDelight.desktop)
            }
        }
    }
}