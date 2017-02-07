package com.pain.mvpofficial;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pain.mvpofficial.contracts.MainContract;
import com.pain.mvpofficial.models.MainModel;
import com.pain.mvpofficial.presenters.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainContract.View{
    @BindView(R.id.title_textview)
    TextView titleTextView;
    @BindView(R.id.content_textview)
    TextView contentTextView;
    @BindView(R.id.change_button)
    Button button;
    private ProgressDialog dialog;
    private MainContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        new MainPresenter(this);
        presenter.loadData();
    }

    @Override
    public void showProgress() {
        if (dialog==null){
            dialog=new ProgressDialog(this);
        }
        dialog.show();
    }
   @OnClick(R.id.change_button)
   void onClick(View view){
       switch (view.getId()){
           case R.id.change_button:
               presenter.loadData();
               break;
       }

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
    public void setPresent(MainContract.Presenter presenter) {
        this.presenter=presenter;
    }
}
