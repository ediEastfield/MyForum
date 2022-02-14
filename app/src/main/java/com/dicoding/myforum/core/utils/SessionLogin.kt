package com.dicoding.myforum.core.utils

import android.content.Context
import com.dicoding.myforum.core.domain.model.DataLogin

internal class SessionLogin(context: Context) {

    companion object {
        private const val PREFS_NAME = "user_pref"
        private const val IS_LOGIN = "is_login"
        private const val REFRESH_TOKEN = "refresh_token"
        private const val ACCESS_TOKEN = "access_token"
    }

    private val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    private val editor = preferences.edit()

    fun setLogin(data: DataLogin) {
        editor.putBoolean(IS_LOGIN, true)
        editor.putString(REFRESH_TOKEN, data.refreshToken)
        editor.putString(ACCESS_TOKEN, data.accessToken)
        editor.commit()
    }

    fun isLogin(): Boolean {
        return preferences.getBoolean(IS_LOGIN, false)
    }

    fun getData(): DataLogin {
        val data = DataLogin("","")
        data.refreshToken = preferences.getString(REFRESH_TOKEN, "")
        data.accessToken = preferences.getString(ACCESS_TOKEN, "")

        return data
    }

    fun logout() {
        editor.clear()
        editor.commit()
    }
}