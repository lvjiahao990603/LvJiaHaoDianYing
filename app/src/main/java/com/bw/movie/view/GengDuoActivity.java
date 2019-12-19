package com.bw.movie.view;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.soufrag.SouZhanshiJijiangFragment;
import com.bw.movie.soufrag.SouZhanshiRemenFragment;
import com.bw.movie.soufrag.SouZhanshiZhengzaiFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;

public class GengDuoActivity extends BaseActivity {

    @BindView(R.id.jiantou)
    ImageView jiantou;
    @BindView(R.id.et_sousuo)
    EditText etSousuo;
    @BindView(R.id.sou_tab)
    TabLayout souTab;
    @BindView(R.id.sou_vp)
    ViewPager souVp;
    ArrayList<String> strings = new ArrayList<>();
    ArrayList<Fragment> fragments = new ArrayList<>();
    @Override
    protected void initData() {
        strings.add("正在热映");
        strings.add("即将上映");
        strings.add("热门电影");

        fragments.add(new SouZhanshiZhengzaiFragment());
        fragments.add(new SouZhanshiJijiangFragment());
        fragments.add(new SouZhanshiRemenFragment());
        etSousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GengDuoActivity.this, SearchAvtivity.class);
                startActivity(intent);
            }
        });
        jiantou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        souVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
        souTab.setupWithViewPager(souVp);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getlayout() {
        return R.layout.activity_geng_duo;
    }
}
