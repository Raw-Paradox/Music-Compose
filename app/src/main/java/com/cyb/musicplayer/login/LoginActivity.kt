package com.cyb.musicplayer.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import com.cyb.musicplayer.main.MainActivity
import com.cyb.musicplayer.service.GlobalViewModel
import com.cyb.musicplayer.ui.MusicPlayerTheme
import com.cyb.musicplayer.util.quickLog
import com.cyb.musicplayer.util.showMsg


class LoginActivity : AppCompatActivity() {
    private val loginViewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicPlayerTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LoginScreen(loginViewModel)
                }
            }
        }
        loginViewModel.loginBean.observe(this) {
            it?.let {
                if (it.code == 200) {
                    val intent = Intent(this, MainActivity::class.java)
                    GlobalViewModel.uid = it.profile.userId
                    quickLog(it.profile.userId)
                    quickLog(GlobalViewModel.uid)
                    startActivity(intent)
                    finish()
                } else {
                    showMsg("Username or password incorrect")
                }
            }
        }
    }
}

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
//    val context = AmbientContext.current
    Scaffold(
        topBar = { TopAppBar(title = { Text("LOGIN") }) }
    ) {
        LoginScreenContent(loginAction = { username, password ->
            viewModel.login(username, password)
        })
    }
}