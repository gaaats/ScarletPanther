package com.superking.parchisi.stare.brrrbrbrrb

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.util.Log
import android.webkit.*
import android.widget.Toast
import com.superking.parchisi.stare.R
import com.superking.parchisi.stare.databinding.ActivityBrovvvvsaaaaBinding
import com.superking.parchisi.stare.maaaaainaanclaa.MaiinnClaaaaasss
import com.superking.parchisi.stare.maaaaainaanclaa.MaiinnClaaaaasss.Companion.aps_id
import com.superking.parchisi.stare.modullles.BeamModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class BrovvvvsaaaaActivity : AppCompatActivity() {
    private lateinit var bindBeam: ActivityBrovvvvsaaaaBinding
    lateinit var beam: WebView


    private var mFilePathCallback: ValueCallback<Array<Uri>>? = null
    private var mCameraPhotoPath: String? = null
    private val INPUT_FILE_REQUEST_CODE = 1

    private val viewBeamModel by viewModel<BeamModel>(
        named("BeamModel")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindBeam = ActivityBrovvvvsaaaaBinding.inflate(layoutInflater)
        setContentView(bindBeam.root)
        beam = bindBeam.webst
        CookieManager.getInstance().setAcceptCookie(true)
        CookieManager.getInstance().setAcceptThirdPartyCookies(beam, true)
        viewBeamModel.webSet(beam)


        beam.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
                try {
                    if (URLUtil.isNetworkUrl(url)) {
                        return false
                    }
                    if (viewBeamModel.appInstalledOrNot(url)) {

                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(url)
                        startActivity(intent)
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
                saveUrl(url)
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

        beam.webChromeClient = ChromeClient()
        beam.loadUrl(urururururururur())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode != INPUT_FILE_REQUEST_CODE || mFilePathCallback == null) {
            super.onActivityResult(requestCode, resultCode, data)
            return
        }
        var results: Array<Uri>? = null

        if (resultCode == RESULT_OK) {
            if (data == null) {
                if (mCameraPhotoPath != null) {
                    results = arrayOf(Uri.parse(mCameraPhotoPath))
                }
            } else {
                val dataString = data.dataString
                if (dataString != null) {
                    results = arrayOf(Uri.parse(dataString))
                }
            }
        }
        mFilePathCallback!!.onReceiveValue(results)
        mFilePathCallback = null
        return
    }


    inner class ChromeClient : WebChromeClient() {

        override fun onShowFileChooser(
            view: WebView?,
            filePath: ValueCallback<Array<Uri>>?,
            fileChooserParams: FileChooserParams?
        ): Boolean {
            mFilePathCallback?.onReceiveValue(null)
            mFilePathCallback = filePath
            var takePictureIntent: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (takePictureIntent!!.resolveActivity(packageManager) != null) {
                var photoFile: File? = null
                try {
                    photoFile = createImageFile()
                    takePictureIntent.putExtra("PhotoPath", mCameraPhotoPath)
                } catch (ex: IOException) {
                    Log.e("ErrorOccurred", "Unable to create Image File", ex)
                }

                if (photoFile != null) {
                    mCameraPhotoPath = "file:" + photoFile.absolutePath
                    takePictureIntent.putExtra(
                        MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(photoFile)
                    )
                } else {
                    takePictureIntent = null
                }
            }
            val contentSelectionIntent = Intent(Intent.ACTION_GET_CONTENT)
            contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE)
            contentSelectionIntent.type = "image/*"
            val intentArray: Array<Intent?> =
                takePictureIntent?.let { arrayOf(it) } ?: arrayOfNulls(0)
            val chooserIntent = Intent(Intent.ACTION_CHOOSER)
            chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent)
            chooserIntent.putExtra(Intent.EXTRA_TITLE, "Image Chooser")
            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArray)
            startActivityForResult(chooserIntent, INPUT_FILE_REQUEST_CODE)
            return true
        }

        fun createImageFile(): File? {
            val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val imageFileName = "JPEG_" + timeStamp + "_"
            val storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES
            )
            return File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
            )
        }
    }

    private fun urururururururur(): String {

        val spoon = getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)


        val sharPre = getSharedPreferences(
            "SHARED_PREF",
            Context.MODE_PRIVATE
        )

        val link = sharPre.getString("link", null)
        val myTrId = sharPre.getString(MaiinnClaaaaasss.instId, null)
        val afId = sharPre.getString(aps_id, null)

        val interd = sharPre.getString("WebInt", null)


        when (interd) {
            "campaign" -> {
                viewBeamModel.pushToOS(afId.toString())
            }
            "deepLink" -> {
                viewBeamModel.pushToOS(afId.toString())
            }
            "deepLinkNOApps" -> {
                viewBeamModel.pushToOS(myTrId.toString())
            }
            "geo" -> {
                viewBeamModel.pushToOS(myTrId.toString())
            }

        }
        Log.d("lolo", "link is ${link}")
        return spoon.getString("SAVED_URL", link).toString()
    }

    var urlfififif = ""
    fun saveUrl(lurlurlurlurlur: String?) {
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

        if (beam.canGoBack()) {
            if (exitexitexitexit) {
                beam.stopLoading()
                beam.loadUrl(urlfififif)
            }
            this.exitexitexitexit = true
            beam.goBack()
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                exitexitexitexit = false
            }, 2000)

        } else {
            super.onBackPressed()
        }
    }
}

