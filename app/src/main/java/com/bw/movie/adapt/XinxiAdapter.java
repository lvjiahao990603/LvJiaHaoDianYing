package com.bw.movie.adapt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.BuyBean;
import com.bw.movie.view.CheckBoxActivity;

import java.util.List;

public class XinxiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<BuyBean.ResultBean> list;
    Context context;
    public XinxiAdapter(CheckBoxActivity checkBoxActivity, List<BuyBean.ResultBean> result) {
        this.list=result;
        this.context=checkBoxActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.xinxiadapter_layout, parent, false);
        return new myViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof XinxiAdapter.myViewHolder) {
            ((myViewHolder) holder).ticket_ting.setText(list.get(position).getScreeningHall());
            ((myViewHolder) holder).ticket_shijian1.setText(list.get(position).getBeginTime());
            ((myViewHolder) holder).ticket_shijian2.setText(list.get(position).getEndTime());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String scheduleId = list.get(position).getId();
                    String hallId = list.get(position).getHallId();
                    mitemClickLister.onitemClick(hallId,scheduleId);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class myViewHolder extends RecyclerView.ViewHolder {
        private final TextView ticket_ting;
        private final TextView ticket_shijian1;
        private final TextView ticket_shijian2;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            ticket_ting = itemView.findViewById(R.id.ticket_ting);
            ticket_shijian1 = itemView.findViewById(R.id.ticket_shijian1);
            ticket_shijian2 = itemView.findViewById(R.id.ticket_shijian2);
        }
    }
    ItemClickLister mitemClickLister;

    public void setMitemClickLister(ItemClickLister mitemClickLister) {
        this.mitemClickLister = mitemClickLister;
    }

    public interface ItemClickLister{
        void onitemClick(String hallId,String scheduleId);
    }
}
