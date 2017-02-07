package com.pain.mvpofficial.presenters;

import com.pain.mvpofficial.contracts.MainContract;
import com.pain.mvpofficial.models.MainModel;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zhangty on 2017/2/7.
 */

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
        view.setPresent(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void loadData() {
        view.showProgress();
        Observable.interval(5, TimeUnit.SECONDS)
                .take(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                        view.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(Long aLong) {
                        MainModel mainModel=new MainModel();
                        mainModel.setTitle("标题"+ new Random().nextInt(200));
                        mainModel.setNumberStr("内容"+new Random().nextInt(200));
                        view.showData(mainModel);
                    }
                });

    }
}
