package com.pain.mvpofficial.presenters;
import com.pain.mvpofficial.models.MainModel;
import com.pain.mvpofficial.views.MainView;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zhangty on 2017/2/7.
 * 列举了一个MainPresent作为样例
 */

public class MainPresenter extends BasePresenterImpl<MainView>{
    public MainPresenter(MainView view) {
        super(view);
    }

    @Override
    public void attachView() {
        //初始化的业务逻辑操作

    }
    public void loadData(){
        //模拟网络耗时操作
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
