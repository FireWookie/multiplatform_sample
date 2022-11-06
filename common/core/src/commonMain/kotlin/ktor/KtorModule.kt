package ktor

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.kotlinx.serializer.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import kotlin.math.log

//internal val ktorModule = DI.Module("ktorModule") {
//    bind<HttpClient>(HttpEngineFactory().createEngine()) with singleton {
//        HttpClient {
//            install(Logging) {
//                logger = Logger.SIMPLE
//                level = LogLevel.ALL
//            }
//            install(ContentNegotiation) {
//                json(Json{ isLenient = true; ignoreUnknownKeys = true})
//            }
//            install(HttpTimeout) {
//                connectTimeoutMillis = 15000
//                requestTimeoutMillis = 30000
//
//            }
//            defaultRequest {
//                url("https://playzone-backend.herokuapp.com/")
//            }
//        }
//    }
//}

val ktorModule = module {
    single {
        HttpEngineFactory().createEngine()
    }
    single {
        HttpClient {
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }
            install(ContentNegotiation) {
                json(Json{ isLenient = true; ignoreUnknownKeys = true})
            }
            install(HttpTimeout) {
                connectTimeoutMillis = 15000
                requestTimeoutMillis = 30000
            }
            defaultRequest {
                header("Content-Type", "application/json; charset=UTF-8")
                url("https://playzone-backend.herokuapp.com/")
            }
        }
    }
}