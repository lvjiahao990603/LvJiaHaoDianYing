package com.bw.movie.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
import com.bw.movie.presenter.EncryptUtil;
import com.bw.movie.presenter.HomePresenter;
import com.bw.movie.wxapi.WeiXinUtil;
import com.tencent.mm.opensdk.modelmsg.SendAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements IHomeContract.Iview {

    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.ed_pwd)
    EditText edPwd;
    @BindView(R.id.registered)
    TextView registered;
    @BindView(R.id.but_login)
    Button butLogin;
    @BindView(R.id.login_jian)
    ImageView loginJian;
    @BindView(R.id.bt_weixin)
    ImageButton btWeixin;
    private HomePresenter homePresenter;

    @Override
    protected void initData() {
        homePresenter = new HomePresenter();
        homePresenter.attach(this);
        //返回
        loginJian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //注册
        registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        //登录
        butLogin.setOnClickListener(new View.OnClickListener() {

            private String encrypt;

            @Override
            public void onClick(View v) {
                String emils1 = email.getText().toString().trim();
                String pwd1 = edPwd.getText().toString().trim();
                if (TextUtils.isEmpty(emils1) && TextUtils.isEmpty(pwd1)) {
                    Toast.makeText(LoginActivity.this, "输入框为空", Toast.LENGTH_SHORT).show();
                } else {
                    String encrypt = EncryptUtil.encrypt(pwd1);
                    Log.e("tag", "onClick: " + encrypt);
                    homePresenter.postLoginPresenter(emils1, encrypt);
                }

            }
        });
    }

    @Override
    protected void initView() {

    }

    @OnClick({R.id.bt_weixin})
    public void getViewById(View view) {
        switch (view.getId()) {
            case R.id.bt_weixin:
                //微信登录
                weixinLogin();
                break;
            default:
                break;

        }
    }

    private void weixinLogin() {
        //微信登录
        if (!WeiXinUtil.success(this)) {
            Toast.makeText(LoginActivity.this, "请先安装应用", Toast.LENGTH_SHORT).show();
        } else {
            //  验证
            SendAuth.Req req = new SendAuth.Req();
            req.scope = "snsapi_userinfo";
            req.state = "wechat_sdk_demo_test";
            WeiXinUtil.reg(LoginActivity.this).sendReq(req);
        }
    }

    @Override
    protected int getlayout() {
        return R.layout.activity_login;
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
        String message = data.getMessage();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        if (message.contains("登陆成功")) {
            finish();
        }
    }

    /**
     * 邮箱正则校验
     *
     * @param email
     * @return
     */
    public boolean isEmail(String email) {
        if (null == email && "".endsWith(email)) return false;
        Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");//复杂匹配
        Matcher m = p.matcher(email);
        return m.matches();
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
