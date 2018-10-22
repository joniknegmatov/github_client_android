package io.jonibek.github.data.local

import io.jonibek.github.model.Repo
import io.reactivex.Observable
import io.reactivex.Single

interface RepoLocalDataSource {

    fun getRepoById(repoId : Int) : Observable<Repo>

    fun getRepos(name : String) : Observable<List<Repo>>

    fun saveRepos(repos : List<Repo>)
}