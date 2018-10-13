package io.jonibek.github.data.remote

import io.jonibek.github.model.Repo
import io.jonibek.github.repository.RepoDataSource
import io.reactivex.Observable

class RemoteRepoDataSource(val githubAPI: GithubAPI) : RepoDataSource {

    override fun getRepos(name: String): Observable<List<Repo>> {
       return githubAPI.listRepos(name)
    }
}