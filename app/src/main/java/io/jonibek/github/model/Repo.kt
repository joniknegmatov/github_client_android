package io.jonibek.github.model

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repo_table")
data class Repo(

        @PrimaryKey
        @SerializedName("id")
        var id: Int,
        @SerializedName("name")
        var name: String?,
        @SerializedName("full_name")
        var fullName: String?,
        @SerializedName("private")
        var isPrivate: Boolean?,
        @SerializedName("stargazers_count")
        var stargazersCount: Int,
        @SerializedName("language")
        var language: String?,
        @SerializedName("forks_count")
        var forksCount: Int,
        @SerializedName("owner")
        @Embedded(prefix = "owner_")
        val owner: Owner?

)

