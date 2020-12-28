package com.cyb.musicplayer.service

import android.os.Looper
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.MutableLiveData
import com.cyb.musicplayer.playlistdetail.Track

/**
 * Created by Paradoox on 2020/12/27.
 */

object GlobalViewModel {
    var uid = ""
    private val currentSong = MutableLiveData<Track?>(null)
    private val songQueue = mutableListOf<Track>()
    private var pos = 0

    @Composable
    fun observeCurrentSong(): State<Track?> = currentSong.observeAsState(null)

    fun set(tracks: List<Track>, index: Int) {
        songQueue.apply {
            clear()
            addAll(tracks)
        }
        pos = index
        if (Looper.getMainLooper().isCurrentThread) {
            currentSong.value = songQueue[pos]
        } else {
            currentSong.postValue(songQueue[pos])
        }
    }

    fun nextUp() {
        val next = if (pos + 1 < songQueue.size) songQueue[++pos] else null
        if (Looper.getMainLooper().isCurrentThread) {
            currentSong.value = next
        } else {
            currentSong.postValue(next)
        }
    }

    fun previous() {
        val next = if (pos > 0) songQueue[--pos] else null
        if (Looper.getMainLooper().isCurrentThread) {
            currentSong.value = next
        } else {
            currentSong.postValue(next)
        }
    }
}