package com.pain.mvpofficial.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.pain.mvpofficial.presenters.BasePresenter;
import butterknife.Unbinder;

/**
 * Created by zhangty on 2017/2/7.
 * 一个抽象类，所有关于Mvp有关Activity的父类,主要封装resenter的销毁方法，防止内存泄漏
 */

public abstract class MvpBaseActiviy<P extends BasePresenter> extends AppCompatActivity{
    //Presenter
    protected P presenter;
    //Butterknife的解绑对象
    protected Unbinder unbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            //先解绑Presenter和View的耦合关系
            presenter.detachMvpView();
            //再直接让Presenter为null
            presenter=null;
        }
        if (unbinder!=null){
            //解绑ButterKnife
            unbinder.unbind();
        }
    }
}
