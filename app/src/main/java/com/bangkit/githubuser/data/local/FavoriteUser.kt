package com.bangkit.githubuser.data.local

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
@Entity(tableName =  "favorite_user")

data class FavoriteUser(

    val login: String,
    @PrimaryKey
    val id: Int,
    val html_url: String?=null,
    val avatar_url: String,

): Parcelable
