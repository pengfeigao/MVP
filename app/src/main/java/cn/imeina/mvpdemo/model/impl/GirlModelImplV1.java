package cn.imeina.mvpdemo.model.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.rest.AsyncRequestExecutor;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;
import com.yanzhenjie.nohttp.rest.SimpleResponseListener;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import cn.imeina.mvpdemo.bean.Girl;
import cn.imeina.mvpdemo.model.CallBack;
import cn.imeina.mvpdemo.model.IGirlModel;

/**
 * girl model implemetation  version one
 * Created by gaopengfei on 2017/9/11.
 */

public class GirlModelImplV1 implements IGirlModel {

    @Override
    public void loadGril(final CallBack<List<Girl>> listener) {

        Request<String> request = NoHttp.createStringRequest("http://www.imeina.cn/test/girl.json");
        AsyncRequestExecutor.INSTANCE.execute(0, request, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                // 请求成功。
                String s = response.get();
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Girl>>() {}.getType();
                ArrayList<Girl> girls = gson.fromJson(s, type);
                if (listener != null){
                    listener.onComplete(girls);
                }
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                // 请求失败。
            }
        });
    }
}
