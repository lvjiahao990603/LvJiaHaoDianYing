package com.bw.movie.adapt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;

import java.util.List;

public class JuzhaoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<String> list;
    Context context;
    public JuzhaoAdapter(FragmentActivity activity, List<String> posterList) {
        this.list=posterList;
        this.context=activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.zhaopian_layout, viewGroup, false);
        return new myViewHolderJuzhao(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof myViewHolderJuzhao){
            Glide.with(context).load(list.get(i)).into(((myViewHolderJuzhao) viewHolder).zhaopian_juzhao);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class myViewHolderJuzhao extends RecyclerView.ViewHolder {

        private final ImageView zhaopian_juzhao;

        public myViewHolderJuzhao(View inflate) {
            super(inflate);
            zhaopian_juzhao = inflate.findViewById(R.id.zhaopian_juzhao);
        }
    }
}
