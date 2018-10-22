package io.jonibek.github.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import io.jonibek.github.app.GithubApp
import io.jonibek.github.data.local.RepoDao
import io.jonibek.github.data.local.RepoDatabase
import io.jonibek.github.data.local.RepoLocalDataSource
import io.jonibek.github.data.local.RepoLocalDataSourceImpl
import io.jonibek.github.data.remote.GithubAPI
import io.jonibek.github.data.remote.RepoRemoteDataSource
import io.jonibek.github.data.remote.RepoRemoteDataSourceImpl
import io.jonibek.github.repository.RepoRepository
import io.jonibek.github.repository.RepoRepositoryImpl
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class AppModule(private val application: GithubApp) {

    companion object {
        const val URL = "https://api.github.com/"
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
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubAPI::class.java)
    }

    @Provides
    @Singleton
    fun providesRepoRoomDatabase(context: Context) : RepoDatabase {
        return  Room
                .databaseBuilder(context, RepoDatabase::class.java, "repo_database")
                .build()
    }

    @Provides
    @Singleton
    fun providesRepoDao(repoDatabase: RepoDatabase) : RepoDao {
        return repoDatabase.repoDao()
    }


    @Provides
    @Singleton
    fun providesRepoLocalDataSource() : RepoLocalDataSource {
        return RepoLocalDataSourceImpl()
    }

    @Provides
    @Singleton
    fun providesRepoRemoteDataSource() : RepoRemoteDataSource{
        return RepoRemoteDataSourceImpl()
    }

    @Provides
    @Singleton
    fun providesRepoRepository() : RepoRepository{
        return RepoRepositoryImpl()
    }



}