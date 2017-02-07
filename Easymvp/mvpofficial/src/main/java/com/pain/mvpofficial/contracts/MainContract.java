package com.pain.mvpofficial.contracts;

import com.pain.mvpofficial.models.MainModel;
import com.pain.mvpofficial.presenters.BasePresenter;
import com.pain.mvpofficial.views.BaseView;

/**
 * Created by zhangty on 2017/2/7.
 */

public interface MainContract {
    interface Presenter extends BasePresenter{
        void loadData();

    }
    interface View extends BaseView<Presenter>{
        void showProgress();
        void hideProgress();
        void showData(MainModel mainModel);
    }
}
