package com.superking.parchisi.stare.maaaaainaanclaa

import android.app.Application
import android.content.Context
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import com.superking.parchisi.stare.modullles.appModulefrrffrrf
import com.superking.parchisi.stare.modullles.viewModelModule
import io.branch.referral.Branch
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level

class MaiinnClaaaaasss : Application() {

    companion object {

        val deepLlllll: String = "deepL"
        var AIR_BALANCEfrrfrfrf = 500
        var defaultValueeeeeee = "null"
        var instIdfrfrf: String? = "instID"
        var urlMainfrrffr: String = "link"
        const val ONESIGNAL_APP_IDrrffrrf = "7f7b2711-099e-426f-830d-41946aaa1cf3"
        val myIdfrrrfrf: String = "myID"
        var MAIN_IDfrrfrf: String? = "main_id"
        var aps_idddddd: String? = "main_id"
        var C1frrfrf: String? = "c11"
        const val myTrIdfrfrrf = ""
        val appsCheckChefrfrfrf: String = "appsCheckChe"
        val geoCoffffff: String = "geoCo"

        //        val userCo: String = "userCo"
        val codeCodeeeeeee: String = "uff"

    }

    override fun onCreate() {
        super.onCreate()
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_IDrrffrrf)

        Branch.enableTestMode()

        // Branch object initialization
        Branch.getAutoInstance(this)

        //Kochava init
//        Tracker.getInstance().startWithAppGuid(applicationContext, "kojoy-of-iridescence-w9gx2r")


        val frrfrfrffrrf = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val settingssssssss = getSharedPreferences("PREFS_NAME", 0)

        val trackerParamsssssss = MyTracker.getTrackerParams()
        val trackerConfigfrfrfrffr = MyTracker.getTrackerConfig()

        val instIDsdddd = MyTracker.getInstanceId(this)
        trackerConfigfrfrfrffr.isTrackingLaunchEnabled = true


        if (settingssssssss.getBoolean("my_first_time", true)) {

            frrfrfrffrrf.edit().putString(instIdfrfrf, instIDsdddd).apply()
            settingssssssss.edit().putBoolean("my_first_time", false).apply()
        } else {

        }
        MyTracker.initTracker("59348317638920812849", this)

        GlobalContext.startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MaiinnClaaaaasss)
            modules(
                listOf(
                    viewModelModule, appModulefrrffrrf
                )
            )
        }
    }
}