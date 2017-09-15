package cn.imeina.mvpdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import cn.imeina.mvpdemo.adapter.DividerItemDecoration;
import cn.imeina.mvpdemo.adapter.GirlAdapter;
import cn.imeina.mvpdemo.base.BaseActivity;
import cn.imeina.mvpdemo.presenter.BasePresenter;

public class MainActivity extends AppCompatActivity{

    private Button btnGirls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        btnGirls = (Button) findViewById(R.id.btn_girls);
        btnGirls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, GirlListActivity.class));
            }
        });
    }
}
