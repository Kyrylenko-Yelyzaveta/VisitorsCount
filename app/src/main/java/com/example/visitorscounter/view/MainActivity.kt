package com.example.visitorscounter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.visitorscounter.R
import com.example.visitorscounter.databinding.ActivityMainBinding
import com.example.visitorscounter.model.ResponseData
import com.example.visitorscounter.presentor.MainPresenter
import com.example.visitorscounter.view.const.Constants
import com.onesignal.OneSignal
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val appId = Constants.ONESIGNAL_APP_ID

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val presenter = MainPresenter(applicationContext)
        presenter.getFirebaseData()

        supportFragmentManager
            .beginTransaction().replace(R.id.place_holder, LoadingContent.newInstance())
            .commit()



        openContentFragment()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        OneSignal.initWithContext(this)
        OneSignal.setAppId(appId)

    }

    private fun openContentFragment() {
        val timer = object: CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) { }

            override fun onFinish() {
                supportFragmentManager
                .beginTransaction().replace(R.id.place_holder, MainContent.newInstance())
                .commit()}
        }
        timer.start()

    }


}