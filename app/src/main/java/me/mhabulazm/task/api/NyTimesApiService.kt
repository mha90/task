package me.mhabulazm.task.api

import io.reactivex.Single
import me.mhabulazm.task.api.response.MostViewedResponse
import retrofit2.http.GET

/**
 * Created by mhabulazm on 3/18/19.
 * mhabulazm@gmail.com
 */
interface NyTimesApiService {

    @GET("svc/mostpopular/v2/viewed/1.json?api-key=FacF0CV2nJ2AGDq6NLUxEyquQ5Gkcj1d")
    fun getMostViewed(): Single<MostViewedResponse>

}