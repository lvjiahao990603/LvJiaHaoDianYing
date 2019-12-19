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
import com.bw.movie.bean.TuijianBean;

import java.util.List;

public class TuijianAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<TuijianBean.ResultBean> list;
    Context context;
    public TuijianAdapter(FragmentActivity activity, List<TuijianBean.ResultBean> result) {
        this.list=result;
        this.context=activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tuijianadapter_layout, parent, false);
        return new myViewHolderTuijian(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof myViewHolderTuijian){
            ((myViewHolderTuijian) holder).tjyy_name.setText(list.get(position).getName());
            ((myViewHolderTuijian) holder).tjyy_price.setText(list.get(position).getAddress());
            Glide.with(context).load(list.get(position).getLogo()).into(((myViewHolderTuijian) holder).tjyy_image);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = list.get(position).getId();
                    onItemClickListener.onItemClick(id);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
    public interface OnItemClickListener{
        void onItemClick(String id);
    }

    private class myViewHolderTuijian extends RecyclerView.ViewHolder {

        private final TextView tjyy_price;
        private final TextView tjyy_name;
        private final ImageView tjyy_image;

        public myViewHolderTuijian(View inflate) {
            super(inflate);
            tjyy_price = itemView.findViewById(R.id.tjyy_price);
            tjyy_name = itemView.findViewById(R.id.tjyy_name);
            tjyy_image = itemView.findViewById(R.id.tjyy_image);
        }
    }
}
