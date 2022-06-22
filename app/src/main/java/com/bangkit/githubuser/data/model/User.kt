package com.bangkit.githubuser.data.model

data class User(
    val login: String,
    val id: Int,
    val html_url: String?=null,
    val avatar_url: String,
)
