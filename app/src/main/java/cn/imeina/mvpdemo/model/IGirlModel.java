package cn.imeina.mvpdemo.model;

import java.util.List;

import cn.imeina.mvpdemo.bean.Girl;

/**
 * Created by gaopengfei on 2017/9/11.
 */

public interface IGirlModel {

    /**
     * 加载数据
     * @param listener
     */
    void loadGril(CallBack<List<Girl>> listener);
}
