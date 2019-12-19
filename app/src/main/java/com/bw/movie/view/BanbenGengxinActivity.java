package com.bw.movie.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BanbenGengxinActivity extends BaseActivity {

    @BindView(R.id.banben_fanhui)
    ImageView banbenFanhui;
    @BindView(R.id.bt_lijigengxin)
    Button btLijigengxin;

    @Override
    protected void initData() {
        //版本返回
        banbenFanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //立即更新
        btLijigengxin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BanbenGengxinActivity.this, "发现新版本，立即更新！", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getlayout() {
        return R.layout.activity_banben_gengxin;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
