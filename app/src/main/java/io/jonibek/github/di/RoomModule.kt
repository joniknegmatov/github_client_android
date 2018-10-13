package io.jonibek.github.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import io.jonibek.github.app.GithubApp
import io.jonibek.github.data.local.RepoDao
import io.jonibek.github.data.local.RepoDatabase
import javax.inject.Singleton

@Module
class RoomModule(val application : GithubApp,
                 val database : RepoDatabase = Room
                         .databaseBuilder(application, RepoDatabase::class.java, "repo_database")
                         .build()){

    @Provides
    @Singleton
    fun providesRepoRoomDatabase(context: Context) : RepoDatabase{
        return database
    }

    @Provides
    @Singleton
    fun providesRepoDao(repoDatabase: RepoDatabase) : RepoDao {
        return repoDatabase.repoDao()
    }

}