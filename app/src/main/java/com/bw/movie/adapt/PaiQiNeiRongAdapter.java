package com.bw.movie.adapt;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.PaiqiShowBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class PaiQiNeiRongAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<PaiqiShowBean.ResultBean> list;
    Context context;
    public PaiQiNeiRongAdapter(FragmentActivity activity, List<PaiqiShowBean.ResultBean> result) {
        this.list=result;
        this.context=activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.paiqineirongadapter_layout, parent, false);
        return new myViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof PaiQiNeiRongAdapter.myViewHolder) {
            if (list != null) {
                ((myViewHolder) holder).times_text1.setText(list.get(position).getName());
                ((myViewHolder) holder).times_text2.setText(list.get(position).getDirector());
                ((myViewHolder) holder).times_text3.setText(list.get(position).getStarring());
                ((myViewHolder) holder).times_text4.setText(list.get(position).getScore() + "");
                String imageUrl = list.get(position).getImageUrl();
                Uri parse = Uri.parse(imageUrl);
                ((myViewHolder) holder).times_image.setImageURI(parse);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String movieId = list.get(position).getMovieId();
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
    }
    class myViewHolder extends RecyclerView.ViewHolder {
        private final SimpleDraweeView times_image;
        private final TextView times_text1;
        private final TextView times_text2;
        private final TextView times_text3;
        private final TextView times_text4;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            times_image = itemView.findViewById(R.id.times_image);
            times_text1 = itemView.findViewById(R.id.times_text1);
            times_text2 = itemView.findViewById(R.id.times_text2);
            times_text3 = itemView.findViewById(R.id.times_text3);
            times_text4 = itemView.findViewById(R.id.times_text4);
        }
    }
}
