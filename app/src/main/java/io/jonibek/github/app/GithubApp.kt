package io.jonibek.github.app

import android.app.Application
import io.jonibek.github.di.AppComponent
import io.jonibek.github.di.AppModule
import io.jonibek.github.di.DaggerAppComponent

class GithubApp : Application(){

    companion object {
        lateinit var appComponent : AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }



}
