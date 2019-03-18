package me.mhabulazm.task.api

import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


/**
 * Created by mhabulazm on 3/18/19.
 * mhabulazm@gmail.com
 */
object NyTimesApi {

    private fun getRetrofit(): Retrofit {
        val rxAdapter = RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
        val okHttpClient = OkHttpClient()
        return Retrofit.Builder()
                .baseUrl("https://api.nytimes.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(rxAdapter)
                .client(okHttpClient)
                .build()
    }

    fun getNyTimesService(): NyTimesApiService = getRetrofit().create(NyTimesApiService::class.java)

}