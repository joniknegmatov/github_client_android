package io.jonibek.github.app

import android.app.Application
import io.jonibek.github.data.local.RepoDao
import io.jonibek.github.di.AppComponent
import io.jonibek.github.di.AppModule
import io.jonibek.github.di.DaggerAppComponent
import io.jonibek.github.di.RoomModule
import javax.inject.Inject

class GithubApp : Application(){

    lateinit var appComponent : AppComponent

    @Inject
    lateinit var repoDao: RepoDao

    override fun onCreate() {
        super.onCreate()
        this.appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .roomModule(RoomModule(this))
                .build()
        appComponent.inject(this)
    }


}
