package me.mhabulazm.task.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_most_viewed_items.*
import me.mhabulazm.task.MainActivity
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
            val detailsFragment = ItemDetailsFragment.newInstance(item)
            (activity as MainActivity).addFragment(detailsFragment, true)
        }
    }

    private val presenter: MostViewedPresenter by lazy {
        MostViewedPresenter()
    }

    lateinit var adapter: MostViewedItemsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_most_viewed_items, container, false)
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
        presenter.fetchMostViewedItems()
    }

    override fun onDestroyView() {
        presenter.detachView(this)
        super.onDestroyView()
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

    override fun showError(errorMessage: String) {
        (activity as BaseActivity).showError(errorMessage)
    }

}