package com.cyb.musicplayer.util

import android.content.Context
import android.util.Log
import android.widget.Toast
import java.security.MessageDigest

/**
 * Created by Paradoox on 2020/12/23.
 */

fun Context.showMsg(msg: String) =
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

private const val TAG = "QUICKLOG"
fun quickLog(msg: String) = Log.e(TAG, msg)

fun String.md5(): String = MessageDigest.getInstance("MD5")
    .digest(toByteArray(Charsets.UTF_8))
    .joinToString("") { "%02x".format(it) }