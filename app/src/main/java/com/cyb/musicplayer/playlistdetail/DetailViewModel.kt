package com.cyb.musicplayer.playlistdetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cyb.musicplayer.util.BaseNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Paradoox on 2020/12/25.
 */

interface DetailApi {
    @GET("/playlist/detail")
    suspend fun fetchDetail(@Query("id") id: String): DetailBean

    companion object : DetailApi by BaseNetwork()
}

class DetailViewModel : ViewModel() {
    val playlist = MutableLiveData<Playlist>(null)

    fun fetchDetail(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            playlist.postValue(DetailApi.fetchDetail(id).playlist)
        }
    }
}