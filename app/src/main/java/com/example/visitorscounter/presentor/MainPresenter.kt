package com.example.visitorscounter.presentor

import android.content.Context
import android.util.Log
import com.example.visitorscounter.model.ResponseData

class MainPresenter(context: Context) : IMainPresenter {
    private var sharedPref = context.getSharedPreferences("BASE_SHARED_PREF", Context.MODE_PRIVATE)
    private var response = ResponseData()


    override fun getFirebaseData()
    {
        response.getHost { onResullt->
            saveToShPref("link", onResullt.link)
            saveToShPref("home",onResullt.home)



        }
    }

    override fun saveToShPref(name: String, data: String) {

        sharedPref.edit().putString(name, data).commit()
    }

    override fun saveBooleanToShared(mean: Boolean) {
        sharedPref.edit().putBoolean("firstRun", mean).commit()
    }

    override fun checkFirstRun(): Boolean {

        return sharedPref.getBoolean("firstRun", true)
    }

    override fun getFromShared(name: String): String {
        return sharedPref.getString(name, "")!!

    }

}