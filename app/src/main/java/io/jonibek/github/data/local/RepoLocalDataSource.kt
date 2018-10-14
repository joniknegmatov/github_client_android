package io.jonibek.github.data.local

import io.jonibek.github.model.Repo
import io.reactivex.Single

interface RepoLocalDataSource {

    fun getRepos(name : String) : Single<List<Repo>>

    fun saveRepos(repos : List<Repo>)
}