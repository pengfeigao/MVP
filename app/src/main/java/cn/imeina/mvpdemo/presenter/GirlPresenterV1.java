package cn.imeina.mvpdemo.presenter;

import java.util.List;
import cn.imeina.mvpdemo.bean.Girl;
import cn.imeina.mvpdemo.model.CallBack;
import cn.imeina.mvpdemo.model.IGirlModel;
import cn.imeina.mvpdemo.model.impl.GirlModelImplV1;
import cn.imeina.mvpdemo.view.IGrilView;

/**
 * 原始P层实现，但对view使用了强引用，没有解决内存泄漏问题
 * Created by gaopengfei on 2017/9/14.
 */

public class GirlPresenterV1{

    //持有View层的引用
    private IGrilView mGirlView;
    //持有Model层的引用
    private IGirlModel mGirlModel = new GirlModelImplV1();

    public GirlPresenterV1(IGrilView mGirlView) {

        this.mGirlView = mGirlView;
    }

    /**
     * bind view and model
     */
    public void fetch(){

        //显示进度条
        mGirlView.showLoading("");

        mGirlModel.loadGril(new CallBack<List<Girl>>() {

            @Override
            public void onComplete(List<Girl> girls) {
                if (mGirlView != null){
                    mGirlView.hideLoading();
                    mGirlView.showGirls(girls);
                }
            }

            @Override
            public void onFail() {

            }
        });
    }
}
