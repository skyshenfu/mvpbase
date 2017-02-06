package com.pain.easymvp.ui.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.pain.easymvp.R;
import com.pain.easymvp.models.MainModel;
import com.pain.easymvp.presenters.presenterimpls.MainPresenter;
import com.pain.easymvp.views.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView{
    private ProgressDialog dialog;
    private MainPresenter presenter;
    @BindView(R.id.title_textview)
    TextView titleTextView;
    @BindView(R.id.content_textview)
    TextView contentTextView;
    @BindView(R.id.change_button)
    Button  button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter=new MainPresenter(this);
        presenter.loadData();
    }

    @Override
    public void showProgress() {
        if (dialog==null){
            dialog=new ProgressDialog(this);
        }
        dialog.show();
    }

    @Override
    public void hideProgress() {
        dialog.dismiss();
    }

    @Override
    public void showData(MainModel mainModel) {
        titleTextView.setText(mainModel.getTitle());
        contentTextView.setText(mainModel.getNumberStr());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter=null;
        }

    }
}
