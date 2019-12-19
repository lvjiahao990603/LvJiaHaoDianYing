package com.bw.movie.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.BuyBean;
import com.bw.movie.bean.CodeBean;
import com.bw.movie.bean.FujinBean;
import com.bw.movie.bean.GoupiaoBean;
import com.bw.movie.bean.JijiangBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.PaiqiBean;
import com.bw.movie.bean.PaiqiShowBean;
import com.bw.movie.bean.QuyuBean;
import com.bw.movie.bean.QuyuLiebiaoBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.RemenBean;
import com.bw.movie.bean.SousuoBean;
import com.bw.movie.bean.TuijianBean;
import com.bw.movie.bean.XbannerBean;
import com.bw.movie.bean.XiangqingBean;
import com.bw.movie.bean.XieyingpingBean;
import com.bw.movie.bean.YingpingBean;
import com.bw.movie.bean.YingyuanSouBean;
import com.bw.movie.bean.YingyuanXQBean;
import com.bw.movie.bean.ZhengzaiBean;
import com.bw.movie.bean.ZhifuBean;
import com.bw.movie.bean.ZuoBean;
import com.bw.movie.contract.IHomeContract;
import com.bw.movie.presenter.HomePresenter;
import com.bw.movie.xiangqingfrag.JieshaoFragment;
import com.bw.movie.xiangqingfrag.JuzhaoFragment;
import com.bw.movie.xiangqingfrag.YingpingFragment;
import com.bw.movie.xiangqingfrag.YugaoFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class XiangqingActivity extends BaseActivity implements IHomeContract.Iview {

    @BindView(R.id.xiangqing_img_1)
    ImageView xiangqingImg1;
    @BindView(R.id.jiantou_fanhui)
    ImageView jiantouFanhui;
    @BindView(R.id.tv_pingfen)
    TextView tvPingfen;
    @BindView(R.id.tv_pingfen2)
    TextView tvPingfen2;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.dongzuo)
    TextView dongzuo;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.type)
    TextView type;
    @BindView(R.id.xiangqing_tab)
    TabLayout xiangqingTab;
    @BindView(R.id.xiangqing_vp)
    ViewPager xiangqingVp;
    ArrayList<String> strings = new ArrayList<>();
    ArrayList<Fragment> fragments = new ArrayList<>();
    @BindView(R.id.xiangqing_xieyingping)
    Button xiangqingXieyingping;
    @BindView(R.id.xiangqing_xuanzuogoupiao)
    Button xiangqingXuanzuogoupiao;
    private HomePresenter homePresenter;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String movieId = intent.getStringExtra("movieId");
        //跳转影评
        xiangqingXieyingping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XiangqingActivity.this,XQXieYingPingActivity.class);
                intent.putExtra("movieId", movieId);
                startActivity(intent);
            }
        });

        //箭头返回
        jiantouFanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        homePresenter = new HomePresenter();
        homePresenter.attach(this);
        homePresenter.getXiangqingPresenter("13880", "157570419054513880", movieId);

        strings.add("介绍");
        strings.add("预告");
        strings.add("剧照");
        strings.add("影评");
        fragments.add(new JieshaoFragment());
        fragments.add(new YugaoFragment());
        fragments.add(new JuzhaoFragment());
        fragments.add(new YingpingFragment());
        xiangqingVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return strings.get(position);
            }
        });
        xiangqingTab.setupWithViewPager(xiangqingVp);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getlayout() {
        return R.layout.activity_xiangqing;
    }

    @Override
    public void onHomeXbannerSuccess(XbannerBean data) {

    }

    @Override
    public void onHomeXbannerFailure(String e) {

    }

    @Override
    public void onHomeZhengzaiSuccess(ZhengzaiBean data) {

    }

    @Override
    public void onHomeZhengzaiFailure(String e) {

    }

    @Override
    public void onHomeJijiangSuccess(JijiangBean data) {

    }

    @Override
    public void onHomeJijiangFailure(String e) {

    }

    @Override
    public void onHomeRemenSuccess(RemenBean data) {

    }

    @Override
    public void onHomeRemenFailure(String e) {

    }

    @Override
    public void onHomeGetXiangqingSuccess(XiangqingBean data) {
        XiangqingBean.ResultBean result = data.getResult();
        tvPingfen.setText(result.getScore() + "分");
        tvPingfen2.setText(result.getCommentNum() + "万条");
        dongzuo.setText(result.getMovieType());
        name.setText(result.getName());
        type.setText(result.getReleaseTime() + "中国大陆");
        time.setText(result.getDuration());
        Glide.with(this).load(result.getImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .into(xiangqingImg1);
    }

    @Override
    public void onHomeGetXiangqingFailure(String e) {

    }

    @Override
    public void onHomeGetSousuoSuccess(SousuoBean data) {

    }

    @Override
    public void onHomeGetSousuoFailure(String e) {

    }

    @Override
    public void onHomeGetYingpingSuccess(YingpingBean data) {

    }

    @Override
    public void onHomeGetYingpingFailure(String e) {

    }

    @Override
    public void onHomeGetTuijianSuccess(TuijianBean data) {

    }

    @Override
    public void onHomeGetTuijianFailure(String e) {

    }

    @Override
    public void onHomeGetFujinSuccess(FujinBean data) {

    }

    @Override
    public void onHomeGetFujinFailure(String e) {

    }

    @Override
    public void onHomeGetYingyuansouSuccess(YingyuanSouBean data) {

    }

    @Override
    public void onHomeGetYingyuansouFailure(String e) {

    }

    @Override
    public void onHomeGetQuyuSuccess(QuyuBean data) {

    }

    @Override
    public void onHomeGetQuyuFailure(String e) {

    }

    @Override
    public void onHomeGetQuyuliebiaoSuccess(QuyuLiebiaoBean data) {

    }

    @Override
    public void onHomeGetQuyuliebiaoFailure(String e) {

    }

    @Override
    public void onHomeGetYingyuanXQSuccess(YingyuanXQBean data) {

    }

    @Override
    public void onHomeGetYingyuanXQFailure(String e) {

    }

    @Override
    public void onHomePostLoginSuccess(LoginBean data) {

    }

    @Override
    public void onHomePostLoginFailure(String e) {

    }

    @Override
    public void onHomeGetPaiqiSuccess(PaiqiBean data) {

    }

    @Override
    public void onHomeGetPaiqiFailure(String e) {

    }

    @Override
    public void onHomeGetPaiqishowSuccess(PaiqiShowBean data) {

    }

    @Override
    public void onHomeGetPaiqishowFailure(String e) {

    }

    @Override
    public void onHomeGetZuoSuccess(ZuoBean data) {

    }

    @Override
    public void onHomeGetZuoFailure(String e) {

    }

    @Override
    public void onHomeGetBuySuccess(BuyBean data) {

    }

    @Override
    public void onHomeGetBuyFailure(String e) {

    }

    @Override
    public void onHomeGetGoupiaoSuccess(GoupiaoBean data) {

    }

    @Override
    public void onHomeGetGoupiaoFailure(String e) {

    }

    @Override
    public void onHomeGetZhifuSuccess(ZhifuBean data) {

    }

    @Override
    public void onHomeGetZhifuFailure(String e) {

    }

    @Override
    public void onHomeGetRegisterSuccess(RegisterBean data) {

    }

    @Override
    public void onHomeGetRegisterFailure(String e) {

    }

    @Override
    public void onHomeGetCodeSuccess(CodeBean data) {

    }

    @Override
    public void onHomeGetCodeFailure(String e) {

    }

    @Override
    public void onHomeGetXieyingpingSuccess(XieyingpingBean data) {

    }

    @Override
    public void onHomeGetXieyingpingFailure(String e) {

    }
}
