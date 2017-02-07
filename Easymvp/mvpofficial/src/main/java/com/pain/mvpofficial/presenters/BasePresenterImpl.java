package com.pain.mvpofficial.presenters;

import com.pain.mvpofficial.views.BaseView;

/**
 * Created by zhangty on 2017/2/7.
 * 抽象类,封装了解绑View和Presenter之间的具体逻辑
 */

    public abstract class BasePresenterImpl<T extends BaseView> implements BasePresenter{
    protected T view;
    public BasePresenterImpl(T view) {
        this.view = view;
    }
    @Override
    public void detachView() {
        if (view!=null){
            this.view=null;
        }
    }
}
