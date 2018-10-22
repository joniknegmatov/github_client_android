package io.jonibek.github.repository

import io.jonibek.github.model.Repo
import io.reactivex.Observable
import io.reactivex.Single

interface RepoRepository {

    fun getUserRepos(name : String) : Observable<List<Repo>>

    fun syncCurrentUserRepos(name : String)

    fun getRepoById(repoId : Int) : Observable<Repo>
}