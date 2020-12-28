package com.cyb.musicplayer.main
import com.google.gson.annotations.SerializedName


/**
 * Created by Paradoox on 2020/12/25.
 */

data class PlayLists(
    @SerializedName("version")
    val version: String = "",
    @SerializedName("more")
    val more: Boolean = false,
    @SerializedName("playlist")
    val playlist: List<Playlist> = listOf(),
    @SerializedName("code")
    val code: Int = 0
)

data class Playlist(
    @SerializedName("subscribers")
    val subscribers: List<Any> = listOf(),
    @SerializedName("subscribed")
    val subscribed: Boolean = false,
    @SerializedName("creator")
    val creator: Creator = Creator(),
    @SerializedName("artists")
    val artists: Any? = null,
    @SerializedName("tracks")
    val tracks: Any? = null,
    @SerializedName("updateFrequency")
    val updateFrequency: Any? = null,
    @SerializedName("backgroundCoverId")
    val backgroundCoverId: Int = 0,
    @SerializedName("backgroundCoverUrl")
    val backgroundCoverUrl: Any? = null,
    @SerializedName("titleImage")
    val titleImage: Int = 0,
    @SerializedName("titleImageUrl")
    val titleImageUrl: Any? = null,
    @SerializedName("englishTitle")
    val englishTitle: Any? = null,
    @SerializedName("opRecommend")
    val opRecommend: Boolean = false,
    @SerializedName("recommendInfo")
    val recommendInfo: Any? = null,
    @SerializedName("subscribedCount")
    val subscribedCount: Int = 0,
    @SerializedName("cloudTrackCount")
    val cloudTrackCount: Int = 0,
    @SerializedName("adType")
    val adType: Int = 0,
    @SerializedName("trackNumberUpdateTime")
    val trackNumberUpdateTime: Long = 0,
    @SerializedName("commentThreadId")
    val commentThreadId: String = "",
    @SerializedName("userId")
    val userId: Int = 0,
    @SerializedName("updateTime")
    val updateTime: Long = 0,
    @SerializedName("coverImgId")
    val coverImgId: Long = 0,
    @SerializedName("trackCount")
    val trackCount: Int = 0,
    @SerializedName("privacy")
    val privacy: Int = 0,
    @SerializedName("trackUpdateTime")
    val trackUpdateTime: Long = 0,
    @SerializedName("totalDuration")
    val totalDuration: Int = 0,
    @SerializedName("coverImgUrl")
    val coverImgUrl: String = "",
    @SerializedName("specialType")
    val specialType: Int = 0,
    @SerializedName("newImported")
    val newImported: Boolean = false,
    @SerializedName("anonimous")
    val anonimous: Boolean = false,
    @SerializedName("createTime")
    val createTime: Long = 0,
    @SerializedName("highQuality")
    val highQuality: Boolean = false,
    @SerializedName("playCount")
    val playCount: Int = 0,
    @SerializedName("ordered")
    val ordered: Boolean = false,
    @SerializedName("tags")
    val tags: List<String> = listOf(),
    @SerializedName("description")
    val description: Any? = null,
    @SerializedName("status")
    val status: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("coverImgId_str")
    val coverImgIdStr: String = ""
)

data class Creator(
    @SerializedName("defaultAvatar")
    val defaultAvatar: Boolean = false,
    @SerializedName("province")
    val province: Int = 0,
    @SerializedName("authStatus")
    val authStatus: Int = 0,
    @SerializedName("followed")
    val followed: Boolean = false,
    @SerializedName("avatarUrl")
    val avatarUrl: String = "",
    @SerializedName("accountStatus")
    val accountStatus: Int = 0,
    @SerializedName("gender")
    val gender: Int = 0,
    @SerializedName("city")
    val city: Int = 0,
    @SerializedName("birthday")
    val birthday: String = "",
    @SerializedName("userId")
    val userId: Int = 0,
    @SerializedName("userType")
    val userType: Int = 0,
    @SerializedName("nickname")
    val nickname: String = "",
    @SerializedName("signature")
    val signature: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("detailDescription")
    val detailDescription: String = "",
    @SerializedName("avatarImgId")
    val avatarImgId: Long = 0,
    @SerializedName("backgroundImgId")
    val backgroundImgId: Long = 0,
    @SerializedName("backgroundUrl")
    val backgroundUrl: String = "",
    @SerializedName("authority")
    val authority: Int = 0,
    @SerializedName("mutual")
    val mutual: Boolean = false,
    @SerializedName("expertTags")
    val expertTags: Any? = null,
    @SerializedName("experts")
    val experts: Any? = null,
    @SerializedName("djStatus")
    val djStatus: Int = 0,
    @SerializedName("vipType")
    val vipType: Int = 0,
    @SerializedName("remarkName")
    val remarkName: Any? = null,
    @SerializedName("authenticationTypes")
    val authenticationTypes: Int = 0,
    @SerializedName("avatarDetail")
    val avatarDetail: Any? = null,
    @SerializedName("anchor")
    val anchor: Boolean = false,
    @SerializedName("avatarImgIdStr")
    val avatarImgIdStr: String = "",
    @SerializedName("backgroundImgIdStr")
    val backgroundImgIdStr: String = "",
    @SerializedName("avatarImgId_str")
    val avatarImgIdStr2: String = ""
)