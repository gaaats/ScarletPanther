package com.superking.parchisi.stare.modullles

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("json/?key=KXgMIA7HSEcn0SV")
    suspend fun getData(): Response<CountryCodeJS>
}

interface HostInterface {
    @GET("file.json")
    suspend fun getDataDev(): Response<GeoDev>
}

class CountryRepo(private val countryApi: ApiInterface) {
    suspend fun getDat() = countryApi.getData()
}
class DevRepo(private val devData: HostInterface) {
    suspend fun getDataDev() = devData.getDataDev()
}

@Keep
data class CountryCodeJS(
    @SerializedName("countryCode")
    val cou: String,
)


@Keep
data class GeoDev(
    @SerializedName("geo")
    val geo: String,
    @SerializedName("view")
    val view: String,
    @SerializedName("appsChecker")
    val appsChecker: String,
)