package me.mhabulazm.task.view;

/**
 * Created by mhabulazm on 3/18/19.
 * mhabulazm@gmail.com
 */
public interface IView {

    void showProgress();

    void hideProgress();

    void showError(String errorMessage);

}
