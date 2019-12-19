package com.bw.movie.frag;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.adapt.ZhanshiJijiangAdapter;
import com.bw.movie.adapt.ZhanshiRemenAdapter;
import com.bw.movie.adapt.ZhanshiZhengzaiAdapter;
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
import com.bw.movie.view.GengDuoActivity;
import com.bw.movie.view.SearchAvtivity;
import com.bw.movie.view.XiangqingActivity;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;

public class MovieFragment extends BaseFragment implements IHomeContract.Iview {
    @BindView(R.id.img_location)
    ImageButton imgLocation;
    @BindView(R.id.textdw)
    TextView textdw;
    @BindView(R.id.img_search)
    ImageButton imgSearch;
    @BindView(R.id.xba)
    XBanner xba;
    @BindView(R.id.tv_page)
    TextView tvPage;
    @BindView(R.id.zhengzai_gengduo)
    TextView zhengzaiGengduo;
    @BindView(R.id.recy_zhengzai)
    RecyclerView recyZhengzai;
    @BindView(R.id.jijiang_gengduo)
    TextView jijiangGengduo;
    @BindView(R.id.recy_jijiang)
    RecyclerView recyJijiang;
    @BindView(R.id.remen_gengduo)
    TextView remenGengduo;
    @BindView(R.id.img_1)
    ImageView img1;
    @BindView(R.id.recy_remen)
    RecyclerView recyRemen;
//    @BindView(R.id.sim)
//    SimpleDraweeView sim;
private AMapLocationClient mlocationClient;
    private AMapLocationClientOption mLocationOption;
    private int GPS_REQUEST_CODE = 10;
    private HomePresenter homePresenter;
    private LinearLayoutManager linearLayoutManager;
    private LinearLayoutManager linearLayoutManager1;
    private LinearLayoutManager linearLayoutManager2;

    @Override
    protected void initData() {

        homePresenter = new HomePresenter();
        homePresenter.attach(this);
        homePresenter.getXbannerPresenter();
        homePresenter.getZhengzaiPresenter("1", "10");
        homePresenter.getJijiangPresenter("1", "5");
        homePresenter.getRemenPresenter("1", "20");
        //右上搜索
        imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchAvtivity.class);
                startActivity(intent);
            }
        });
        //正在更多
        zhengzaiGengduo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GengDuoActivity.class);
                startActivity(intent);
            }
        });
        //即将更多
        jijiangGengduo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GengDuoActivity.class);
                startActivity(intent);
            }
        });
        //热门更多
        remenGengduo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GengDuoActivity.class);
                startActivity(intent);
            }
        });
        imgLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {//未开启定位权限
                    //开启定位权限,200是标识码
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
                } else {
                    MyLocation(getActivity());//开始定位
                }
            }

        });

    }

    //定位
    public void MyLocation(final Context context) {
        mlocationClient = new AMapLocationClient(getActivity());
        mLocationOption = new AMapLocationClientOption();
        mlocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation amapLocation) {
                try {
                    if (amapLocation != null) {
                        if (amapLocation.getErrorCode() == 0) {
                            //定位成功回调信息，设置相关消息

                            //获取当前定位结果来源，如网络定位结果，详见定位类型表
                            Log.i("定位类型", amapLocation.getLocationType() + "");
                            Log.i("获取纬度", amapLocation.getLatitude() + "");
                            Log.i("获取经度", amapLocation.getLongitude() + "");
                            Log.i("获取精度信息", amapLocation.getAccuracy() + "");
                            //如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                            Log.i("地址", amapLocation.getAddress());
                            Log.i("国家信息", amapLocation.getCountry());
                            Log.i("省信息", amapLocation.getProvince());
                            Log.i("城市信息", amapLocation.getCity());
                            Log.i("城区信息", amapLocation.getDistrict());
                            Log.i("街道信息", amapLocation.getStreet());
                            Log.i("街道门牌号信息", amapLocation.getStreetNum());
                            Log.i("城市编码", amapLocation.getCityCode());
                            Log.i("地区编码", amapLocation.getAdCode());
                            Log.i("获取当前定位点的AOI信息", amapLocation.getAoiName());
                            Log.i("获取当前室内定位的建筑物Id", amapLocation.getBuildingId());
                            Log.i("获取当前室内定位的楼层", amapLocation.getFloor());
                            Log.i("获取GPS的当前状态", amapLocation.getGpsAccuracyStatus() + "");
                            //获取定位时间
                            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            Date date = new Date(amapLocation.getTime());
                            Log.i("获取定位时间", df.format(date));
                            textdw.setText(amapLocation.getDistrict());
                            textdw.setTextColor(Color.parseColor("#FFFFFF"));
                            // 停止定位
                            mlocationClient.stopLocation();
                        } else {
                            //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                            Log.e("AmapError", "location Error, ErrCode:"
                                    + amapLocation.getErrorCode() + ", errInfo:"
                                    + amapLocation.getErrorInfo());
                            Toast.makeText(context, "没有权限，请打开权限...", Toast.LENGTH_SHORT).show();
                            new AlertDialog.Builder(context)
                                    .setTitle("定位服务未开启")
                                    .setMessage("请在系统设置中开启定位服务\n" +
                                            "以便为您提供更好的服务")
                                    .setPositiveButton("设置", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                            startActivityForResult(intent, GPS_REQUEST_CODE);
                                        }
                                    })
                                    .show();
                        }
                    }
                } catch (Exception e) {
                }

            }
        });
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mLocationOption.setInterval(5000);
        //设置定位参数
        mlocationClient.setLocationOption(mLocationOption);
        //启动定位
        mlocationClient.startLocation();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {//未开启定位权限
            //开启定位权限,200是标识码
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);

        } else {
            MyLocation(getActivity());//开始定位
            //Toast.makeText(getActivity(),"已开启定位权限",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        // 停止定位
        if (null != mlocationClient) {
            mlocationClient.stopLocation();
        }
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getlayout() {
        return R.layout.moviefragment;
    }

    @Override
    public void onHomeXbannerSuccess(XbannerBean data) {
        //Xbanner
        List<XbannerBean.ResultBean> result = data.getResult();
        xba.setData(result, null);
        xba.setPageChangeDuration(2000);
        xba.setPageTransformer(Transformer.Default);
        xba.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(getActivity()).load(result.get(position).getImageUrl()).into((ImageView) view);
//                Uri uri = Uri.parse(result.get(position).getImageUrl());
//                sim.setImageURI(uri);
                //文字展示
                tvPage.setText(result.get(position).getRank() + "/5");
            }
        });
    }

    @Override
    public void onHomeXbannerFailure(String e) {

    }

    @Override
    public void onHomeZhengzaiSuccess(ZhengzaiBean data) {
        //正在
        List<ZhengzaiBean.ResultBean> result = data.getResult();
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyZhengzai.setLayoutManager(linearLayoutManager);
        ZhanshiZhengzaiAdapter zhanshiZhengzaiAdapter = new ZhanshiZhengzaiAdapter(result, getActivity());
        recyZhengzai.setAdapter(zhanshiZhengzaiAdapter);
        zhanshiZhengzaiAdapter.setOnItemClickListener(new ZhanshiZhengzaiAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int i) {
                String movieId = result.get(i).getMovieId();
                Intent intent = new Intent(getActivity(), XiangqingActivity.class);
                intent.putExtra("movieId", movieId);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View v, int i) {

            }
        });
    }

    @Override
    public void onHomeZhengzaiFailure(String e) {

    }

    @Override
    public void onHomeJijiangSuccess(JijiangBean data) {
        //即将
        List<JijiangBean.ResultBean> result = data.getResult();
        linearLayoutManager1 = new LinearLayoutManager(getActivity());
        recyJijiang.setLayoutManager(linearLayoutManager1);
        ZhanshiJijiangAdapter zhanshiJijiangAdapter = new ZhanshiJijiangAdapter(getActivity(), result);
        recyJijiang.setAdapter(zhanshiJijiangAdapter);
        //跳转详情
        zhanshiJijiangAdapter.setOnItemClickListener(new ZhanshiJijiangAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String movieId) {
                Intent intent = new Intent(getActivity(),XiangqingActivity.class);
                intent.putExtra("movieId",movieId);
                Log.d("zxa", "onItemClick: "+movieId);
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
        //热门
        List<RemenBean.ResultBean> result = data.getResult();
        linearLayoutManager2 = new LinearLayoutManager(getActivity());
        linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyRemen.setLayoutManager(linearLayoutManager2);
        ZhanshiRemenAdapter zhanshiRemenAdapter = new ZhanshiRemenAdapter(getActivity(), result);
        recyRemen.setAdapter(zhanshiRemenAdapter);
        //上面的展示
        Glide.with(getActivity()).load(result.get(1).getHorizontalImage())
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher_round)
                .into(img1);
        zhanshiRemenAdapter.setOnItemClickListener(new ZhanshiRemenAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int i) {
                String movieId = result.get(i).getMovieId();
                Intent intent = new Intent(getActivity(), XiangqingActivity.class);
                intent.putExtra("movieId", movieId);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View v, int i) {

            }
        });

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
