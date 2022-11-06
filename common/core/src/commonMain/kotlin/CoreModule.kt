import database.databaseModule
import json.serializationModule
import ktor.ktorModule
import settings.settingsModule

//val coreModule = DI.Module("coreModule") {
//    importAll(
//        ktorModule,
//        databaseModule,
//        serializationModule
//    )
//}

val coreModule = listOf(ktorModule, databaseModule, serializationModule, settingsModule)