package io.jonibek.github.di

import dagger.Component
import io.jonibek.github.app.GithubApp
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent{

   fun inject(application: GithubApp)

}