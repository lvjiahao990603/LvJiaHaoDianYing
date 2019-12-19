package com.bw.movie.adapt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.XiangqingBean;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class YugaoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<XiangqingBean.ResultBean.ShortFilmListBean> list;
    Context context;
    public YugaoAdapter(FragmentActivity activity, List<XiangqingBean.ResultBean.ShortFilmListBean> shortFilmList) {
        this.list=shortFilmList;
        this.context=activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.yugaoadapter_layout, parent, false);
        return new myViewHolderYugao(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof YugaoAdapter.myViewHolderYugao){
            String videoUrl = list.get(position).getVideoUrl();
            ((myViewHolderYugao) holder).jiecaoa.setUp(videoUrl,null);
            Glide.with(context).load(list.get(position).getImageUrl())
                    .into(((myViewHolderYugao) holder).jiecaoa.ivThumb);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class myViewHolderYugao extends RecyclerView.ViewHolder {

        private final JCVideoPlayer jiecaoa;

        public myViewHolderYugao(View inflate) {
            super(inflate);
            jiecaoa = itemView.findViewById(R.id.jiecaoa);
        }
    }
}
