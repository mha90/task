package me.mhabulazm.task.presenter

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import me.mhabulazm.task.api.NyTimesApi
import me.mhabulazm.task.view.IMostViewedView

/**
 * Created by mhabulazm on 3/18/19.
 * mhabulazm@gmail.com
 */
class MostViewedPresenter : BasePresenter<IMostViewedView>() {

    fun fetchMostViewedItems() {
        view?.showProgress()
        val disposable = NyTimesApi.getNyTimesService().getMostViewed()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    view?.hideProgress()

                    if (response == null || response.results.isNullOrEmpty()) {
                        view?.showEmptyState()
                    } else {
                        view?.showMostViewedItems(response.results)
                    }


                }, { error ->
                    view?.showError("Please, try again later")
                    view?.hideProgress()
                    Log.e("MostViewedPresenter", error.message)
                })

        addDisposable(disposable)
    }

}