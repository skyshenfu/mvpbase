package com.pain.mvpofficial.views;

import com.pain.mvpofficial.presenters.BasePresenter;

/**
 * Created by zhangty on 2017/2/7.
 */

public interface BaseView<T extends BasePresenter> {
    void  setPresent(T presenter);
}
