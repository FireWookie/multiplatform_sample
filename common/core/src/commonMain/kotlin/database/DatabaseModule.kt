package database

import org.koin.dsl.module

//internal val databaseModule = DI.Module("database") {
//    bind<DbDriverFactory>() with singleton {
//        DbDriverFactory(instance())
//    }
//}

val databaseModule = module {
    single {
        DbDriverFactory(get())
    }
}