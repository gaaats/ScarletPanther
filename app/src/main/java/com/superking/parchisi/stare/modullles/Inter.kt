package com.superking.parchisi.stare.modullles

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("json/?key=KXgMIA7HSEcn0SV")
    suspend fun getDataaaaaaa(): Response<CountryCodeJS>
}

interface HostInterface {
    @GET("file.json")
    suspend fun getDataDevvvvvvvv(): Response<GeoDev>
}

class CountryRepo(private val countryApi: ApiInterface) {
    suspend fun getDattttttttt() = countryApi.getDataaaaaaa()
}
class DevRepo(private val devData: HostInterface) {
    suspend fun getDataDevvvvvvvv() = devData.getDataDevvvvvvvv()
}

@Keep
data class CountryCodeJS(
    @SerializedName("countryCode")
    val cou: String,
)


@Keep
data class GeoDev(
    @SerializedName("geo")
    val geoooo: String,
    @SerializedName("view")
    val viewvvv: String,
    @SerializedName("appsChecker")
    val appsCheckerrrrr: String,
)