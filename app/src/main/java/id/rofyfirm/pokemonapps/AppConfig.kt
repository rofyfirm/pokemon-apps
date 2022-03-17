package id.rofyfirm.pokemonapps

import android.app.Application
import id.rofyfirm.pokemonapps.network.ApiService
import id.rofyfirm.pokemonapps.network.RequestApi
import id.rofyfirm.pokemonapps.network.repository.Repository
import id.rofyfirm.pokemonapps.ui.evo.EvoViewModelFactory
import id.rofyfirm.pokemonapps.ui.main.MainViewModelFactory
import id.rofyfirm.pokemonapps.ui.stat.StatViewModelFactory
import id.rofyfirm.pokemonapps.utils.ConnectivityInterceptor
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import timber.log.Timber

class AppConfig: Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@AppConfig))

        bind() from singleton { ConnectivityInterceptor(instance()) }
        bind<RequestApi>() with singleton { ApiService.getClient(instance()) }

        bind() from singleton { Repository(instance()) }
        bind() from provider { MainViewModelFactory(instance())}
        bind() from provider { StatViewModelFactory(instance()) }
        bind() from provider { EvoViewModelFactory(instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}