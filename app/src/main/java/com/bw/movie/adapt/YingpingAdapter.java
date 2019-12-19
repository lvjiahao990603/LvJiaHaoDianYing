package com.bw.movie.adapt;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.YingpingBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.List;

public class YingpingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<YingpingBean.ResultBean> list;
    Context context;
    public YingpingAdapter(FragmentActivity activity, List<YingpingBean.ResultBean> result) {
        this.list=result;
        this.context=activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.yingpingadapter_layout, parent, false);
        return new myViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof YingpingAdapter.myViewHolder) {
            ((myViewHolder) holder).name.setText(list.get(position).getCommentUserName());
            ((myViewHolder) holder).num_text.setText(list.get(position).getGreatNum()+"");
            ((myViewHolder) holder).cotent.setText(list.get(position).getCommentContent());
            ((myViewHolder) holder).score.setText(list.get(position).getScore()+"分");
            ((myViewHolder) holder).replynum.setText("等"+list.get(position).getReplyNum()+"人回复");

            String s = String.valueOf(list.get(position).getCommentTime());
            String format = DateFormatUtil.format(s);
            ((myViewHolder) holder).time.setText(format);

            RatingBar rating = ((myViewHolder) holder).rating;
            rating.setRating((float) list.get(position).getScore());

            Uri parse = Uri.parse(list.get(position).getCommentHeadPic());
            ((myViewHolder) holder).img.setImageURI(parse);

            ((myViewHolder) holder).num.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "点赞成功", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class myViewHolder extends RecyclerView.ViewHolder {
        private final SimpleDraweeView img;
        private final ImageView num;
        private final TextView name;
        private final RatingBar rating;
        private final TextView score,cotent,time,num_text,replynum;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.film_img);
            name = itemView.findViewById(R.id.film_name);
            rating = itemView.findViewById(R.id.filmReview_ratingBar);
            score = itemView.findViewById(R.id.film_score);
            num = itemView.findViewById(R.id.film_num);
            cotent = itemView.findViewById(R.id.film_content);
            time = itemView.findViewById(R.id.film_time);
            num_text = itemView.findViewById(R.id.film_num_text);
            replynum = itemView.findViewById(R.id.film_replyNum);
        }
    }
    public static class DateFormatUtil {
        public static String format(String date) {
            if (TextUtils.isEmpty(date))
                return null;
            SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日mm分ss秒");
            Long time = new Long(date);
            return format.format(time);
        }
    }
}
