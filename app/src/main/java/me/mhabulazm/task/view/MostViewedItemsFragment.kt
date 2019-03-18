package me.mhabulazm.task.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import me.mhabulazm.task.R
import me.mhabulazm.task.adapter.MostViewedItemsAdapter
import me.mhabulazm.task.api.response.Result
import me.mhabulazm.task.common.BaseActivity
import me.mhabulazm.task.presenter.MostViewedPresenter

/**
 * Created by mhabulazm on 3/18/19.
 * mhabulazm@gmail.com
 */
class MostViewedItemsFragment : IMostViewedView, Fragment(), MostViewedItemsAdapter.MostViewedItemClickListener {
    override fun onItemClick(item: Result?) {
        item?.let {
            ItemDetailsFragment.newInstance(item)
        }
    }

    private val presenter: MostViewedPresenter by lazy {
        MostViewedPresenter()
    }

    private val mostViewedItemsRecyclerView: RecyclerView? by lazy {
        view?.findViewById<RecyclerView>(R.id.mostViewedItemsRecyclerView)
    }

    private val emptyStateTextView: TextView? by lazy {
        view?.findViewById<TextView>(R.id.emptyStateTextView)
    }

    lateinit var adapter: MostViewedItemsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_most_viewed_items, container, false)
        presenter.attachView(this)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.fetchMostViewedItems()
    }

    override fun onDetach() {
        presenter.detachView(this)
        super.onDetach()
    }

    override fun showEmptyState() {
        emptyStateTextView?.visibility = View.VISIBLE
        mostViewedItemsRecyclerView?.visibility = View.GONE
    }


    override fun showMostViewedItems(mostViewedItems: List<Result>) {
        emptyStateTextView?.visibility = View.GONE
        mostViewedItemsRecyclerView?.visibility = View.VISIBLE

        mostViewedItemsRecyclerView?.layoutManager = LinearLayoutManager(activity)
        mostViewedItemsRecyclerView?.setHasFixedSize(true)
        adapter = MostViewedItemsAdapter(mostViewedItems, this)
        mostViewedItemsRecyclerView?.adapter = adapter
    }

    override fun showProgress() {
        (activity as BaseActivity).showProgress()
    }

    override fun hideProgress() {
        (activity as BaseActivity).hideProgress()

    }

    override fun showError(errorMessage: String?) {

    }

}