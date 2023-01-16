package com.superking.parchisi.stare.brrrbrbrrb


import android.provider.MediaStore
import android.util.Log
import android.webkit.*
import android.widget.Toast
import com.superking.parchisi.stare.databinding.ActivityBrovvvvsaaaaBinding
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.Looper
import com.superking.parchisi.stare.maaaaainaanclaa.MaiinnClaaaaasss
import com.superking.parchisi.stare.maaaaainaanclaa.MaiinnClaaaaasss.Companion.aps_idddddd
import com.superking.parchisi.stare.modullles.BeamModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class BrovvvvsaaaaActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBrovvvvsaaaaBinding = ActivityBrovvvvsaaaaBinding.inflate(layoutInflater)
        setContentView(activityBrovvvvsaaaaBinding.root)
        webViewfrrfrfrf = activityBrovvvvsaaaaBinding.webst
        CookieManager.getInstance().setAcceptCookie(true)
        CookieManager.getInstance().setAcceptThirdPartyCookies(webViewfrrfrfrf, true)
        frokrfko.webSetfrrffrrfrfrf(webViewfrrfrfrf)


        webViewfrrfrfrf.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
                try {
                    if (URLUtil.isNetworkUrl(url)) {
                        return false
                    }
                    if (frokrfko.hyhyjyjhijyhihyjhy(url)) {

                        val gtkgtkkgtkogt = Intent(Intent.ACTION_VIEW)
                        gtkgtkkgtkogt.data = Uri.parse(url)
                        startActivity(gtkgtkkgtkogt)
                    } else {

                        Toast.makeText(
                            applicationContext,
                            "Application is not installed",
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=org.telegram.messenger")
                            )
                        )
                    }
                    return true
                } catch (e: Exception) {
                    return false
                }
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                saveUrlaaaa(url)
            }


            override fun onReceivedError(
                view: WebView?,
                errorCode: Int,
                description: String?,
                failingUrl: String?
            ) {
                Toast.makeText(this@BrovvvvsaaaaActivity, description, Toast.LENGTH_SHORT).show()
            }
        }

        webViewfrrfrfrf.webChromeClient = ChromeClient()
        webViewfrrfrfrf.loadUrl(nvfbfdedfedfsddrsdrsdds())
    }

    private lateinit var activityBrovvvvsaaaaBinding: ActivityBrovvvvsaaaaBinding
    lateinit var webViewfrrfrfrf: WebView


    private var arrayValueCallback: ValueCallback<Array<Uri>>? = null
    private var ggtgtgtgtgttg: String? = null
    private val gtjiogtjoiggtjjgt = 1

    private val frokrfko by viewModel<BeamModel>(
        named("BeamModel")
    )

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode != gtjiogtjoiggtjjgt || arrayValueCallback == null) {
            super.onActivityResult(requestCode, resultCode, data)
            return
        }
        var results: Array<Uri>? = null

        if (resultCode == RESULT_OK) {
            if (data == null) {
                if (ggtgtgtgtgttg != null) {
                    results = arrayOf(Uri.parse(ggtgtgtgtgttg))
                }
            } else {
                val ggtgtgttggt = data.dataString
                if (ggtgtgttggt != null) {
                    results = arrayOf(Uri.parse(ggtgtgttggt))
                }
            }
        }
        arrayValueCallback!!.onReceiveValue(results)
        arrayValueCallback = null
        return
    }


    inner class ChromeClient : WebChromeClient() {

        override fun onShowFileChooser(
            view: WebView?,
            filePath: ValueCallback<Array<Uri>>?,
            fileChooserParams: FileChooserParams?
        ): Boolean {
            arrayValueCallback?.onReceiveValue(null)
            arrayValueCallback = filePath
            var gttggtgtfff5: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (gttggtgtfff5!!.resolveActivity(packageManager) != null) {
                var g5t5gg5t5gt: File? = null
                try {
                    g5t5gg5t5gt = gtjigthtghugtgthugt()
                    gttggtgtfff5.putExtra("PhotoPath", ggtgtgtgtgttg)
                } catch (ex: IOException) {
                    Log.e("ErrorOccurred", "Unable to create Image File", ex)
                }

                if (g5t5gg5t5gt != null) {
                    ggtgtgtgtgttg = "file:" + g5t5gg5t5gt.absolutePath
                    gttggtgtfff5.putExtra(
                        MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(g5t5gg5t5gt)
                    )
                } else {
                    gttggtgtfff5 = null
                }
            }
            val hyhy5hyy5h69 = Intent(Intent.ACTION_GET_CONTENT)
            hyhy5hyy5h69.addCategory(Intent.CATEGORY_OPENABLE)
            hyhy5hyy5h69.type = "image/*"
            val arrayOfIntents: Array<Intent?> =
                gttggtgtfff5?.let { arrayOf(it) } ?: arrayOfNulls(0)
            val jukiik5ik5 = Intent(Intent.ACTION_CHOOSER)
            jukiik5ik5.putExtra(Intent.EXTRA_INTENT, hyhy5hyy5h69)
            jukiik5ik5.putExtra(Intent.EXTRA_TITLE, "Image Chooser")
            jukiik5ik5.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOfIntents)
            startActivityForResult(jukiik5ik5, gtjiogtjoiggtjjgt)
            return true
        }

        fun gtjigthtghugtgthugt(): File? {
            val gtuhgthgtgt = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val vfbfvbhgfrgygfrrf = "JPEG_" + gtuhgthgtgt + "_"
            val yhlhylgtkfrjgdegedfsdtf = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES
            )
            return File.createTempFile(
                vfbfvbhgfrgygfrrf,
                ".jpg",
                yhlhylgtkfrjgdegedfsdtf
            )
        }
    }

    private fun nvfbfdedfedfsddrsdrsdds(): String {

        val gt5gt5gtgttg = getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)


        val gtgt5gt5gt5 = getSharedPreferences(
            "SHARED_PREF",
            Context.MODE_PRIVATE
        )

        val linkaaaaa = gtgt5gt5gt5.getString("link", null)
        val myTrIdaaaaaa = gtgt5gt5gt5.getString(MaiinnClaaaaasss.instIdfrfrf, null)
        val afIdaaaaaaa = gtgt5gt5gt5.getString(aps_idddddd, null)

        val interdaaaaaaaa = gtgt5gt5gt5.getString("WebInt", null)


        when (interdaaaaaaaa) {
            "campaign" -> {
                frokrfko.gtgtigtjijgtjgtgtigti(afIdaaaaaaa.toString())
            }
            "deepLink" -> {
                frokrfko.gtgtigtjijgtjgtgtigti(afIdaaaaaaa.toString())
            }
            "deepLinkNOApps" -> {
                frokrfko.gtgtigtjijgtjgtgtigti(myTrIdaaaaaa.toString())
            }
            "geo" -> {
                frokrfko.gtgtigtjijgtjgtgtigti(myTrIdaaaaaa.toString())
            }

        }
        Log.d("lolo", "link is ${linkaaaaa}")
        return gt5gt5gtgttg.getString("SAVED_URL", linkaaaaa).toString()
    }

    var urlfififif = ""
    fun saveUrlaaaa(lurlurlurlurlur: String?) {
        if (!lurlurlurlurlur!!.contains("t.me")) {

            if (urlfififif == "") {
                urlfififif = getSharedPreferences(
                    "SP_WEBVIEW_PREFS",
                    AppCompatActivity.MODE_PRIVATE
                ).getString(
                    "SAVED_URL",
                    lurlurlurlurlur
                ).toString()

                val spspspspsppspspsp =
                    getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)
                val ededededededed = spspspspsppspspsp.edit()
                ededededededed.putString("SAVED_URL", lurlurlurlurlur)
                ededededededed.apply()
            }
        }
    }

    private var exitexitexitexit = false
    override fun onBackPressed() {

        if (webViewfrrfrfrf.canGoBack()) {
            if (exitexitexitexit) {
                webViewfrrfrfrf.stopLoading()
                webViewfrrfrfrf.loadUrl(urlfififif)
            }
            this.exitexitexitexit = true
            webViewfrrfrfrf.goBack()
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                exitexitexitexit = false
            }, 2000)

        } else {
            super.onBackPressed()
        }
    }
}

