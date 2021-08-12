package com.yiwencheng.mvp_practice
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("token")
    val token: String?,

    @SerializedName("user")
    val user: UserLoginInfo?,

    val error: Boolean?,
    val message: String?
)

data class UserLoginInfo(
    val __v: Int,
    val _id: String,
    val createdAt: String,
    val email: String,
    val name: String,
    val password: String,
    val type: String
)
