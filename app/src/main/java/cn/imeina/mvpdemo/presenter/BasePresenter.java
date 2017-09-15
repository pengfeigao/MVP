package cn.imeina.mvpdemo.presenter;

import java.lang.ref.WeakReference;
import cn.imeina.mvpdemo.view.IBaseView;

/**
 * Created by gaopengfei on 2017/9/15.
 */

public abstract class BasePresenter<T extends IBaseView> {

    /**
     * 使用弱引用来解决内存泄漏
     */
    protected WeakReference<T> mViewRef;

    /**
     * bind P with V
     * @param view
     */
    public void attachView(T view){

        mViewRef = new WeakReference<T>(view);
    }

    /**
     * unbind P with V
     */
    public void detachView(){

        if (mViewRef != null){
            mViewRef.clear();
            mViewRef = null;
        }
    }

    /**
     * 返回view
     * @return
     */
    public T getIView(){
        return mViewRef.get();
    }
}
