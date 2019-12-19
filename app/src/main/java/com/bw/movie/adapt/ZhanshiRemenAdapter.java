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
import com.bw.movie.bean.RemenBean;

import java.util.List;

public class ZhanshiRemenAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<RemenBean.ResultBean> list;
    Context context;
    public final int ONETYPE=0;
    public final int TWOTYPE=1;
    private int viewType;

    public ZhanshiRemenAdapter(FragmentActivity activity, List<RemenBean.ResultBean> result) {
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
            View inflate = LayoutInflater.from(context).inflate(R.layout.zhanshiremen1_layout, viewGroup, false);
            return new myViewHolder(inflate);
        }else if (i==TWOTYPE){
            View inflate1 = LayoutInflater.from(context).inflate(R.layout.zhanshiremen2_layout, viewGroup, false);
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
                    ((myViewHolder) viewHolder).remen_text_1.setText(list.get(i).getScore()+"分");
                    ((myViewHolder) viewHolder).remen_text_11.setText(list.get(i).getName());
                    Glide.with(context).load(list.get(i).getImageUrl()).into(((myViewHolder) viewHolder).remen_img_1);
                    viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onItemClickListener.onItemClick(v,i);
                        }
                    });
                }
                break;
            case TWOTYPE:
                if (viewHolder instanceof myViewHolder1){
                    ((myViewHolder1) viewHolder).remen_text_2.setText(list.get(i).getScore()+"分");
                    ((myViewHolder1) viewHolder).remen_text_22.setText(list.get(i).getName());
                    Glide.with(context).load(list.get(i).getImageUrl()).into(((myViewHolder1) viewHolder).remen_img_2);
                    viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onItemClickListener.onItemClick(v,i);
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
        void onItemClick(View v,int i);
        void onItemLongClick(View v,int i);
    }

    private class myViewHolder extends RecyclerView.ViewHolder {


        private final ImageView remen_img_1;
        private final TextView remen_text_1;
        private final TextView remen_text_11;

        public myViewHolder(View inflate) {
            super(inflate);
            remen_img_1 = inflate.findViewById(R.id.remen_img_1);
            remen_text_1 = inflate.findViewById(R.id.remen_text_1);
            remen_text_11 = inflate.findViewById(R.id.remen_text_11);
        }
    }

    private class myViewHolder1 extends RecyclerView.ViewHolder {


        private final ImageView remen_img_2;
        private final TextView remen_text_2;
        private final TextView remen_text_22;

        public myViewHolder1(View inflate1) {
            super(inflate1);
            remen_img_2 = inflate1.findViewById(R.id.remen_img_2);
            remen_text_2 = inflate1.findViewById(R.id.remen_text_2);
            remen_text_22 = inflate1.findViewById(R.id.remen_text_22);
        }
    }
}
