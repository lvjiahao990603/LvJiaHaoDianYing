package com.bw.movie.adapt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.XiangqingBean;

import java.util.List;

public class JieshaoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<XiangqingBean.ResultBean.MovieDirectorBean> list;
    Context context;
    public JieshaoAdapter(FragmentActivity activity, List<XiangqingBean.ResultBean.MovieDirectorBean> movieDirector) {
        this.list=movieDirector;
        this.context=activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.daoyan_layout, viewGroup, false);
        return new mvViewHolderDaoyan(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof mvViewHolderDaoyan){
            ((mvViewHolderDaoyan) viewHolder).daoyan_name.setText(list.get(i).getName());
            Glide.with(context).load(list.get(i).getPhoto()).into(((mvViewHolderDaoyan) viewHolder).daoyan_photo);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class mvViewHolderDaoyan extends RecyclerView.ViewHolder {

        private final ImageView daoyan_photo;
        private final TextView daoyan_name;

        public mvViewHolderDaoyan(View inflate) {
            super(inflate);
            daoyan_photo = inflate.findViewById(R.id.daoyan_photo);
            daoyan_name = inflate.findViewById(R.id.daoyan_name);
        }
    }
}
