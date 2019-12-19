package com.bw.movie.view;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;

import butterknife.BindView;

public class ChongzhiActivity extends BaseActivity {

    @BindView(R.id.chongzhi_fanhui)
    ImageView chongzhiFanhui;
    @BindView(R.id.wodemima)
    TextView wodemima;
    @BindView(R.id.yuanmima)
    EditText yuanmima;
    @BindView(R.id.tiaomuyi)
    RelativeLayout tiaomuyi;
    @BindView(R.id.shezhixinmima)
    TextView shezhixinmima;
    @BindView(R.id.xinmima)
    EditText xinmima;
    @BindView(R.id.tiaomuer)
    RelativeLayout tiaomuer;
    @BindView(R.id.querenxinmima)
    TextView querenxinmima;
    @BindView(R.id.zaicishurumima)
    EditText zaicishurumima;
    @BindView(R.id.tiaomusan)
    RelativeLayout tiaomusan;
    @BindView(R.id.bt_1)
    Button bt1;

    @Override
    protected void initData() {
        //重置返回
        chongzhiFanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
       bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChongzhiActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getlayout() {
        return R.layout.activity_chongzhi;
    }
}
