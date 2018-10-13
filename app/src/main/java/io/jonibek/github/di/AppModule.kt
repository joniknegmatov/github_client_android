package io.jonibek.github.di

import android.content.Context
import dagger.Module
import dagger.Provides
import io.jonibek.github.app.GithubApp
import io.jonibek.github.data.remote.GithubAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module(includes = [RoomModule::class])
class AppModule(val application: GithubApp) {

    companion object {
        val URL = "https://api.github.com/"
    }
    @Provides
    fun providesAppContext(): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun providesGithubApi() : GithubAPI {
        return Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubAPI::class.java)
    }


}