package com.bw.movie.view;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.frag.MovieFragment;
import com.bw.movie.frag.MyFragment;
import com.bw.movie.frag.YingyuanFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;

public class ZhuActivity extends BaseActivity {

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tab)
    TabLayout tab;
    ArrayList<Fragment>fragments=new ArrayList<>();
    ArrayList<String>strings=new ArrayList<>();
    @Override
    protected void initData() {
        fragments.add(new MovieFragment());
        fragments.add(new YingyuanFragment());
        fragments.add(new MyFragment());
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setIcon(R.mipmap.movie_red);
        tab.getTabAt(1).setIcon(R.mipmap.yingyuan_red);
        tab.getTabAt(2).setIcon(R.mipmap.my_red);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getlayout() {
        return R.layout.activity_zhu;
    }
}
