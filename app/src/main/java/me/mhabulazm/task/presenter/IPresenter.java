package me.mhabulazm.task.presenter;

import io.reactivex.disposables.Disposable;

/**
 * Created by mhabulazm on 3/18/19.
 * mhabulazm@gmail.com
 */
public interface IPresenter<E> {

    void attachView(E view);

    void detachView(E view);

    void addDisposable(Disposable disposable);
}
