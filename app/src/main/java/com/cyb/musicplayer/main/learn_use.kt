package com.cyb.musicplayer.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlin.math.max

/**
 * Created by Paradoox on 2020/12/25.
 */

@Composable
fun Card1() {
    Row {
        Surface(
            modifier = Modifier.preferredSize(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(0.2f)
        ) {

        }

        Column(
            modifier = Modifier.padding(start = 20.dp)
                .align(Alignment.CenterVertically)
                .clip(RoundedCornerShape(4.dp))
                .clickable(onClick = {}),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("hello world", fontWeight = FontWeight.Bold)
            Providers(AmbientContentAlpha provides ContentAlpha.medium) {
                Text(
                    "another hello world",
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

fun Modifier.firstBaselineToTop(para: Int) = Modifier.layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
    // placeable[FirstBaseline] is the distance from FirstBaseline to the top of placeable
    // itself measured in pixel
    val posY = para.dp.toIntPx() - placeable[FirstBaseline]
    layout(placeable.width, posY + placeable.height) {
        placeable.placeRelative(0, posY)
    }
}

@Composable
fun MyRow(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(modifier = modifier, content = content) { measurables, constraints ->
        val placeables = measurables.map { it.measure(constraints) }
        val height = placeables.maxOf { it.height }
        val width = placeables.sumBy { it.width }
        layout(width, height) {
            var accumulated = 0
            for (placeable in placeables) {
                placeable.placeRelative(accumulated, 0)
                accumulated += placeable.width
            }
        }
    }
}

@Composable
fun MyColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(modifier = modifier, content = content) { measurables, constraints ->
        val placeables = measurables.map { it.measure(constraints) }
        val height = placeables.sumOf { it.height }
        val width = placeables.maxOf { it.width }
        layout(width, height) {
            var accumulated = 0
            for (placeable in placeables) {
                placeable.placeRelative(0, accumulated)
                accumulated += placeable.height
            }
        }
    }
}

@Composable
fun StaggeredGrid(
    modifier: Modifier = Modifier,
    rows: Int,
    content: @Composable () -> Unit
) {
    Layout(content = content, modifier = modifier) { measurables, constraints ->
        val rowWidths = IntArray(rows) { 0 }
        val maxHeights = IntArray(rows) { 0 }
        val placeables = measurables.mapIndexed { index, measurable ->
            val placeable = measurable.measure(constraints)
            val row = index % rows
            rowWidths[row] += placeable.width
            maxHeights[row] = max(maxHeights[row], placeable.height)
            placeable
        }
        val width = rowWidths.maxOrNull()?.coerceIn(constraints.minWidth, constraints.maxWidth)
            ?: constraints.minWidth
        val height = maxHeights.sum().coerceIn(constraints.minHeight, constraints.maxHeight)
        val rowY = IntArray(rows) { 0 }
        for (i in 1 until rows) {
            rowY[i] = rowY[i - 1] + maxHeights[i - 1]
        }
        layout(width, height) {
            val rowAccum = IntArray(rows) { 0 }
            placeables.forEachIndexed { index, placeable ->
                val row = index % rows
                placeable.placeRelative(rowAccum[row], rowY[row])
                rowAccum[row] += placeable.width
            }
        }
    }
}
