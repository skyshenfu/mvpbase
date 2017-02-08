package com.pain.mvpofficial.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pain.mvpofficial.models.MainModel;
import com.pain.mvpofficial.presenters.MainPresenter;
import com.pain.mvpofficial.views.MainView;

/**
 * Created by zhangty on 2017/2/8.
 */

public class ExampleFragment extends MvpBaseFragment<MainPresenter> implements MainView {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showData(MainModel mainModel) {

    }
}
