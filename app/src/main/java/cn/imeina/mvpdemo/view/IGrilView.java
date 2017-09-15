package cn.imeina.mvpdemo.view;

import java.util.List;

import cn.imeina.mvpdemo.bean.Girl;

/**
 * girl view interface
 * Created by gaopengfei on 2017/9/11.
 */

public interface IGrilView extends IBaseView{

    /**
     * 显示美女
     * @param girls
     */
    void showGirls(List<Girl> girls);
}
