package com.cyb.musicplayer.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.cyb.musicplayer.util.BaseNetwork
import com.google.gson.annotations.SerializedName
import retrofit2.http.GET


/**
 * Created by Paradoox on 2020/12/27.
 */

data class Song(
    @SerializedName("data")
    val `data`: List<Data> = listOf(),
    @SerializedName("code")
    val code: Int = 0
)

data class Data(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("url")
    val url: String = "",
    @SerializedName("br")
    val br: Int = 0,
    @SerializedName("size")
    val size: Int = 0,
    @SerializedName("md5")
    val md5: String = "",
    @SerializedName("code")
    val code: Int = 0,
    @SerializedName("expi")
    val expi: Int = 0,
    @SerializedName("type")
    val type: String = "",
    @SerializedName("gain")
    val gain: Int = 0,
    @SerializedName("fee")
    val fee: Int = 0,
    @SerializedName("uf")
    val uf: Any? = null,
    @SerializedName("payed")
    val payed: Int = 0,
    @SerializedName("flag")
    val flag: Int = 0,
    @SerializedName("canExtend")
    val canExtend: Boolean = false,
    @SerializedName("freeTrialInfo")
    val freeTrialInfo: Any? = null,
    @SerializedName("level")
    val level: String = "",
    @SerializedName("encodeType")
    val encodeType: String = "",
//    @SerializedName("freeTrialPrivilege")
//    val freeTrialPrivilege: FreeTrialPrivilege = FreeTrialPrivilege(),
    @SerializedName("urlSource")
    val urlSource: Int = 0
)
//
//data class FreeTrialPrivilege(
//    @SerializedName("resConsumable")
//    val resConsumable: Boolean = false,
//    @SerializedName("userConsumable")
//    val userConsumable: Boolean = false
//)

interface SongApi {
    @GET("/song/url")
    suspend fun fetchUrl(id: String): Song

    companion object : SongApi by BaseNetwork()
}

class MediaService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


}