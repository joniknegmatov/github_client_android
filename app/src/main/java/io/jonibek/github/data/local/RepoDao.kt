package io.jonibek.github.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.jonibek.github.model.Repo
import io.reactivex.Observable

@Dao
interface RepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(repo : Repo)

    @Query("SELECT * from repo_table WHERE owner_login IS :login ")
    fun getRepos(login : String) : Observable<List<Repo>>
}