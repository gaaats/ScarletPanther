package com.superking.parchisi.stare.maaaaainaanclaa

import android.app.Application
import android.content.Context
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import com.superking.parchisi.stare.modullles.appModule
import com.superking.parchisi.stare.modullles.viewModelModule
import io.branch.referral.Branch
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level

class MaiinnClaaaaasss:Application() {

    companion object {
        const val ONESIGNAL_APP_ID = "7f7b2711-099e-426f-830d-41946aaa1cf3"
        val myId: String = "myID"
        var instId: String? = "instID"
        var urlMain: String = "link"
        var MAIN_ID: String? = "main_id"
        var aps_id: String? = "main_id"
        var C1: String? = "c11"
        const val myTrId = ""
        val appsCheckChe: String = "appsCheckChe"
        val geoCo: String = "geoCo"
        //        val userCo: String = "userCo"
        val codeCode: String = "uff"
        val deepL: String = "deepL"
        var AIR_BALANCE = 500
        var defaultValue = "null"
    }

    override fun onCreate() {
        super.onCreate()
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)

        Branch.enableTestMode()

        // Branch object initialization
        Branch.getAutoInstance(this)

        //Kochava init
//        Tracker.getInstance().startWithAppGuid(applicationContext, "kojoy-of-iridescence-w9gx2r")


        val shP = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val settings = getSharedPreferences("PREFS_NAME", 0)

        val trackerParams = MyTracker.getTrackerParams()
        val trackerConfig = MyTracker.getTrackerConfig()

        val instID = MyTracker.getInstanceId(this)
        trackerConfig.isTrackingLaunchEnabled = true



        if (settings.getBoolean("my_first_time", true)) {

            shP.edit().putString(instId, instID).apply()
            settings.edit().putBoolean("my_first_time", false).apply()
        } else {
        }
        MyTracker.initTracker("59348317638920812849", this)

        GlobalContext.startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MaiinnClaaaaasss)
            modules(
                listOf(
                    viewModelModule, appModule
                )
            )
        }
    }
}