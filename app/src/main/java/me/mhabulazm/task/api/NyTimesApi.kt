package me.mhabulazm.task.api

import io.reactivex.schedulers.Schedulers
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


/**
 * Created by mhabulazm on 3/18/19.
 * mhabulazm@gmail.com
 */
class NyTimesApi {

    private fun getRetrofit(): Retrofit {
        val rxAdapter = RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
        return Retrofit.Builder()
                .baseUrl("https://api.nytimes.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(rxAdapter)
                .build()
    }

    fun getNyTimesService(): NyTimesApiService = getRetrofit().create(NyTimesApiService::class.java)

}