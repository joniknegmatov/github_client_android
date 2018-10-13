package io.jonibek.github.data.remote

import io.jonibek.github.model.Repo
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubAPI {

    @GET("/users/{user}/repos")
    fun listRepos(@Path("user") user: String): Observable<List<Repo>>
}
