package cn.imeina.mvpdemo.model;

/**
 * Created by gaopengfei on 2017/9/15.
 */

public interface CallBack<T>{

    void onComplete(T t);

    void onFail();
}
