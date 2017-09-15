package cn.imeina.mvpdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import java.util.List;
import cn.imeina.mvpdemo.adapter.DividerItemDecoration;
import cn.imeina.mvpdemo.adapter.GirlAdapter;
import cn.imeina.mvpdemo.base.BaseActivity;
import cn.imeina.mvpdemo.bean.Girl;
import cn.imeina.mvpdemo.presenter.GirlPresenterV2;
import cn.imeina.mvpdemo.view.IGrilView;

/**
 * Created by gaopengfei on 2017/9/14.
 */

public class GirlListActivity extends BaseActivity<GirlPresenterV2, IGrilView> implements IGrilView {

    private RecyclerView rvList;
    private GirlAdapter adapter;
    private ProgressBar loadingView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girllist);
        initView();
        loadData();
    }

    @Override
    protected GirlPresenterV2 createPresenter() {
        return new GirlPresenterV2();
    }


    private void loadData() {

        //处罚中间者加载数据
        //new GirlPresenterV1(this).fetch();
        mPresenter.fetch();
    }

    public void initView() {

        loadingView = (ProgressBar) findViewById(R.id.pb_loading);
        rvList = (RecyclerView) findViewById(R.id.rv_list);

        rvList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GirlAdapter(this);
        rvList.setAdapter(adapter);
        rvList.setItemAnimator(new DefaultItemAnimator());
        rvList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    }

    @Override
    public void showGirls(List<Girl> girls) {

        if (girls != null)
            adapter.setGirls(girls);
    }


    @Override
    public void showLoading(String msg) {
        loadingView.setVisibility(View.VISIBLE);
        rvList.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {

        loadingView.setVisibility(View.GONE);
        rvList.setVisibility(View.VISIBLE);
    }
}
