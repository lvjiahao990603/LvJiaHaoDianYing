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
import com.bw.movie.bean.QuyuLiebiaoBean;

import java.util.List;

public class QuyuliebiaoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<QuyuLiebiaoBean.ResultBean> list;
    Context context;
    public QuyuliebiaoAdapter(FragmentActivity activity, List<QuyuLiebiaoBean.ResultBean> result) {
        this.list=result;
        this.context=activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.quyuliebiao_layout, parent, false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof  MyHolder){
            ((MyHolder) holder).quyuliebiao_name.setText(list.get(position).getName());
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
        return list.size();
    }
    public OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
    public interface OnItemClickListener{
        void onItemClick(String ida);
    }
    public class MyHolder extends RecyclerView.ViewHolder {
        private final TextView quyuliebiao_name;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            quyuliebiao_name = itemView.findViewById(R.id.quyuliebiao_name);
        }
    }
}
