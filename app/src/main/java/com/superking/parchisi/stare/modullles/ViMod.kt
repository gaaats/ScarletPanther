package com.superking.parchisi.stare.modullles

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsflyer.AFInAppEventParameterName
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.facebook.applinks.AppLinkData
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.google.firebase.analytics.FirebaseAnalytics
import io.branch.referral.util.BRANCH_STANDARD_EVENT
import io.branch.referral.util.BranchEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ViMod(
    private val mainRepository: CountryRepo,
    private val devRepo: DevRepo,
    private val shP: SharedPreferences,
    val application: Application
) : ViewModel() {


    private val gtgtggt = MutableLiveData<GeoDev>()
    val ggtgtgtgtthyhy: LiveData<GeoDev>
        get() = gtgtggt


    private val _appsDataaaaaaa56d56 = MutableLiveData<String>()
    val appsDatagtgt65tggt: LiveData<String>
        get() = _appsDataaaaaaa56d56

    private val _deepSfrrf56fr5fr5 = MutableLiveData<String>()
    val deepS: LiveData<String>
        get() = _deepSfrrf56fr5fr5

    suspend fun getDataaaaaaaa() {
        fr5rf5rf5.postValue(mainRepository.getDattttttttt().body())
        getDevDataaaaaaaaaa()
    }

    suspend fun getDevDataaaaaaaaaa() {
        gtgtggt.postValue(devRepo.getDataDevvvvvvvv().body())
    }



    private val gttggt5gt5tg = MutableLiveData<CountryCodeJS>()
    val data: LiveData<CountryCodeJS>
        get() = gttggt5gt5tg


    private val fr5rf5rf5 = MutableLiveData<CountryCodeJS>()
    val countryCodefrfrrfrffr6: LiveData<CountryCodeJS>
        get() = fr5rf5rf5


    private val _mainIddededdeeded = MutableLiveData<String?>()
    val frrfrffrfrrf: LiveData<String?>
        get() = _mainIddededdeeded


    fun converssssssss(cont: Context) {
        AppsFlyerLib.getInstance()
            .init("GNQRSAy2kEDzbcasnQ5jEF", gtjtgigtjgtjgtjijgtijgtjig, application)
        AppsFlyerLib.getInstance().start(cont)
    }


    fun gtjjgtgtjjgtijgtjigt() {
        val vbghgthgthhgt = AdvertisingIdClient(application)
        vbghgthgthhgt.start()
        val gjjgtijigtjjgtjgt = vbghgthgthhgt.info.id.toString()
        _mainIddededdeeded.postValue(gjjgtijigtjjgtjgt)
    }

    fun fbDeeeeeeeee(cont: Context) {
        AppLinkData.fetchDeferredAppLinkData(
            cont
        ) { data: AppLinkData? ->
            data?.let {
                val deepDataaaaaaaaa = data.targetUri?.host.toString()
                shP.edit().putString("deepSt", deepDataaaaaaaaa).apply()
            }
        }
    }

    private val gtjtgigtjgtjgtjijgtijgtjig = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val ggtgtgtgtgt = data?.get("campaign").toString()
            _appsDataaaaaaa56d56.postValue(ggtgtgtgtgt)

            val hyhjuujjujuju = Bundle()
            val instanceeeeeeee = FirebaseAnalytics.getInstance(application.applicationContext)
            var strtrrrrrrrr = "opened_firstly"


            when (data?.get(AFInAppEventParameterName.AF_CHANNEL).toString()) {
                "ACI_Search" -> {
                    BranchEvent(BRANCH_STANDARD_EVENT.ACHIEVE_LEVEL).setDescription("ACI_Search").logEvent(application.applicationContext)
                    strtrrrrrrrr = "first_open_s"
                    instanceeeeeeee.logEvent(strtrrrrrrrr, hyhjuujjujuju)
//                    Event.buildWithEventName("ACI_Search").send()

//                    Event.buildWithEventType(EventType.ACHIEVEMENT)
//                        .setName("ACI_Search").send()
                }
                "ACI_Youtube" -> {
                    BranchEvent(BRANCH_STANDARD_EVENT.SHARE).setDescription("ACI_Youtube").logEvent(application.applicationContext)
                    strtrrrrrrrr = "first_open_y"
                    instanceeeeeeee.logEvent(strtrrrrrrrr, hyhjuujjujuju)

//                    Event.buildWithEventType(EventType.SEARCH)
//                        .setName("ACI_Youtube").send()
                }
                "ACI_Display" -> {
                    BranchEvent(BRANCH_STANDARD_EVENT.RATE).setDescription("ACI_Display").logEvent(application.applicationContext)
                    strtrrrrrrrr = "first_open_d"
                    instanceeeeeeee.logEvent(strtrrrrrrrr, hyhjuujjujuju)
//                    Event.buildWithEventType(EventType.RATING)
//                        .setName("ACI_Display").send()
                }

                else ->{
//                    Event.buildWithEventType(EventType.AD_VIEW)
//                        .setName("NoChannel").send()

                    BranchEvent(BRANCH_STANDARD_EVENT.VIEW_AD).setDescription("NoChannel").logEvent(application.applicationContext)
                }

            }

            instanceeeeeeee.logEvent(strtrrrrrrrr, hyhjuujjujuju)
        }

        override fun onConversionDataFail(error: String?) {
        }

        override fun onAppOpenAttribution(data: MutableMap<String, String>?) {

        }

        override fun onAttributionFailure(error: String?) {
        }
    }



    init {
        viewModelScope.launch(Dispatchers.IO) {
            gtjjgtgtjjgtijgtjigt()
        }
        viewModelScope.launch(Dispatchers.Main) {
            getDataaaaaaaa()
        }
    }

}