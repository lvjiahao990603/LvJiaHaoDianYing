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
import com.bw.movie.bean.ZhengzaiBean;

import java.util.List;

public class SouZhanshiZhengzaiFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<ZhengzaiBean.ResultBean> list;
    Context context;
    public SouZhanshiZhengzaiFragmentAdapter(FragmentActivity activity, List<ZhengzaiBean.ResultBean> result) {
        this.list=result;
        this.context=activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.szszzfa_layout, viewGroup, false);
        return new myViewHolderGuo(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        if (viewHolder instanceof myViewHolderGuo){
            ((myViewHolderGuo) viewHolder).guo_name.setText(list.get(i).getName());
            ((myViewHolderGuo) viewHolder).guo_daoyan.setText(list.get(i).getDirector());
            ((myViewHolderGuo) viewHolder).guo_yanyuan.setText(list.get(i).getStarring());
            ((myViewHolderGuo) viewHolder).guo_pingfen.setText(list.get(i).getScore()+"分");
            Glide.with(context).load(list.get(i).getImageUrl()).into(((myViewHolderGuo) viewHolder).guo_img);
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

    private class myViewHolderGuo extends RecyclerView.ViewHolder {

        private final TextView guo_name;
        private final TextView guo_daoyan;
        private final TextView guo_yanyuan;
        private final TextView guo_pingfen;
        private final ImageView guo_img;

        public myViewHolderGuo(View inflate) {
            super(inflate);
            guo_name = inflate.findViewById(R.id.szszzfa_name);
            guo_daoyan = inflate.findViewById(R.id.szszzfa_daoyan);
            guo_yanyuan = inflate.findViewById(R.id.szszzfa_yanyuan);
            guo_pingfen = inflate.findViewById(R.id.szszzfa_pingfen);
            guo_img = inflate.findViewById(R.id.szszzfa_img);
        }
    }
}
