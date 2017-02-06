package com.pain.easymvp.presenters.presenterimpls;

import com.pain.easymvp.models.MainModel;
import com.pain.easymvp.presenters.BasePresenter;
import com.pain.easymvp.views.MainView;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zhangty on 2017/2/6.
 */

public class MainPresenter implements BasePresenter {
    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }
    public void loadData(){
        mainView.showProgress();
        Observable.interval(5, TimeUnit.SECONDS)
                .take(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                        mainView.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        MainModel mainModel=new MainModel();
                        mainModel.setTitle("标题"+ new Random().nextInt(200));
                        mainModel.setNumberStr("内容"+new Random().nextInt(200));
                        mainView.showData(mainModel);
                    }
                });
    }
}
