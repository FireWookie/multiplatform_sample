package com.multiplatform.mobiledevelopercourse.android

import PlatformConfiguration
import PlatformSDK
import android.app.Application

class PlayZoneApp: Application() {
    override fun onCreate() {
        super.onCreate()

        PlatformSDK.init(configuration = PlatformConfiguration(androidContext = applicationContext))
    }
}

//fun PlayZoneApp.initPlatformSDK() =
//    PlatformSDK.init(
//        configuration = PlatformConfiguration(androidContext = applicationContext)
//    )