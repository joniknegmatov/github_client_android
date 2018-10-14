package io.jonibek.github.data.local

import javax.inject.Singleton

import androidx.room.Database
import androidx.room.RoomDatabase
import io.jonibek.github.model.Repo

@Singleton
@Database(entities = [Repo::class], version = 1,exportSchema = false)
abstract class RepoDatabase : RoomDatabase() {
    abstract fun repoDao(): RepoDao
}
