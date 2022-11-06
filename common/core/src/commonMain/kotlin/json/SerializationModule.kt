package json

import kotlinx.serialization.json.Json
import org.koin.dsl.module

//internal val serializationModule = DI.Module("serializationModule") {
//    bind<Json>() with singleton {
//        Json {
//            isLenient = true
//            ignoreUnknownKeys = true
//        }
//    }
//}

val serializationModule = module {
    single<Json> {
        Json {
            isLenient = true
            ignoreUnknownKeys = true
        }
    }
}