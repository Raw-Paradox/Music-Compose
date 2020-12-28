package com.cyb.musicplayer.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import com.cyb.musicplayer.playlistdetail.PlaylistDetailActivity
import com.cyb.musicplayer.service.GlobalViewModel
import com.cyb.musicplayer.ui.CurrentSong
import com.cyb.musicplayer.ui.GenericsScreen
import com.cyb.musicplayer.ui.MusicPlayerTheme
import com.cyb.musicplayer.ui.map

class MainActivity : AppCompatActivity() {
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        setContent {
            MusicPlayerTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MainScreen(
                        GlobalViewModel.uid,
                        mainViewModel,
                        intent.getStringExtra("icon") ?: "Home"
                    )
                }
            }
        }
    }
}

@Composable
fun Context.MainScreen(uid: String, viewModel: MainViewModel, activeIcon: String) {
    var icon by remember { mutableStateOf(activeIcon) }
    viewModel.fetchPlayList(uid)
    val playlists by viewModel.playLists.observeAsState(listOf())
    GenericsScreen(
        activeIcon = map[icon] ?: error(""),
        onClick = { icon = it },
    ) { modifier ->
        when (icon) {
            "Home" -> HomePage(modifier, playlists) {
                run {
                    Intent(this, PlaylistDetailActivity::class.java)
                        .apply {
                            putExtra("id", it)
                            putExtra("icon", icon)
                        }.let {
                            startActivity(it)
                        }
                }
            }
            "Search" -> SearchPage(modifier)
            "Library" -> LibraryPage(modifier)
        }
    }
//    Scaffold(
//        bottomBar = {
//            BottomAppBar(backgroundColor = Color.White, elevation = 3.dp) {
//                BottomBar(activeIcon = icon, onClick = { icon = it })
//            }
//        }
//    ) {
//        when (icon) {
//            Icons.Filled.Home -> HomePage(playlists) {
//                run {
//                    Intent(this, PlaylistDetailActivity::class.java)
//                        .apply {
//                            putExtra("id", it)
//                        }.let {
//                            startActivity(it)
//                        }
//                }
//            }
//            Icons.Filled.Search -> SearchPage()
//            Icons.Filled.LibraryBooks -> LibraryPage()
//        }
//    }
}

