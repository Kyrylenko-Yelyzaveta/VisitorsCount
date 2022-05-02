package com.example.visitorscounter.presentor

interface IMainPresenter {
    fun checkFirstRun(): Boolean
    fun saveToShPref( name: String, data: String)
    fun getFromShared(name: String):String
    fun saveBooleanToShared(mean:Boolean)
    fun getFirebaseData()

}