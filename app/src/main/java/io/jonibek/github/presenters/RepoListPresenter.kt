package io.jonibek.github.presenters

import android.annotation.SuppressLint
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.jonibek.github.app.GithubApp
import io.jonibek.github.model.Repo
import io.jonibek.github.repository.RepoRepository
import io.jonibek.github.ui.fragments.RepoListView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class RepoListPresenter : MvpPresenter<RepoListView>() {

    @Inject
    lateinit var repository : RepoRepository

    init {
        GithubApp.appComponent.inject(this)
    }

    fun updateRepos(user: String){
        repository.syncCurrentUserRepos(user)
    }

    @SuppressLint("CheckResult")
    fun getRepos(user : String){
        repository.getUserRepos(user)
                .filter{it.isNotEmpty()}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe {
                    result ->
                    setRepos(result)
                }
    }

    private fun setRepos(repoList : List<Repo>){
        viewState.setRepos(repoList)
    }

}