package com.bw.movie.adapt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.QuyuBean;

import java.util.List;

public class QuyuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<QuyuBean.ResultBean> list;
    Context context;
    public QuyuAdapter(FragmentActivity activity, List<QuyuBean.ResultBean> result) {
        this.list=result;
        this.context=activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.haidainadapter_layout, parent, false);
        return new MyHoder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof QuyuAdapter.MyHoder){
            ((MyHoder) holder).find_name.setText(list.get(position).getRegionName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int regionId = list.get(position).getRegionId();
                    String rregionId = String.valueOf(regionId);
                    onItemClickListener.onItemClick(rregionId);
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
        void onItemClick(String rregionId);
    }


    public class MyHoder extends RecyclerView.ViewHolder{

        private final TextView find_name;

        public MyHoder(@NonNull View itemView) {
            super(itemView);
            find_name = itemView.findViewById(R.id.haidian_name);
        }
    }
}
