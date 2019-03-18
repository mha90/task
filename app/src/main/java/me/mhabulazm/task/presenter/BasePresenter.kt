package me.mhabulazm.task.presenter

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import me.mhabulazm.task.view.IView

/**
 * Created by mhabulazm on 3/18/19.
 * mhabulazm@gmail.com
 */
abstract class BasePresenter<E : IView> : IPresenter<E> {
    protected var view: E? = null
    protected var compositeDisposable: CompositeDisposable? = null

    override fun attachView(view: E?) {
        this.view = view
        compositeDisposable = CompositeDisposable()
    }

    override fun detachView(view: E?) {
        this.view = null
        this.compositeDisposable?.clear()
    }

    override fun addDisposable(disposable: Disposable) {
        compositeDisposable?.add(disposable)
    }


}