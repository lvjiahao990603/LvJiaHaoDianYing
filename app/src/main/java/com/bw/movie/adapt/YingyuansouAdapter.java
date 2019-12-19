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
import com.bw.movie.bean.YingyuanSouBean;
import com.bw.movie.view.YingyuansouActivity;

import java.util.List;

public class YingyuansouAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<YingyuanSouBean.ResultBean> list;
    Context context;
    public YingyuansouAdapter(YingyuansouActivity yingyuansouActivity, List<YingyuanSouBean.ResultBean> result) {
        this.list=result;
        this.context=yingyuansouActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.yingyuansouadapter_layout, parent, false);
        return new myViewHolderYingyuansou(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof myViewHolderYingyuansou){
            ((myViewHolderYingyuansou) holder).yysou_name.setText(list.get(position).getName());
            ((myViewHolderYingyuansou) holder).yysou_price.setText(list.get(position).getAddress());
            Glide.with(context).load(list.get(position).getLogo()).into(((myViewHolderYingyuansou) holder).yysou_image);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = list.get(position).getId();
                    String ida = String.valueOf(id);
                    onItemClickListener.onItemClick(ida);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (list!=null){
            return list.size();
        }else {
            Toast.makeText(context, "俺搜不到", Toast.LENGTH_SHORT).show();
        }
        return 0;
    }
    public OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
    public interface OnItemClickListener{
        void onItemClick(String ida);
    }

    private class myViewHolderYingyuansou extends RecyclerView.ViewHolder {

        private final TextView yysou_name;
        private final TextView yysou_price;
        private final ImageView yysou_image;

        public myViewHolderYingyuansou(View inflate) {
            super(inflate);
            yysou_name = inflate.findViewById(R.id.yysou_name);
            yysou_price = inflate.findViewById(R.id.yysou_price);
            yysou_image = inflate.findViewById(R.id.yysou_image);
        }
    }
}
