package com.cyb.musicplayer.login


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cyb.musicplayer.util.BaseNetwork
import com.cyb.musicplayer.util.md5
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Paradoox on 2020/12/23.
 */

interface LoginApi {
    @GET("/login/cellphone")
    suspend fun login(
        @Query("phone") username: String,
        @Query("md5_password") password: String
    ): LoginBean

    companion object : LoginApi by BaseNetwork()
}

class LoginViewModel : ViewModel() {
    val loginBean = MutableLiveData<LoginBean>(null)

    fun login(username: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            loginBean.postValue(LoginApi.login(username, password.md5()))
        }
    }
}