package com.bw.movie.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends BaseActivity implements IHomeContract.Iview {
    private static final String TAG = "RegisterActivity";
    @BindView(R.id.edit_nickname)
    EditText editNickname;
    @BindView(R.id.edit_email)
    EditText editEmail;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.yan)
    ImageView yan;
    @BindView(R.id.edit_youxiang)
    EditText editYouxiang;
    @BindView(R.id.but_code)
    Button butCode;
    @BindView(R.id.text_dl)
    TextView textDl;
    @BindView(R.id.but_register)
    Button butRegister;
    @BindView(R.id.register_jian)
    ImageView registerJian;
    private HomePresenter homePresenter;
    private String message;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        //返回
        registerJian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        yan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        });
        homePresenter = new HomePresenter();
        if (homePresenter != null) {
            homePresenter.attach(this);

        }
        //获取验证码
        butCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取邮箱
                String email = editEmail.getText().toString();
                if (email != null) {
                    homePresenter.getCodePresenter(email);
                } else {
                    Toast.makeText(RegisterActivity.this, "请输入正确的邮箱格式", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //注册
        butRegister.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this, "", Toast.LENGTH_SHORT).show();
                String name = editNickname.getText().toString();
                String ema = editEmail.getText().toString();
                String pwd = editPassword.getText().toString();
                String code = editYouxiang.getText().toString();
                String encrypt = EncryptUtil.encrypt(pwd);
                Log.d(TAG, "onClick1: " + ema);
                Log.d(TAG, "name: " + name);
                Log.d(TAG, "pwd: " + pwd);
                Log.d(TAG, "code: " + code);
                Log.d(TAG, "encrypt: " + encrypt);
                if (!name.isEmpty() && !encrypt.isEmpty() && !ema.isEmpty() && !code.isEmpty()) {
                    Log.d(TAG, "onClick2: " + ema);
                    homePresenter.getRegisterPresenter(name, encrypt, ema, code);
                } else {
                    Toast.makeText(RegisterActivity.this, "请填写正确的格式", Toast.LENGTH_SHORT).show();
                }
            }
        });
        textDl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

    }

    @Override
    protected int getlayout() {
        return R.layout.activity_register;
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
        RegisterBean registerBean = data;
        Toast.makeText(this, "" + data.getMessage(), Toast.LENGTH_SHORT).show();
        message = data.getMessage();
        Log.d(TAG, "RegisSuccess: " + message);
        if (message.contains("注册成功")) {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

            finish();
        }
    }

    @Override
    public void onHomeGetRegisterFailure(String e) {

    }

    @Override
    public void onHomeGetCodeSuccess(CodeBean data) {
        String message = data.getMessage();
        Log.d(TAG, "RegisSuccessY: " + message);
        Toast.makeText(this, "" + data.getMessage(), Toast.LENGTH_SHORT).show();
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
