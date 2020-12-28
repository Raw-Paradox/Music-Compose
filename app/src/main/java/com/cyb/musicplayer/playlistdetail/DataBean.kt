package com.cyb.musicplayer.playlistdetail

import com.google.gson.annotations.SerializedName


/**
 * Created by Paradoox on 2020/12/25.
 */
data class DetailBean(
    @SerializedName("code")
    val code: Int = 0,
//    @SerializedName("relatedVideos")
//    val relatedVideos: Any? = null,
    @SerializedName("playlist")
    val playlist: Playlist = Playlist(),
//    @SerializedName("urls")
//    val urls: Any? = null,
//    @SerializedName("privileges")
//    val privileges: List<Privilege> = listOf()
)

data class Playlist(
//    @SerializedName("subscribers")
//    val subscribers: List<Any> = listOf(),
//    @SerializedName("subscribed")
//    val subscribed: Boolean = false,
    @SerializedName("creator")
    val creator: Creator = Creator(),
    @SerializedName("tracks")
    val tracks: List<Track> = listOf(),
//    @SerializedName("videoIds")
//    val videoIds: Any? = null,
//    @SerializedName("videos")
//    val videos: Any? = null,
    @SerializedName("trackIds")
    val trackIds: List<TrackId> = listOf(),
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
    @SerializedName("subscribedCount")
    val subscribedCount: Int = 0,
    @SerializedName("cloudTrackCount")
    val cloudTrackCount: Int = 0,
    @SerializedName("userId")
    val userId: Int = 0,
    @SerializedName("coverImgUrl")
    val coverImgUrl: String = "",
//    @SerializedName("specialType")
//    val specialType: Int = 0,
//    @SerializedName("updateTime")
//    val updateTime: Long = 0,
//    @SerializedName("trackCount")
//    val trackCount: Int = 0,
//    @SerializedName("privacy")
//    val privacy: Int = 0,
//    @SerializedName("trackUpdateTime")
//    val trackUpdateTime: Long = 0,
//    @SerializedName("trackNumberUpdateTime")
//    val trackNumberUpdateTime: Long = 0,
//    @SerializedName("commentThreadId")
//    val commentThreadId: String = "",
//    @SerializedName("newImported")
//    val newImported: Boolean = false,
//    @SerializedName("createTime")
//    val createTime: Long = 0,
//    @SerializedName("highQuality")
//    val highQuality: Boolean = false,
//    @SerializedName("playCount")
//    val playCount: Int = 0,
//    @SerializedName("coverImgId")
//    val coverImgId: Long = 0,
//    @SerializedName("adType")
//    val adType: Int = 0,
//    @SerializedName("ordered")
//    val ordered: Boolean = false,
//    @SerializedName("tags")
//    val tags: List<Any> = listOf(),
//    @SerializedName("description")
//    val description: Any? = null,
//    @SerializedName("status")
//    val status: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("id")
    val id: Long = 0,
//    @SerializedName("shareCount")
//    val shareCount: Int = 0,
//    @SerializedName("coverImgId_str")
//    val coverImgIdStr: String = "",
//    @SerializedName("commentCount")
//    val commentCount: Int = 0
)

data class Privilege(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("fee")
    val fee: Int = 0,
    @SerializedName("payed")
    val payed: Int = 0,
    @SerializedName("st")
    val st: Int = 0,
    @SerializedName("pl")
    val pl: Int = 0,
    @SerializedName("dl")
    val dl: Int = 0,
    @SerializedName("sp")
    val sp: Int = 0,
    @SerializedName("cp")
    val cp: Int = 0,
    @SerializedName("subp")
    val subp: Int = 0,
    @SerializedName("cs")
    val cs: Boolean = false,
    @SerializedName("maxbr")
    val maxbr: Int = 0,
    @SerializedName("fl")
    val fl: Int = 0,
    @SerializedName("toast")
    val toast: Boolean = false,
    @SerializedName("flag")
    val flag: Int = 0,
    @SerializedName("preSell")
    val preSell: Boolean = false,
    @SerializedName("playMaxbr")
    val playMaxbr: Int = 0,
    @SerializedName("downloadMaxbr")
    val downloadMaxbr: Int = 0,
    @SerializedName("freeTrialPrivilege")
    val freeTrialPrivilege: FreeTrialPrivilege = FreeTrialPrivilege(),
    @SerializedName("chargeInfoList")
    val chargeInfoList: List<ChargeInfo> = listOf()
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

data class Track(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("id")
    val id: String = "",
//    @SerializedName("pst")
//    val pst: Int = 0,
//    @SerializedName("t")
//    val t: Int = 0,
    @SerializedName("ar")
    val ar: List<Ar> = listOf(),
//    @SerializedName("alia")
//    val alia: List<String> = listOf(),
//    @SerializedName("pop")
//    val pop: Int = 0,
//    @SerializedName("st")
//    val st: Int = 0,
//    @SerializedName("rt")
//    val rt: String? = null,
//    @SerializedName("fee")
//    val fee: Int = 0,
//    @SerializedName("v")
//    val v: Int = 0,
//    @SerializedName("crbt")
//    val crbt: Any? = null,
//    @SerializedName("cf")
//    val cf: String = "",
    @SerializedName("al")
    val al: Al = Al(),
//    @SerializedName("dt")
//    val dt: Int = 0,
//    @SerializedName("h")
//    val h: H? = null,
//    @SerializedName("m")
//    val m: M? = null,
//    @SerializedName("l")
//    val l: L? = null,
//    @SerializedName("a")
//    val a: Any? = null,
//    @SerializedName("cd")
//    val cd: String = "",
//    @SerializedName("no")
//    val no: Int = 0,
//    @SerializedName("rtUrl")
//    val rtUrl: Any? = null,
//    @SerializedName("ftype")
//    val ftype: Int = 0,
//    @SerializedName("rtUrls")
//    val rtUrls: List<Any> = listOf(),
//    @SerializedName("djId")
//    val djId: Int = 0,
//    @SerializedName("copyright")
//    val copyright: Int = 0,
//    @SerializedName("s_id")
//    val sId: Int = 0,
//    @SerializedName("mark")
//    val mark: Int = 0,
//    @SerializedName("originCoverType")
//    val originCoverType: Int = 0,
//    @SerializedName("originSongSimpleData")
//    val originSongSimpleData: Any? = null,
//    @SerializedName("single")
//    val single: Int = 0,
//    @SerializedName("noCopyrightRcmd")
//    val noCopyrightRcmd: Any? = null,
//    @SerializedName("rtype")
//    val rtype: Int = 0,
//    @SerializedName("rurl")
//    val rurl: Any? = null,
//    @SerializedName("mst")
//    val mst: Int = 0,
//    @SerializedName("cp")
//    val cp: Int = 0,
//    @SerializedName("mv")
//    val mv: Int = 0,
//    @SerializedName("publishTime")
//    val publishTime: Long = 0,
//    @SerializedName("tns")
//    val tns: List<String> = listOf()
)

data class TrackId(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("v")
    val v: Int = 0,
    @SerializedName("at")
    val at: Long = 0,
    @SerializedName("alg")
    val alg: Any? = null
)

data class Ar(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("tns")
    val tns: List<Any> = listOf(),
    @SerializedName("alias")
    val alias: List<Any> = listOf()
)

data class Al(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("picUrl")
    val picUrl: String = "",
    @SerializedName("tns")
    val tns: List<String> = listOf(),
    @SerializedName("pic")
    val pic: Long = 0,
    @SerializedName("pic_str")
    val picStr: String = ""
)

data class H(
    @SerializedName("br")
    val br: Int = 0,
    @SerializedName("fid")
    val fid: Int = 0,
    @SerializedName("size")
    val size: Int = 0,
    @SerializedName("vd")
    val vd: String = ""
)

data class M(
    @SerializedName("br")
    val br: Int = 0,
    @SerializedName("fid")
    val fid: Int = 0,
    @SerializedName("size")
    val size: Int = 0,
    @SerializedName("vd")
    val vd: Int = 0
)

data class L(
    @SerializedName("br")
    val br: Int = 0,
    @SerializedName("fid")
    val fid: Int = 0,
    @SerializedName("size")
    val size: Int = 0,
    @SerializedName("vd")
    val vd: Int = 0
)

data class FreeTrialPrivilege(
    @SerializedName("resConsumable")
    val resConsumable: Boolean = false,
    @SerializedName("userConsumable")
    val userConsumable: Boolean = false
)

data class ChargeInfo(
    @SerializedName("rate")
    val rate: Int = 0,
    @SerializedName("chargeUrl")
    val chargeUrl: Any? = null,
    @SerializedName("chargeMessage")
    val chargeMessage: Any? = null,
    @SerializedName("chargeType")
    val chargeType: Int = 0
)