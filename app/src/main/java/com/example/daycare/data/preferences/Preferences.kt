package com.example.daycare.data.preferences

import android.content.Context
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class Preferences @Inject constructor(@ApplicationContext context: Context){
    private val tokenKey = "token"
    private val PREF_BUFFER_PACKAGE_NAME = "com.example.daycare.data.preferences"

    private val reader by lazy { context.getSharedPreferences(PREF_BUFFER_PACKAGE_NAME,Context.MODE_PRIVATE) }

    fun writeToken(token:String){
        reader
            .edit()
            .putString(tokenKey,token)
            .apply()
    }

    fun getToken():String{
        //return reader.getString(tokenKey,"")!!
        val token="223c7a1016a5f9c9737b27d22c156196c81e728d9d4c2f636f067f89cc14862c4d6a5d012215bc7da184c6fe1e7b7b14"
        return token
    }
}