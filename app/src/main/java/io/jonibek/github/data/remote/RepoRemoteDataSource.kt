package io.jonibek.github.data.remote

import io.jonibek.github.model.Repo
import io.reactivex.Observable

interface RepoRemoteDataSource {

    fun getRepos(name : String) : Observable<List<Repo>>
}
