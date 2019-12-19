package com.bw.movie.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bw.movie.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private  int reclen=5;
    Timer timer = new Timer();
    private Handler handler;
    private Runnable runnable;
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        //定义全屏显示
        int flag=  WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗前为全屏
        getWindow().setFlags(flag,flag);
        initview();
        timer.schedule(task,1000,1000);//停顿一秒
        handler = new Handler();
        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                //从闪屏界面跳转到电影首界面
                Intent intent = new Intent(MainActivity.this, ZhuActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);//延迟5S后发送handler信息

    }

    private void initview() {
        tv = findViewById(R.id.tv);
        tv.setOnClickListener(MainActivity.this);

    }
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    reclen--;
                    tv.setText("广告"+reclen);
                    if (reclen<0){
                        timer.cancel();
                        tv.setVisibility(View.GONE);//隐藏字体
                    }
                }
            });
        }
    };
    /*
       点击跳转
        */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv:
                Intent intent = new Intent(MainActivity.this, ZhuActivity.class);
                startActivity(intent);
                finish();
                if (runnable!=null){
                    handler.removeCallbacks(runnable);
                }
                break;
            default:
                break;
        }
    }

}
