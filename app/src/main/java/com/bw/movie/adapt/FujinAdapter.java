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
import com.bw.movie.bean.FujinBean;

import java.util.List;

public class FujinAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<FujinBean.ResultBean> list;
    Context context;
    public FujinAdapter(FragmentActivity activity, List<FujinBean.ResultBean> result) {
        this.list=result;
        this.context=activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fujinadapter_layout, parent, false);
        return new myVieHolderFujin(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof myVieHolderFujin){
            ((myVieHolderFujin) holder).fjyy_name.setText(list.get(position).getName());
            ((myVieHolderFujin) holder).fjyy_price.setText(list.get(position).getAddress());
            Glide.with(context).load(list.get(position).getLogo()).into(((myVieHolderFujin) holder).fjyy_image);
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

    private class myVieHolderFujin extends RecyclerView.ViewHolder {

        private final TextView fjyy_name;
        private final TextView fjyy_price;
        private final ImageView fjyy_image;

        public myVieHolderFujin(View inflate) {
            super(inflate);
            fjyy_name = inflate.findViewById(R.id.fjyy_name);
            fjyy_price = inflate.findViewById(R.id.fjyy_price);
            fjyy_image = inflate.findViewById(R.id.fjyy_image);
        }
    }
}
