package me.mhabulazm.task.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import me.mhabulazm.task.R
import me.mhabulazm.task.api.response.Result


private const val ITEM_PARAM = "item_key"


class ItemDetailsFragment : Fragment() {
    private var result: Result? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            result = it.getParcelable(ITEM_PARAM)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_details, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(result: Result) =
                ItemDetailsFragment().apply {
                    arguments = Bundle().apply {
                        putParcelable(ITEM_PARAM, result)
                    }
                }
    }

}
