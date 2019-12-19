package com.bw.movie.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.adapt.XinxiAdapter;
import com.bw.movie.adapt.ZuoAdapter;
import com.bw.movie.app.App;
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
import com.tencent.mm.opensdk.modelpay.PayReq;

import java.util.List;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class CheckBoxActivity extends BaseActivity implements IHomeContract.Iview {

    private static final String TAG = "CheckBox";
    private String s1;

    @BindView(R.id.selection_fanhui)
    ImageView selectionFanhui;
    @BindView(R.id.selection_biaoti)
    TextView selectionBiaoti;
    @BindView(R.id.lin_bu)
    LinearLayout linBu;
    @BindView(R.id.selection_jcvideoplayer)
    JCVideoPlayer selectionJcvideoplayer;
    @BindView(R.id.selection_recyclerxuanzuo)
    RecyclerView selectionRecyclerxuanzuo;
    @BindView(R.id.cb_cinemaseatkexuan)
    CheckBox cbCinemaseatkexuan;
    @BindView(R.id.cb_cinemaseatyishou)
    CheckBox cbCinemaseatyishou;
    @BindView(R.id.cb_cinemaseat_xuanzhong)
    CheckBox cbCinemaseatXuanzhong;
    @BindView(R.id.linerview)
    LinearLayout linerview;
    @BindView(R.id.selection_xt)
    TextView selectionXt;
    @BindView(R.id.selection_recyclerxinxi)
    RecyclerView selectionRecyclerxinxi;
    @BindView(R.id.selection_zhifubtn)
    Button selectionZhifubtn;
    private String scheduleIds;
    private HomePresenter homePresenter;
    private GridLayoutManager gridLayoutManager;
    private LinearLayoutManager linearLayoutManager;
    private String movieId;
    private String cinimaId;
    private SharedPreferences sharedPreferences;


    @Override
    protected void initData() {
        Intent intent = getIntent();
        movieId = intent.getStringExtra("movieId");
        cinimaId = getIntent().getStringExtra("cinimaId");
        Log.d(TAG, "initData: "+ cinimaId + movieId);
        homePresenter = new HomePresenter();
        homePresenter.attach(this);
        homePresenter.getBuyPresenter("7","24");
        homePresenter.getXiangqingPresenter("13918", "157663996839813918", movieId);

        //返回
        selectionFanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        sharedPreferences = getSharedPreferences("config", MODE_PRIVATE);

        selectionZhifubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 int userId = 13918;
                 String sessionId = "157663996839813918";
                Log.d(TAG, "onClick: "+ userId);
                Log.d(TAG, "onClick: "+ sessionId);
                Log.d(TAG, "s1: "+s1);
                String s = String.valueOf(userId);
                String md5 = com.bw.movie.presenter.MD5.MD5( s+scheduleIds+"movie");
                Log.d(TAG, "onClick: "+scheduleIds);
                homePresenter.getGoupiaoPresenter(s, sessionId,scheduleIds,s1,md5);

            }
        });

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getlayout() {
        return R.layout.activity_check_box;
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
        selectionBiaoti.setText(result.getName());
        selectionJcvideoplayer.setUp(result.getShortFilmList().get(0).getVideoUrl(),null);
        Glide.with(this).load(result.getShortFilmList().get(0).getImageUrl()).into(selectionJcvideoplayer.ivThumb);
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
        List<ZuoBean.ResultBean> result = data.getResult();
        gridLayoutManager = new GridLayoutManager(CheckBoxActivity.this, 8);
        selectionRecyclerxuanzuo.setLayoutManager(gridLayoutManager);
        ZuoAdapter zuoAdapter = new ZuoAdapter(CheckBoxActivity.this, result);
        selectionRecyclerxuanzuo.setAdapter(zuoAdapter);
        zuoAdapter.setMzuoitem(new ZuoAdapter.zuoitem() {
            @Override
            public void onZuoItem(String s) {
                s1 = s;
            }
        });

    }

    @Override
    public void onHomeGetZuoFailure(String e) {

    }

    @Override
    public void onHomeGetBuySuccess(BuyBean data) {
        Log.d(TAG, "onHomeGetBuySuccess: "+data.getMessage());
        List<BuyBean.ResultBean> result = data.getResult();
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        selectionRecyclerxinxi.setLayoutManager(linearLayoutManager);
        XinxiAdapter xinxiAdapter = new XinxiAdapter(this, result);
        selectionRecyclerxinxi.setAdapter(xinxiAdapter);
        xinxiAdapter.setMitemClickLister(new XinxiAdapter.ItemClickLister() {



            @Override
            public void onitemClick(String hallId, String scheduleId) {
                scheduleIds = scheduleId;
                homePresenter.getZuoPresenter(hallId);
            }
        });
    }

    @Override
    public void onHomeGetBuyFailure(String e) {

    }

    @Override
    public void onHomeGetGoupiaoSuccess(GoupiaoBean data) {
        String orderId = data.getOrderId();
        Log.d(TAG, "orderId: "+orderId);
        if (orderId!=null){
            homePresenter.getZhifuPresenter("13918", "157658905767813918","1",orderId);
        }
    }

    @Override
    public void onHomeGetGoupiaoFailure(String e) {

    }

    @Override
    public void onHomeGetZhifuSuccess(ZhifuBean data) {
        Log.d(TAG, "onZhiFuSuccess: "+data.getMessage());
        if (data.getStatus().equals("0000")) {
            PayReq req = new PayReq();
            req.appId = data.getAppId();
            req.partnerId = data.getPartnerId();
            req.prepayId = data.getPrepayId();
            req.nonceStr = data.getNonceStr();
            req.timeStamp = data.getTimeStamp();
            req.packageValue = data.getPackageValue();
            req.sign = data.getSign();
            App.api.sendReq(req);
        }
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
