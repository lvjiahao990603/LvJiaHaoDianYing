package com.bw.movie.adapt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.SousuoBean;
import com.bw.movie.view.SearchAvtivity;

import java.util.List;

public class SearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<SousuoBean.ResultBean> list;
    Context context;
    public SearAdapter(SearchAvtivity searchAvtivity, List<SousuoBean.ResultBean> result) {
        this.list=result;
        this.context=searchAvtivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.searadapter_layout, viewGroup, false);
        return new myViewHolderSearch(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        if (viewHolder instanceof myViewHolderSearch){
            ((myViewHolderSearch) viewHolder).search_name.setText(list.get(i).getName());
            ((myViewHolderSearch) viewHolder).search_daoyan.setText(list.get(i).getDirector());
            ((myViewHolderSearch) viewHolder).search_yanyuan.setText(list.get(i).getStarring());
            ((myViewHolderSearch) viewHolder).search_pingfen.setText(list.get(i).getScore()+"评分");
            Glide.with(context).load(list.get(i).getImageUrl()).into(((myViewHolderSearch) viewHolder).search_img);
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
        if (list!=null){
            return list.size();
        }else {
            Toast.makeText(context, "未搜索到相关的电影", Toast.LENGTH_SHORT).show();
        }
        return 0;
    }



    public OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
    public interface OnItemClickListener{
        void onItemClick(View v,int i);
        void onItemLongClick(View v,int i);
    }

    private class myViewHolderSearch extends RecyclerView.ViewHolder {

        private final ImageView search_img;
        private final TextView search_name;
        private final TextView search_daoyan;
        private final TextView search_yanyuan;
        private final TextView search_pingfen;

        public myViewHolderSearch(View inflate) {
            super(inflate);
            search_img = inflate.findViewById(R.id.search_img);
            search_name = inflate.findViewById(R.id.search_name);
            search_daoyan = inflate.findViewById(R.id.search_daoyan);
            search_yanyuan = inflate.findViewById(R.id.search_yanyuan);
            search_pingfen = inflate.findViewById(R.id.search_pingfen);
        }
    }
}
