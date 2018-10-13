package io.jonibek.github.data.local

import io.jonibek.github.model.Repo
import io.jonibek.github.repository.RepoDataSource
import io.reactivex.Observable
import javax.inject.Inject

class LocalRepoDataSource : RepoDataSource {

    @Inject
    lateinit var repoDatabase: RepoDatabase

    override fun getRepos(name: String): Observable<List<Repo>> {
        return repoDatabase.repoDao().getRepos(name)
    }

}