import org.gradle.api.JavaVersion
import ApkConfig.COMPILE_SDK_VERSION
import ApkConfig.MIN_SDK_VERSION
import ApkConfig.TARGET_SDK_VERSION
import ApkConfig.VERSION_CODE
import ApkConfig.VERSION_NAME
import ApkConfig.JAVA_VERSION


plugins {
    id("com.android.library")
}

android {
    compileSdk = COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = MIN_SDK_VERSION
        targetSdk = TARGET_SDK_VERSION

        consumerProguardFiles("consumer-rules.pro")
    }

    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs("src/androidMain/res", "src/commonMain/resources")
        }
    }

    buildFeatures {
        compose = true
    }

    buildTypes {
        maybeCreate("debug").apply {
            buildConfigField("boolean", "INTERNAL", "true")
//            multiDexEnabled = true
            isMinifyEnabled = false
        }

        maybeCreate("release").apply {
            buildConfigField("boolean", "INTERNAL", "false")
            isMinifyEnabled = true
            consumerProguardFile("proguard-rules.pro")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.1"
    }
}