package com.bw.movie.soufrag;

import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapt.SouZhanshiJijiangFragmentAdapter;
import com.bw.movie.base.BaseFragment;
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
import com.bw.movie.view.XiangqingActivity;

import java.util.List;

import butterknife.BindView;

public class SouZhanshiJijiangFragment extends BaseFragment implements IHomeContract.Iview {

    @BindView(R.id.recy_SouZhanshiJijiangFragmentAdapter)
    RecyclerView recySouZhanshiJijiangFragmentAdapter;
    private HomePresenter homePresenter;

    @Override
    protected void initData() {
        homePresenter = new HomePresenter();
        homePresenter.attach(this);
        homePresenter.getJijiangPresenter("1", "20");
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getlayout() {
        return R.layout.activity_sou_zhanshi_jijiang_fragment;
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
        List<JijiangBean.ResultBean> result = data.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recySouZhanshiJijiangFragmentAdapter.setLayoutManager(linearLayoutManager);
        SouZhanshiJijiangFragmentAdapter souZhanshiJijiangFragmentAdapter = new SouZhanshiJijiangFragmentAdapter(getActivity(), result);
        recySouZhanshiJijiangFragmentAdapter.setAdapter(souZhanshiJijiangFragmentAdapter);
        souZhanshiJijiangFragmentAdapter.setOnItemClickListener(new SouZhanshiJijiangFragmentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int i) {
                String movieId = result.get(i).getMovieId();
                Intent intent = new Intent(getActivity(), XiangqingActivity.class);
                intent.putExtra("movieId",movieId);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View v, int i) {

            }
        });
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
