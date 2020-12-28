package com.cyb.musicplayer.login

import com.google.gson.annotations.SerializedName

data class LoginBean(
//    @SerializedName("account")
//    val account: Account = Account(),
//    @SerializedName("bindings")
//    val bindings: List<Binding> = listOf(),
    @SerializedName("code")
    val code: Int = 0,
    @SerializedName("cookie")
    val cookie: String = "",
    @SerializedName("loginType")
    val loginType: Int = 0,
    @SerializedName("profile")
    val profile: Profile = Profile(),
    @SerializedName("token")
    val token: String = ""
)

//data class Account(
//    @SerializedName("anonimousUser")
//    val anonimousUser: Boolean = false,
//    @SerializedName("ban")
//    val ban: Int = 0,
//    @SerializedName("baoyueVersion")
//    val baoyueVersion: Int = 0,
//    @SerializedName("createTime")
//    val createTime: Long = 0,
//    @SerializedName("donateVersion")
//    val donateVersion: Int = 0,
//    @SerializedName("id")
//    val id: Int = 0,
//    @SerializedName("salt")
//    val salt: String = "",
//    @SerializedName("status")
//    val status: Int = 0,
//    @SerializedName("tokenVersion")
//    val tokenVersion: Int = 0,
//    @SerializedName("type")
//    val type: Int = 0,
//    @SerializedName("userName")
//    val userName: String = "",
//    @SerializedName("vipType")
//    val vipType: Int = 0,
//    @SerializedName("viptypeVersion")
//    val viptypeVersion: Int = 0,
//    @SerializedName("whitelistAuthority")
//    val whitelistAuthority: Int = 0
//)

//data class Binding(
//    @SerializedName("bindingTime")
//    val bindingTime: Long = 0,
//    @SerializedName("expired")
//    val expired: Boolean = false,
//    @SerializedName("expiresIn")
//    val expiresIn: Int = 0,
//    @SerializedName("id")
//    val id: Long = 0,
//    @SerializedName("refreshTime")
//    val refreshTime: Int = 0,
//    @SerializedName("tokenJsonStr")
//    val tokenJsonStr: String = "",
//    @SerializedName("type")
//    val type: Int = 0,
//    @SerializedName("url")
//    val url: String = "",
//    @SerializedName("userId")
//    val userId: Int = 0
//)

data class Profile(
//    @SerializedName("accountStatus")
//    val accountStatus: Int = 0,
//    @SerializedName("authStatus")
//    val authStatus: Int = 0,
//    @SerializedName("authority")
//    val authority: Int = 0,
//    @SerializedName("avatarDetail")
//    val avatarDetail: Any? = null,
//    @SerializedName("avatarImgId")
//    val avatarImgId: Long = 0,
//    @SerializedName("avatarImgIdStr")
//    val avatarImgIdStr: String = "",
//    @SerializedName("avatarImgId_str")
//    val avatarImgIdStr2: String = "",
    @SerializedName("avatarUrl")
    val avatarUrl: String = "",
//    @SerializedName("backgroundImgId")
//    val backgroundImgId: Long = 0,
//    @SerializedName("backgroundImgIdStr")
//    val backgroundImgIdStr: String = "",
    @SerializedName("backgroundUrl")
    val backgroundUrl: String = "",
//    @SerializedName("birthday")
//    val birthday: Int = 0,
//    @SerializedName("city")
//    val city: Int = 0,
    @SerializedName("defaultAvatar")
    val defaultAvatar: Boolean = false,
    @SerializedName("description")
    val description: String = "",
    @SerializedName("detailDescription")
    val detailDescription: String = "",
//    @SerializedName("djStatus")
//    val djStatus: Int = 0,
//    @SerializedName("eventCount")
//    val eventCount: Int = 0,
//    @SerializedName("expertTags")
//    val expertTags: Any? = null,
//    @SerializedName("experts")
//    val experts: Experts = Experts(),
    @SerializedName("followed")
    val followed: Boolean = false,
    @SerializedName("followeds")
    val followeds: Int = 0,
    @SerializedName("follows")
    val follows: Int = 0,
    @SerializedName("gender")
    val gender: Int = 0,
    @SerializedName("mutual")
    val mutual: Boolean = false,
    @SerializedName("nickname")
    val nickname: String = "",
    @SerializedName("playlistBeSubscribedCount")
    val playlistBeSubscribedCount: Int = 0,
    @SerializedName("playlistCount")
    val playlistCount: Int = 0,
//    @SerializedName("province")
//    val province: Int = 0,
//    @SerializedName("remarkName")
//    val remarkName: Any? = null,
//    @SerializedName("signature")
//    val signature: String = "",
    @SerializedName("userId")
    val userId: String = "",
//    @SerializedName("userType")
//    val userType: Int = 0,
//    @SerializedName("vipType")
//    val vipType: Int = 0
)

class Experts(
)