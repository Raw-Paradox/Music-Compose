package com.cyb.musicplayer.ui

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.cyb.musicplayer.playlistdetail.Track
import com.cyb.musicplayer.service.GlobalViewModel
import com.cyb.musicplayer.util.quickLog

/**
 * Created by Paradoox on 2020/12/27.
 */

fun Context.loadImg(
    url: String,
//    @DrawableRes defaultImage: Int
): MutableState<Bitmap?> {
    quickLog("loadImg:$url")
    val bitmapState: MutableState<Bitmap?> = mutableStateOf(null)
    Glide.with(this)
        .asBitmap()
        .load(url)
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapState.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {
            }
        })
    return bitmapState
}

@Composable
fun AsyncNetworkImage(
    modifier: Modifier = Modifier,
    url: String
) {
    val img by AmbientContext.current.loadImg(url)
    img?.let {
        Image(modifier = modifier, bitmap = it.asImageBitmap())
    }
}

@Composable
fun Context.GenericsScreen(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit = {},
    activeIcon: ImageVector,
    onClick: (String) -> Unit,
    content: @Composable (Modifier) -> Unit
) {
    Scaffold(
        modifier,
        topBar = { topBar() },
        bottomBar = {
            BottomAppBar(backgroundColor = Color.White) { BottomBar(activeIcon, onClick) }
        },
        bodyContent = {
            Column(Modifier.padding(bottom = 58.dp).background(Color.Green)) {
                content(Modifier)
                val currentSong by GlobalViewModel.observeCurrentSong()
                currentSong?.let {
                    CurrentSong(
//                        Modifier.height(70.dp),
                        data = it,
                        onClick = {},
                        isPlaying = false,
                        buttonOnClick = {}
                    )
                }
            }
        }
    )
}

@Composable
fun CurrentSong(
    modifier: Modifier = Modifier,
    data: Track,
    onClick: (id: String) -> Unit,
    isPlaying: Boolean,
    buttonOnClick: () -> Unit
) {
    Row(
        modifier = modifier.clickable(onClick = { onClick(data.id) }),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AsyncNetworkImage(modifier = Modifier.size(70.dp), url = data.al.picUrl)
        Column(
            modifier = Modifier.padding(start = 10.dp).weight(1f),
        ) {
            Text(
                data.name,
                fontWeight = FontWeight.Black,
                fontSize = 17.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Providers(AmbientContentAlpha provides ContentAlpha.medium) {
                Text(data.ar[0].name, style = MaterialTheme.typography.body2)
            }
        }
        IconButton(
            buttonOnClick,
            Modifier.fillMaxHeight().width(30.dp).padding(start = 10.dp)
        ) {
            Icon(if (isPlaying) Icons.Filled.Pause else Icons.Filled.PlayArrow)
        }
    }
}

val map = mapOf(
    "Home" to Icons.Filled.Home,
    "Search" to Icons.Filled.Search,
    "Library" to Icons.Filled.LibraryBooks
)

@Composable
fun BottomBar(activeIcon: ImageVector, onClick: (String) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 45.dp)
            .padding(vertical = 7.dp)
            .preferredHeight(50.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val activeModifier = Modifier.clip(CircleShape).background(purple200)
        for (pair in map) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    pair.value,
                    Modifier.preferredSize(50.dp)
                        .weight(1f)
                        .then(if (pair.value == activeIcon) activeModifier else Modifier)
                        .clickable(onClick = { onClick(pair.key) }),
                )
                Text(
                    pair.key,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace
                )
            }
        }
    }
}