package com.superking.parchisi.stare.modullles

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
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

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getAdvertisingIdClient()
        }
        viewModelScope.launch(Dispatchers.Main) {
            getData()
        }
    }


    private val _data = MutableLiveData<CountryCodeJS>()
    val data: LiveData<CountryCodeJS>
        get() = _data


    private val _countryCode = MutableLiveData<CountryCodeJS>()
    val countryCode: LiveData<CountryCodeJS>
        get() = _countryCode

    private val _geo = MutableLiveData<GeoDev>()
    val geo: LiveData<GeoDev>
        get() = _geo


    private val _appsData = MutableLiveData<String>()
    val appsData: LiveData<String>
        get() = _appsData

    private val _deepS = MutableLiveData<String>()
    val deepS: LiveData<String>
        get() = _deepS


    private val _mainId = MutableLiveData<String?>()
    val mainId: LiveData<String?>
        get() = _mainId

    suspend fun getData() {
        _countryCode.postValue(mainRepository.getDat().body())
        getDevData()
    }

    suspend fun getDevData() {
        _geo.postValue(devRepo.getDataDev().body())
    }

    fun convers(cont: Context) {
        AppsFlyerLib.getInstance()
            .init("GNQRSAy2kEDzbcasnQ5jEF", conversionDataListener, application)
        AppsFlyerLib.getInstance().start(cont)
    }

    fun fbDeee(cont: Context) {
        AppLinkData.fetchDeferredAppLinkData(
            cont
        ) { data: AppLinkData? ->
            data?.let {
                val deepData = data.targetUri?.host.toString()
                shP.edit().putString("deepSt", deepData).apply()
            }
        }
    }

    private val conversionDataListener = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val dataGotten = data?.get("campaign").toString()
            _appsData.postValue(dataGotten)

            val bundle = Bundle()
            val instance = FirebaseAnalytics.getInstance(application.applicationContext)
            var str = "opened_firstly"

            Log.d("lolo", "AFInAppEventParameterName ${data?.get(AFInAppEventParameterName.AF_CHANNEL).toString()}")

            when (data?.get(AFInAppEventParameterName.AF_CHANNEL).toString()) {
                "ACI_Search" -> {
                    Log.d("lolo", "ACI_Search")
                    BranchEvent(BRANCH_STANDARD_EVENT.ACHIEVE_LEVEL).setDescription("ACI_Search").logEvent(application.applicationContext)
                    str = "first_open_s"
                    instance.logEvent(str, bundle)
//                    Event.buildWithEventName("ACI_Search").send()

//                    Event.buildWithEventType(EventType.ACHIEVEMENT)
//                        .setName("ACI_Search").send()
                }
                "ACI_Youtube" -> {
                    Log.d("lolo", "ACI_Youtube")
                    BranchEvent(BRANCH_STANDARD_EVENT.SHARE).setDescription("ACI_Youtube").logEvent(application.applicationContext)
                    str = "first_open_y"
                    instance.logEvent(str, bundle)

//                    Event.buildWithEventType(EventType.SEARCH)
//                        .setName("ACI_Youtube").send()
                }
                "ACI_Display" -> {
                    Log.d("lolo", "ACI_Display")
                    BranchEvent(BRANCH_STANDARD_EVENT.RATE).setDescription("ACI_Display").logEvent(application.applicationContext)
                    str = "first_open_d"
                    instance.logEvent(str, bundle)
//                    Event.buildWithEventType(EventType.RATING)
//                        .setName("ACI_Display").send()
                }

                else ->{
                    Log.d("lolo", "ACI_else")
//                    Event.buildWithEventType(EventType.AD_VIEW)
//                        .setName("NoChannel").send()

                    BranchEvent(BRANCH_STANDARD_EVENT.VIEW_AD).setDescription("NoChannel").logEvent(application.applicationContext)
                }

            }

            instance.logEvent(str, bundle)
        }

        override fun onConversionDataFail(error: String?) {
        }

        override fun onAppOpenAttribution(data: MutableMap<String, String>?) {

        }

        override fun onAttributionFailure(error: String?) {
        }
    }


    fun getAdvertisingIdClient() {
        val advertisingIdClient = AdvertisingIdClient(application)
        advertisingIdClient.start()
        val idUserAdvertising = advertisingIdClient.info.id.toString()
        _mainId.postValue(idUserAdvertising)
    }

}