package com.cyb.musicplayer.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyb.musicplayer.ui.AsyncNetworkImage
import com.cyb.musicplayer.ui.purple200


/**
 * Created by Paradoox on 2020/12/25.
 */

@Composable
fun HomePage(modifier: Modifier = Modifier, list: List<Playlist>, onClick: (id: String) -> Unit) {
    LazyColumn(
        modifier = modifier.padding(top = 20.dp)
            .padding(horizontal = 15.dp)
            .wrapContentHeight()
    ) {
        items(list) {
            PlaylistItem(Modifier.fillMaxWidth().padding(vertical = 5.dp), it, onClick)
        }
    }
}

@Composable
fun PlaylistItem(
    modifier: Modifier = Modifier,
    data: Playlist,
    onClick: (id: String) -> Unit,
) {
    Card(
        modifier.clickable(onClick = { onClick(data.id) }),
        shape = RoundedCornerShape(10.dp),
        elevation = 2.dp,
        border = BorderStroke(3.dp, Color.LightGray),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncNetworkImage(url = data.coverImgUrl, modifier = Modifier.size(70.dp))
            Text(
                text = data.name,
                modifier = Modifier.padding(start = 5.dp),
                fontWeight = FontWeight.Black,
                fontSize = 17.sp
            )
        }
    }
}

@Composable
fun SearchPage(modifier: Modifier = Modifier) {
    Column {
        LazyColumn(Modifier.wrapContentHeight()) {
            items(listOf("test1", "test2", "test3")) {
                Text(it)
            }
        }
        Text("hhhh")
    }
}

@Composable
fun LibraryPage(modifier: Modifier = Modifier) {

}

@Composable
fun BottomBar(activeIcon: ImageVector, onClick: (ImageVector) -> Unit) {
    val map = mapOf(
        Icons.Filled.Home to "Home",
        Icons.Filled.Search to "Search",
        Icons.Filled.LibraryBooks to "Library"
    )
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 45.dp)
            .padding(vertical = 7.dp)
            .preferredHeight(50.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val activeModifier = Modifier.clip(CircleShape).background(purple200)
        for (icon in map.keys) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    icon,
                    Modifier.preferredSize(50.dp)
                        .weight(1f)
                        .then(if (icon == activeIcon) activeModifier else Modifier)
                        .clickable(onClick = { onClick(icon) }),
                )
                Text(
                    map.getOrDefault(icon, ""),
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace
                )
            }
        }
    }
}

