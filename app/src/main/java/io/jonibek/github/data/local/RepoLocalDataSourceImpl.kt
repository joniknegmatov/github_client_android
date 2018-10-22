package io.jonibek.github.data.local

import io.jonibek.github.app.GithubApp
import io.jonibek.github.model.Repo
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class RepoLocalDataSourceImpl : RepoLocalDataSource {

    @Inject
    lateinit var database: RepoDatabase

    init {
        GithubApp.appComponent.inject(this)
    }

    override fun getRepos(name: String): Observable<List<Repo>> {
        return database.repoDao().getRepos(name)
    }

    override fun getRepoById(repoId: Int) : Observable<Repo>{
        return database.repoDao().getRepoById(repoId)
    }

    override fun saveRepos(repos: List<Repo>) {
        repos.forEach { repo ->
            database.repoDao().insert(repo)
        }
    }

}