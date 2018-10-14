package io.jonibek.github.repository

import android.annotation.SuppressLint
import io.jonibek.github.app.GithubApp
import io.jonibek.github.data.local.RepoLocalDataSource
import io.jonibek.github.data.remote.RepoRemoteDataSource
import io.jonibek.github.model.Repo
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RepoRepositoryImpl : RepoRepository {

    init {
        GithubApp.appComponent.inject(this)
    }

    @Inject
    lateinit var repoRemoteDataSource : RepoRemoteDataSource

    @Inject
    lateinit var repoLocalLocalDataSource : RepoLocalDataSource


    @SuppressLint("CheckResult")
    override fun syncCurrentUserRepos(name: String) {
        repoRemoteDataSource
                .getRepos(name)
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->
                    saveRepos(result)
                }, { error ->
                    error.printStackTrace()
                })

    }

    private fun saveRepos(repoList: List<Repo>) {
        repoLocalLocalDataSource.saveRepos(repoList)
    }

    override fun getUserRepos(name: String): Single<List<Repo>> {
       return repoLocalLocalDataSource.getRepos(name)
    }


}