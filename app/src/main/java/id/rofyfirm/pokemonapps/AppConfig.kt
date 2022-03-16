package id.rofyfirm.pokemonapps

import android.app.Application
import timber.log.Timber

class AppConfig: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}