package io.jonibek.github.di

import dagger.Component
import io.jonibek.github.app.GithubApp
import io.jonibek.github.data.local.RepoLocalDataSourceImpl
import io.jonibek.github.data.remote.RepoRemoteDataSourceImpl
import io.jonibek.github.presenters.RepoListPresenter
import io.jonibek.github.repository.RepoRepositoryImpl
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {

    fun inject(application: GithubApp)

    fun inject(repository: RepoRepositoryImpl)

    fun inject(repoListPresenter: RepoListPresenter)

    fun inject(repoRepoRemoteDataSourceImpl: RepoRemoteDataSourceImpl)

    fun inject(repoLocalLocalDataSource: RepoLocalDataSourceImpl)

}