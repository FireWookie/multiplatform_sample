import ktor.KtorGamesDataSource
import org.koin.dsl.module
import sqldelight.SqlDelightGamesDataSource

//val gamesModule = DI.Module("gamesModule") {
//    bind<KtorGamesDataSource>() with provider {
//        KtorGamesDataSource(instance())
//    }
//    bind<SqlDelightGamesDataSource>() with provider {
//        SqlDelightGamesDataSource()
//    }
//    bind<GamesRepository>() with singleton {
//        GamesRepositoryImpl(instance(), instance())
//    }
//}

val gamesModule = module {
    single {
        KtorGamesDataSource(get())
    }

    single {
        SqlDelightGamesDataSource()
    }

    single<GamesRepository> {
        GamesRepositoryImpl(get(), get())
    }
}