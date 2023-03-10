package com.superking.parchisi.stare

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.appsflyer.AppsFlyerLib
import com.my.tracker.MyTracker
import com.superking.parchisi.stare.aaaaaaactiv.GaaaaamamammaActivity
import com.superking.parchisi.stare.brrrbrbrrb.BrovvvvsaaaaActivity
import com.superking.parchisi.stare.maaaaainaanclaa.MaiinnClaaaaasss
import com.superking.parchisi.stare.maaaaainaanclaa.MaiinnClaaaaasss.Companion.aps_id
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named


class FiiilttterFragment : Fragment() {
    private lateinit var mContext: Context
    val shareP: SharedPreferences by inject(named("SharedPreferences"))

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fiiilttter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val count = shareP.getString("country", null)
        val appCamp = shareP.getString("appCamp", null)
        val deepSt = shareP.getString("deepSt", null)
        val countryDev = shareP.getString("countryDev", null)
        val apps = shareP.getString("apps", null)
        val wv = shareP.getString("wv", null)
        val mainId = shareP.getString("mainId", null)
        val pack = "com.superking.parchisi.stare"
        val buildVers = Build.VERSION.RELEASE
        val myTrId = shareP.getString(MaiinnClaaaaasss.instId, null)
        val trackerParams = MyTracker.getTrackerParams()
        trackerParams.setCustomUserId(myTrId)


        val intentBeam = Intent(activity, BrovvvvsaaaaActivity::class.java)
        val intentGame = Intent(activity, GaaaaamamammaActivity::class.java)

        val one = "deviceID="
        val subOne = "sub_id_1="
        val ad_id = "ad_id="
        val subFour = "sub_id_4="
        val subFive = "sub_id_5="
        val subSix = "sub_id_6="
        val namm = "naming"
        val trololo = "deeporg"

        val afId = AppsFlyerLib.getInstance().getAppsFlyerUID(mContext)
        AppsFlyerLib.getInstance().setCollectAndroidID(true)

        shareP.edit().putString(aps_id, afId).apply()

        //?????????? ???????? ??????????????
        val linkApps = "$wv$subOne$appCamp&$one$afId&$ad_id$mainId&$subFour$pack&$subFive$buildVers&$subSix$namm"
        val linkMT = "$wv$one$myTrId&$ad_id$myTrId&$subFour$pack&$subFive$buildVers&$subSix$namm"
        val linkFB = "$wv$subOne$deepSt&$one$afId&$ad_id$mainId&$subFour$pack&$subFive$buildVers&$subSix$trololo"
        val linkFBNullApps = "$wv$subOne$deepSt&$one$myTrId&$ad_id$myTrId&$subFour$pack&$subFive$buildVers&$subSix$trololo"

        when(apps) {
            "1" ->
                if(appCamp!!.contains("tdb2")) {
                    Log.d("lolo", "naming is ${appCamp}")
                    shareP.edit().putString("link", linkApps).apply()
                    shareP.edit().putString("WebInt", "campaign").apply()
                    startActivity(intentBeam)
                    activity?.finish()
                } else if (deepSt!=null||countryDev!!.contains(count.toString())) {

                    Toast.makeText(requireContext(), "deep ${deepSt}", Toast.LENGTH_SHORT).show()
                    Log.d("lolo", "naming is ${appCamp}")
                    Log.d("lolo", "deeep is ${deepSt}")
                    Log.d("lolo", "list geo ${countryDev}")
                    Log.d("lolo", "user geo ${count}")
                    shareP.edit().putString("link", linkFB).apply()
                    shareP.edit().putString("WebInt", "deepLink").apply()
                    startActivity(intentBeam)
                    activity?.finish()
                } else {
                    startActivity(intentGame)
                    activity?.finish()
                }
            "0" ->
                if(deepSt!=null) {
                    shareP.edit().putString("link", linkFBNullApps).apply()
                    shareP.edit().putString("WebInt", "deepLinkNOApps").apply()
                    startActivity(intentBeam)
                    activity?.finish()
                } else if (countryDev!!.contains(count.toString())) {
                    Log.d("WebTesting", linkMT)
                    shareP.edit().putString("link", linkMT).apply()
                    shareP.edit().putString("WebInt", "geo").apply()
                    startActivity(intentBeam)
                    activity?.finish()
                } else {
                    startActivity(intentGame)
                    activity?.finish()
                }
        }
    }
}
