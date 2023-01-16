package com.superking.parchisi.stare.modullles

import android.app.Application
import android.content.pm.PackageManager
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.lifecycle.ViewModel
import com.onesignal.OneSignal
import org.json.JSONException
import org.json.JSONObject

class BeamModel(application: Application): ViewModel() {

    val pmfrrfrfrfrf = application.packageManager



    fun gtgtigtjijgtjgtgtigti(id: String) {
        OneSignal.setExternalUserId(
            id,
            object : OneSignal.OSExternalUserIdUpdateCompletionHandler {
                override fun onSuccess(results: JSONObject) {
                    try {
                        if (results.has("push") && results.getJSONObject("push").has("success")) {
                            val vbfvbfvbfbff = results.getJSONObject("push").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for push status: $vbfvbfvbfbff"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("email") && results.getJSONObject("email").has("success")) {
                            val gjtigjtgtijgtjigt =
                                results.getJSONObject("email").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for email status: $gjtigjtgtijgtjigt"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("sms") && results.getJSONObject("sms").has("success")) {
                            val gjtjitgjgtgtj = results.getJSONObject("sms").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for sms status: $gjtjitgjgtgtj"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

                override fun onFailure(error: OneSignal.ExternalIdError) {
                    OneSignal.onesignalLog(
                        OneSignal.LOG_LEVEL.VERBOSE,
                        "Set external user id done with error: $error"
                    )
                }
            })
    }



    fun hyhyjyjhijyhihyjhy(uri: String): Boolean {
        try {
            pmfrrfrfrfrf.getPackageInfo("org.telegram.messenger", PackageManager.GET_ACTIVITIES)
            return true
        } catch (_: PackageManager.NameNotFoundException) {

        }
        return false
    }

    fun webSetfrrffrrfrfrf(webView: WebView): WebSettings{
        val webViewSetttttt = webView.settings
        webViewSetttttt.javaScriptEnabled = true
        webViewSetttttt.useWideViewPort = true
        webViewSetttttt.loadWithOverviewMode = true
        webViewSetttttt.allowFileAccess = true
        webViewSetttttt.domStorageEnabled = true
        webViewSetttttt.userAgentString = webViewSetttttt.userAgentString.replace("; wv", "")
        webViewSetttttt.javaScriptCanOpenWindowsAutomatically = true
        webViewSetttttt.setSupportMultipleWindows(false)
        webViewSetttttt.displayZoomControls = false
        webViewSetttttt.builtInZoomControls = true
        webViewSetttttt.allowFileAccess = true
        webViewSetttttt.allowContentAccess = true
        webViewSetttttt.setSupportZoom(true)
        webViewSetttttt.pluginState = WebSettings.PluginState.ON
        webViewSetttttt.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        webViewSetttttt.setAppCacheEnabled(true)
        webViewSetttttt.allowContentAccess = true
        webViewSetttttt.mediaPlaybackRequiresUserGesture = false

        return webViewSetttttt
    }
}