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

public class SouZhanshiJijiangFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<JijiangBean.ResultBean> list;
    Context context;
    public SouZhanshiJijiangFragmentAdapter(FragmentActivity activity, List<JijiangBean.ResultBean> result) {
        this.list=result;
        this.context=activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.szsjjfa_layout, viewGroup, false);
        return new myViewHolderSoujijiang(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        if (viewHolder instanceof myViewHolderSoujijiang){
            ((myViewHolderSoujijiang) viewHolder).soujijiang_name.setText(list.get(i).getName());
            ((myViewHolderSoujijiang) viewHolder).soujijiang_shangying.setText(list.get(i).getReleaseTime()+"上映");
            ((myViewHolderSoujijiang) viewHolder).soujijiang_xianggkan.setText(list.get(i).getWantSeeNum()+"人想看");
            Glide.with(context).load(list.get(i).getImageUrl()).into(((myViewHolderSoujijiang) viewHolder).soujijiang_img);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String movieId = list.get(i).getMovieId();
                    onItemClickListener.onItemClick(v,i);
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
        void onItemClick(View v,int i);
        void onItemLongClick(View v,int i);
    }

    private class myViewHolderSoujijiang extends RecyclerView.ViewHolder {

        private final ImageView soujijiang_img;
        private final TextView soujijiang_name;
        private final TextView soujijiang_shangying;
        private final TextView soujijiang_xianggkan;

        public myViewHolderSoujijiang(View inflate) {
            super(inflate);
            soujijiang_img = inflate.findViewById(R.id.szsjjfa_img);
            soujijiang_name = inflate.findViewById(R.id.szsjjfa_name);
            soujijiang_shangying = inflate.findViewById(R.id.szsjjfa_shangying);
            soujijiang_xianggkan = inflate.findViewById(R.id.szsjjfa_xaingkan);
        }
    }
}
