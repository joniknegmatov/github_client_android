package io.jonibek.github.repository

import io.jonibek.github.model.Repo
import io.reactivex.Observable

interface RepoDataSource {

    fun getRepos(name : String) : Observable<List<Repo>>
}