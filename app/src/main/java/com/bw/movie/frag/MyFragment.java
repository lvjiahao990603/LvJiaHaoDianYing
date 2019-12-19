package com.bw.movie.frag;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.view.LoginActivity;
import com.bw.movie.view.ShezhiActivity;

import butterknife.BindView;

public class MyFragment extends BaseFragment {
    @BindView(R.id.img_tx)
    ImageView imgTx;
    @BindView(R.id.head_login)
    RelativeLayout headLogin;
    @BindView(R.id.img_gz)
    ImageView imgGz;
    @BindView(R.id.img_yuyue)
    ImageView imgYuyue;
    @BindView(R.id.img_jilu)
    ImageView imgJilu;
    @BindView(R.id.img_kg)
    ImageView imgKg;
    @BindView(R.id.img_pl)
    ImageView imgPl;
    @BindView(R.id.img_fk)
    ImageView imgFk;
    @BindView(R.id.img_sz)
    ImageView imgSz;

    @Override
    protected void initData() {
        headLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        //设置
        imgSz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ShezhiActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getlayout() {
        return R.layout.myfragment;
    }
}
