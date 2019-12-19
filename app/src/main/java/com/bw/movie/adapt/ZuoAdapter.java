package com.bw.movie.adapt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.ZuoBean;
import com.bw.movie.view.CheckBoxActivity;

import java.util.List;

public class ZuoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<ZuoBean.ResultBean> list;
    Context context;
    public ZuoAdapter(CheckBoxActivity checkBoxActivity, List<ZuoBean.ResultBean> result) {
        this.list=result;
        this.context=checkBoxActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.zuoadapter_layout, parent, false);
        return new myViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ZuoAdapter.myViewHolder) {
            String row = list.get(position).getRow();
            String seat = list.get(position).getSeat();
            String status = list.get(position).getStatus();

            if (status.contains("1")) {
                ((myViewHolder) holder).zuo_che.setChecked(false);
            }else if (status.contains("2")){
                ((myViewHolder) holder).zuo_che.setBackgroundResource(R.drawable.myy_yelo);
            }else {
                ((myViewHolder) holder).zuo_che.setChecked(true);
            }
            ((myViewHolder) holder).zuo_che.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s=row+"-"+seat;
                    mzuoitem.onZuoItem(s);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class myViewHolder extends RecyclerView.ViewHolder {
        private CheckBox zuo_che;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            zuo_che = itemView.findViewById(R.id.zuo_che);
        }
    }
    zuoitem mzuoitem;

    public void setMzuoitem(zuoitem mzuoitem) {
        this.mzuoitem = mzuoitem;
    }

    public interface zuoitem{
        void onZuoItem(String s);
    }
}
