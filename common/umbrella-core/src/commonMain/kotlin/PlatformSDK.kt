import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.module

object PlatformSDK {

    fun init(configuration: PlatformConfiguration) = startKoin {
        modules(coreModule)
        modules(gamesModule)
        modules(authModule)
        val umbrellaModule = module {
            single<PlatformConfiguration> {
                configuration
            }
        }
        modules(umbrellaModule)
    }
}