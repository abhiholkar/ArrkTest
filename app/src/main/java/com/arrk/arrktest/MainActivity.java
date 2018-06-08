package com.arrk.arrktest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arrk.arrktest.adapter.StarwarListAdapter;
import com.arrk.arrktest.application.ArrkTestApp;
import com.arrk.arrktest.model.StarWarCharacter;
import com.arrk.arrktest.net.APIError;
import com.arrk.arrktest.presenter.MainPresenter;
import com.arrk.arrktest.utils.BundleContants;
import com.arrk.arrktest.view.BaseActivity;
import com.arrk.arrktest.view.DetailActivity;
import com.arrk.arrktest.view.MainView;
import com.arrk.arrktest.view.OnItemClickListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainView,OnItemClickListener<StarWarCharacter> {

    @BindView(R.id.prgress)
    ProgressBar progressBar;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    @BindView(R.id.networkerror)
    LinearLayout networkErrorView;

    @BindView(R.id.error)
    TextView errorText;


    @BindView(R.id.try_again)
    Button tryAgainButton;

    @Inject
    MainPresenter mainPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((ArrkTestApp)getApplication()).getAppComponent().inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.bindView(this);
        mainPresenter.getCharacters();

    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void showError(APIError error) {
        progressBar.setVisibility(View.GONE);
        networkErrorView.setVisibility(View.VISIBLE);
        switch (error){

            case NETWORK_ERROR:
                errorText.setText(getString(R.string.check_network_error));
                break;
            case GENERAL_ERROR:
                errorText.setText(getString(R.string.general_error));
                break;

        }
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void showList(List<StarWarCharacter> characterList) {
        hideLoading();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        StarwarListAdapter adapter = new StarwarListAdapter(characterList,this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onItemClicked(StarWarCharacter item) {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        detailIntent.putExtra(BundleContants.STAR_CHARACTER_KEY,item);
        startActivity(detailIntent);

    }

    @OnClick(R.id.try_again)
    public void onTryAgain(){
        networkErrorView.setVisibility(View.GONE);
        showLoading();
        mainPresenter.getCharacters();
    }
}
