package me.mhabulazm.task.view

import me.mhabulazm.task.api.response.Result


/**
 * Created by mhabulazm on 3/18/19.
 * mhabulazm@gmail.com
 */
interface IMostViewedView : IView {

    fun showMostViewedItems(mostViewedItems: List<Result>)

    fun showEmptyState()

}
