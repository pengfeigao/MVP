package cn.imeina.mvpdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import cn.imeina.mvpdemo.presenter.BasePresenter;
import cn.imeina.mvpdemo.view.IBaseView;

/**
 * Created by gaopengfei on 2017/9/14.
 */

public abstract class BaseActivity<T extends BasePresenter<V>, V extends IBaseView> extends AppCompatActivity {

    public T mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //create presenter
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    protected abstract T createPresenter();
}
