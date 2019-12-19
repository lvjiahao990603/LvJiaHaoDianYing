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
import com.bw.movie.bean.JijiangBean;

import java.util.List;

public class ZhanshiJijiangAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<JijiangBean.ResultBean> list;
    Context context;
    public final int ONETYPE=0;
    public final int TWOTYPE=1;
    private int viewType;

    public ZhanshiJijiangAdapter(FragmentActivity activity, List<JijiangBean.ResultBean> result) {
        this.list=result;
        this.context=activity;
    }

    @Override
    public int getItemViewType(int position) {
        if (position%2==0){
            return ONETYPE;
        }else {
            return TWOTYPE;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i==ONETYPE){
            View inflate = LayoutInflater.from(context).inflate(R.layout.zhanshijijiang1_layout, viewGroup, false);
            return new myViewHolder(inflate);
        }else if (i==TWOTYPE){
            View inflate1 = LayoutInflater.from(context).inflate(R.layout.zhanshijijiang2_layout, viewGroup, false);
            return new myViewHolder1(inflate1);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        viewType = getItemViewType(i);
        switch (viewType){
            case ONETYPE:
                if (viewHolder instanceof myViewHolder){
                    ((myViewHolder) viewHolder).jijiang_text_1.setText(list.get(i).getName());
                    ((myViewHolder) viewHolder).jijiang_text_11.setText(list.get(i).getWhetherReserve());
                    ((myViewHolder) viewHolder).jijiang_text_111.setText(list.get(i).getWantSeeNum());
                    Glide.with(context).load(list.get(i).getImageUrl()).into(((myViewHolder) viewHolder).jijiang_img_1);
                    viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String movieId = list.get(i).getMovieId();
                            onItemClickListener.onItemClick(movieId);
                        }
                    });
                }
                break;
            case TWOTYPE:
                if (viewHolder instanceof myViewHolder1){
                    ((myViewHolder1) viewHolder).jijiang_text_2.setText(list.get(i).getName());
                    ((myViewHolder1) viewHolder).jijiang_text_22.setText(list.get(i).getWhetherReserve());
                    ((myViewHolder1) viewHolder).jijiang_text_222.setText(list.get(i).getWantSeeNum());
                    Glide.with(context).load(list.get(i).getImageUrl()).into(((myViewHolder1) viewHolder).jijiang_img_2);
                    viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String movieId = list.get(i).getMovieId();
                            onItemClickListener.onItemClick(movieId);
                        }
                    });
                }
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
        void onItemClick(String movieId);
        void onItemLongClick(View v,int i);
    }

    private class myViewHolder extends RecyclerView.ViewHolder {


        private final ImageView jijiang_img_1;
        private final TextView jijiang_text_1;
        private final TextView jijiang_text_11;
        private final TextView jijiang_text_111;

        public myViewHolder(View inflate) {
            super(inflate);
            jijiang_img_1 = inflate.findViewById(R.id.jijiang_img_1);
            jijiang_text_1 = inflate.findViewById(R.id.jijiang_text_1);
            jijiang_text_11 = inflate.findViewById(R.id.jijiang_text_11);
            jijiang_text_111 = inflate.findViewById(R.id.jijiang_text_111);
        }
    }

    private class myViewHolder1 extends RecyclerView.ViewHolder {


        private final ImageView jijiang_img_2;
        private final TextView jijiang_text_2;
        private final TextView jijiang_text_22;
        private final TextView jijiang_text_222;

        public myViewHolder1(View inflate1) {
            super(inflate1);
            jijiang_img_2 = inflate1.findViewById(R.id.jijiang_img_2);
            jijiang_text_2 = inflate1.findViewById(R.id.jijiang_text_2);
            jijiang_text_22 = inflate1.findViewById(R.id.jijiang_text_22);
            jijiang_text_222 = inflate1.findViewById(R.id.jijiang_text_222);
        }
    }
}
