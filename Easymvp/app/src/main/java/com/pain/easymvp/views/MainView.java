package com.pain.easymvp.views;

import com.pain.easymvp.models.MainModel;

/**
 * Created by zhangty on 2017/2/6.
 */

public interface MainView extends BaseView {
    void showProgress();
    void hideProgress();
    void showData(MainModel mainModel);
}
