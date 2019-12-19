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

public class SouZhanshiRemenFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<RemenBean.ResultBean> list;
    Context context;
    public SouZhanshiRemenFragmentAdapter(FragmentActivity activity, List<RemenBean.ResultBean> result) {
        this.list=result;
        this.context=activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.szsrmfa_layout, viewGroup, false);
        return new myViewHolderGuang(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        if (viewHolder instanceof myViewHolderGuang){
            ((myViewHolderGuang) viewHolder).guang_name.setText(list.get(i).getName());
            ((myViewHolderGuang) viewHolder).guang_daoyan.setText(list.get(i).getDirector());
            ((myViewHolderGuang) viewHolder).guang_yanyuan.setText(list.get(i).getStarring());
            ((myViewHolderGuang) viewHolder).guang_pingfen.setText(list.get(i).getScore()+"评分");
            Glide.with(context).load(list.get(i).getImageUrl()).into(((myViewHolderGuang) viewHolder).guang_img);
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

    private class myViewHolderGuang extends RecyclerView.ViewHolder {

        private final ImageView guang_img;
        private final TextView guang_name;
        private final TextView guang_daoyan;
        private final TextView guang_yanyuan;
        private final TextView guang_pingfen;

        public myViewHolderGuang(View inflate) {
            super(inflate);
            guang_img = inflate.findViewById(R.id.szsrmfa_img);
            guang_name = inflate.findViewById(R.id.szsrmfa_name);
            guang_daoyan = inflate.findViewById(R.id.szsrmfa_daoyan);
            guang_yanyuan = inflate.findViewById(R.id.szsrmfa_yanyuan);
            guang_pingfen = inflate.findViewById(R.id.szsrmfa_pingfen);
        }
    }
}
