package io.jonibek.github.repository

import io.jonibek.github.model.Repo
import io.reactivex.Single

interface RepoRepository {

    fun getUserRepos(name : String) : Single<List<Repo>>

    fun syncCurrentUserRepos(name : String)

}