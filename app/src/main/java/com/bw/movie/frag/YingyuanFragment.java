package com.bw.movie.frag;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.view.YingyuansouActivity;
import com.bw.movie.yingyuanfrag.FujinFragment;
import com.bw.movie.yingyuanfrag.NameFragment;
import com.bw.movie.yingyuanfrag.TuijianFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;

public class YingyuanFragment extends BaseFragment {
    @BindView(R.id.et_yy_sou)
    EditText etYySou;
    @BindView(R.id.yyf_tab)
    TabLayout yyfTab;
    @BindView(R.id.yyf_vp)
    ViewPager yyfVp;
    ArrayList<String> strings = new ArrayList<>();
    ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected void initData() {
        //点击输入框跳转
        etYySou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), YingyuansouActivity.class);
                startActivity(intent);
            }
        });
        strings.add("推荐影院");
        strings.add("附近影院");
        strings.add("海淀区▼");
        fragments.add(new TuijianFragment());
        fragments.add(new FujinFragment());
        fragments.add(new NameFragment());

        yyfVp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
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
        yyfTab.setupWithViewPager(yyfVp);
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getlayout() {
        return R.layout.yingyuanfragment;
    }
}
