package me.mhabulazm.task.common

import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import me.mhabulazm.task.view.IView

/**
 * Created by mhabulazm on 3/18/19.
 * mhabulazm@gmail.com
 */

abstract class BaseActivity : AppCompatActivity(), IView {
    private var showDialog: ProgressDialog? = null

    override fun showProgress() {
        if (showDialog == null) showDialog = ProgressDialog(this)
        showDialog?.showDialog()
    }

    override fun hideProgress() {
        showDialog?.dismissDialog()
    }

    override fun showError(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
    }

}