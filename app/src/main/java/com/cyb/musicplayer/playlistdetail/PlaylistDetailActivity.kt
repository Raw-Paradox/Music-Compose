package com.cyb.musicplayer.playlistdetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.setContent
import com.cyb.musicplayer.main.MainActivity
import com.cyb.musicplayer.service.GlobalViewModel
import com.cyb.musicplayer.ui.GenericsScreen
import com.cyb.musicplayer.ui.MusicPlayerTheme
import com.cyb.musicplayer.ui.map

class PlaylistDetailActivity : AppCompatActivity() {
    private val detailViewModel by viewModels<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicPlayerTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    DetailScreen(
                        intent.getStringExtra("id")!!,
                        intent.getStringExtra("icon")!!,
                        detailViewModel
                    )
                }
            }
        }
    }
}

@Composable
fun Context.DetailScreen(
    id: String,
    icon: String,
    viewModel: DetailViewModel
) {
    viewModel.fetchDetail(id)
    val playlist by viewModel.playlist.observeAsState(null)
    GenericsScreen(
        activeIcon = map[icon] ?: error(""),
        onClick = {
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("icon", it)
            }
            startActivity(intent)
        },
    ) { modifier ->
        playlist?.let { DetailContent(playlist = it) }
    }
}