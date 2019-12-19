package com.bw.movie.view;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class ShezhiActivity extends BaseActivity {

    @BindView(R.id.shezhi_fanhui)
    ImageView shezhiFanhui;
    @BindView(R.id.jiagaunzhu)
    TextView jiagaunzhu;
    @BindView(R.id.shezhi_qingchu)
    TextView shezhiQingchu;
    @BindView(R.id.shezhi_banben)
    TextView shezhiBanben;
    @BindView(R.id.shezhi_m)
    TextView shezhiM;
    @BindView(R.id.shezhi_banbengengxin)
    ImageView shezhiBanbengengxin;
    @BindView(R.id.re_one)
    RelativeLayout reOne;
    @BindView(R.id.shezhi_chongzhimima)
    TextView shezhiChongzhimima;
    @BindView(R.id.re_two)
    RelativeLayout reTwo;
    @BindView(R.id.shezhi_tuichudenglu)
    Button shezhiTuichudenglu;

    @Override
    protected void initData() {
        //重置密码
        reTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShezhiActivity.this,ChongzhiActivity.class);
                startActivity(intent);
            }
        });
        reOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShezhiActivity.this,BanbenGengxinActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getlayout() {
        return R.layout.activity_shezhi;
    }

    @OnClick(R.id.shezhi_fanhui)
    public void onClick() {
        finish();
    }
}
