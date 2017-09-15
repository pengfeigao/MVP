package cn.imeina.mvpdemo.view;

/**
 * Created by gaopengfei on 2017/9/15.
 */

public interface IBaseView {

    /**
     * 显示loading框
     * @param msg
     */
    void showLoading(String msg);

    /**
     * 隐藏loading框
     */
    void hideLoading();
}
