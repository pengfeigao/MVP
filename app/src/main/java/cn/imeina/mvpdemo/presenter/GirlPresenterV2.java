package cn.imeina.mvpdemo.presenter;

import java.util.List;
import cn.imeina.mvpdemo.bean.Girl;
import cn.imeina.mvpdemo.model.CallBack;
import cn.imeina.mvpdemo.model.IGirlModel;
import cn.imeina.mvpdemo.model.impl.GirlModelImplV1;
import cn.imeina.mvpdemo.view.IGrilView;

/**
 * Created by gaopengfei on 2017/9/15.
 */

public class GirlPresenterV2 extends BasePresenter<IGrilView> {

    private IGirlModel mGirlModel = new GirlModelImplV1();

    public void fetch(){

        //显示进度条
        getIView().showLoading("");

        mGirlModel.loadGril(new CallBack<List<Girl>>() {

            @Override
            public void onComplete(List<Girl> girls) {
                if (getIView() != null){
                    getIView().hideLoading();
                    getIView().showGirls(girls);
                }
            }

            @Override
            public void onFail() {

            }
        });
    }
}
