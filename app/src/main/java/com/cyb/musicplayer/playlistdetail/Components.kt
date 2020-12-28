package com.cyb.musicplayer.playlistdetail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.Providers
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyb.musicplayer.service.GlobalViewModel
import com.cyb.musicplayer.ui.AsyncNetworkImage

/**
 * Created by Paradoox on 2020/12/25.
 */

@Composable
fun DetailContent(
    modifier: Modifier = Modifier,
    playlist: Playlist
) {
    Column(modifier = modifier.padding(horizontal = 10.dp)) {
        SearchBar(modifier = Modifier.height(50.dp))
        LazyColumn(modifier = modifier.wrapContentHeight()) {
            item {
                Description(
                    url = playlist.coverImgUrl,
                    name = playlist.name,
                    creator = playlist.creator.nickname
                )
            }
            // TODO incomplete tracks, need to use track id to get song detail
            items(playlist.tracks) {
                TrackItem(
                    Modifier.padding(vertical = 5.dp).height(70.dp).fillMaxWidth(),
                    it
                ) { track ->
                    GlobalViewModel.set(playlist.tracks, playlist.tracks.indexOf(track))
                }
            }
        }
    }
//    quickLog(playlist.tracks.joinToString { it.name })
}

@Composable
fun Description(
    modifier: Modifier = Modifier,
    url: String,
    name: String,
    creator: String
) {
    Row(
        modifier = modifier.fillMaxWidth(),
    ) {
        AsyncNetworkImage(
            url = url,
            modifier = Modifier.height(150.dp).padding(bottom = 30.dp)
        )
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(start = 20.dp)
        ) {
            Text(name, fontSize = 40.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
            Providers(AmbientContentAlpha provides ContentAlpha.medium) {
                Text("BY $creator", fontSize = 20.sp, style = MaterialTheme.typography.body2)
            }
        }
    }

}

@Composable
fun TrackItem(
    modifier: Modifier = Modifier,
    data: Track,
    onClick: (Track) -> Unit
) {
    Row(
        modifier = modifier.clickable(onClick = { onClick(data) }),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AsyncNetworkImage(modifier = Modifier.size(70.dp), url = data.al.picUrl)
        Column(
            modifier = Modifier.padding(start = 10.dp).weight(1f),
        ) {
            Text(
                data.name,
                color = if (GlobalViewModel.observeCurrentSong().value == data) Color.Red else Color.Black,
                fontWeight = FontWeight.Black,
                fontSize = 17.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Providers(AmbientContentAlpha provides ContentAlpha.medium) {
                Text(data.ar[0].name, style = MaterialTheme.typography.body2)
            }
        }
// TODO Find a Heart Icon
//        Icon(Icons.Filled.Li)
        Icon(
            Icons.Filled.MoreVert,
            modifier = Modifier.fillMaxHeight().width(30.dp).padding(start = 10.dp)
        )
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    text: MutableState<String> = mutableStateOf(""),
    searching: MutableState<Boolean> = mutableStateOf(false),
) {
    if (!searching.value) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom
        ) {
            Icon(
                Icons.Filled.Search,
                modifier = Modifier.fillMaxSize()
                    .clickable(onClick = {
                        searching.value = true
                    })
            )
        }
    } else {

    }
}