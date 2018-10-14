package io.jonibek.github.model

import com.google.gson.annotations.SerializedName

class Owner(

        @SerializedName("id")
        var id: Int,
        @SerializedName("login")
        var login: String?,
        @SerializedName("avatar_url")
        var avatarUrl: String?,
        @SerializedName("type")
        var type: String?

)
