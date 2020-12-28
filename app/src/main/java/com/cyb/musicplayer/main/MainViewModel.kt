package com.cyb.musicplayer.main

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

interface MainApi {
    @GET("/user/playlist")
    suspend fun fetchPlayList(@Query("uid") uid: String): PlayLists

    companion object : MainApi by BaseNetwork()
}

class MainViewModel : ViewModel() {
    val playLists = MutableLiveData<List<Playlist>>()

    fun fetchPlayList(uid: String) {
        viewModelScope.launch(Dispatchers.IO) {
            playLists.postValue(MainApi.fetchPlayList(uid).playlist)
        }
    }
}