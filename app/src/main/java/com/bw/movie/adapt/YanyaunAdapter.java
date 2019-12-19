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

public class YanyaunAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<XiangqingBean.ResultBean.MovieActorBean> list;
    Context context;
    public YanyaunAdapter(FragmentActivity activity, List<XiangqingBean.ResultBean.MovieActorBean> movieActor) {
        this.list=movieActor;
        this.context=activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.yanyuan_layout, viewGroup, false);
        return new myViewHolderYanyuan(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof myViewHolderYanyuan){
            ((myViewHolderYanyuan) viewHolder).yanyuan_name.setText(list.get(i).getName());
            Glide.with(context).load(list.get(i).getPhoto()).into(((myViewHolderYanyuan) viewHolder).yanyuan_photo);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class myViewHolderYanyuan extends RecyclerView.ViewHolder {

        private final TextView yanyuan_name;
        private final ImageView yanyuan_photo;

        public myViewHolderYanyuan(View inflate) {
            super(inflate);
            yanyuan_name = inflate.findViewById(R.id.yanyuan_name);
            yanyuan_photo = inflate.findViewById(R.id.yanyuan_photo);
        }
    }
}
