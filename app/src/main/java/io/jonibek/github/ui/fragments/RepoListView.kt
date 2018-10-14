package io.jonibek.github.ui.fragments

import com.arellomobile.mvp.MvpView
import io.jonibek.github.model.Repo

interface RepoListView : MvpView {
    fun setRepos(repoList : List<Repo>)
}