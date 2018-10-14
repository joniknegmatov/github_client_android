package io.jonibek.github.data.remote

import io.jonibek.github.app.GithubApp
import io.jonibek.github.model.Repo
import io.reactivex.Observable
import javax.inject.Inject

class RepoRemoteDataSourceImpl : RepoRemoteDataSource {

    @Inject
    lateinit var githubAPI: GithubAPI

    init {
        GithubApp.appComponent.inject(this)
    }

    override fun getRepos(name: String): Observable<List<Repo>> {
        return githubAPI.listRepos(name)
    }
}