import ktor.KtorAuthRemoteDataSource
import org.koin.dsl.module
import settings.SettingsAuthDataSource

val authModule = module {
    single<AuthRepository> {
        AuthRepositoryImpl(get(), get())
    }

    single {
        SettingsAuthDataSource(get())
    }

    single<KtorAuthRemoteDataSource> {
        KtorAuthRemoteDataSource(get())
    }
}