package cn.imeina.mvpdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;
import cn.imeina.mvpdemo.R;
import cn.imeina.mvpdemo.bean.Girl;

/**
 * Created by gaopengfei on 2017/9/11.
 */

public class GirlAdapter extends RecyclerView.Adapter<GirlAdapter.GirlViewHolder>{


    private Context context;
    private List<Girl> girls;

    public void setGirls(List<Girl> girls) {
        this.girls = girls;
        notifyDataSetChanged();
    }

    public GirlAdapter(Context context) {
        this.context = context;
    }


    @Override
    public GirlViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.item_girl_list, parent, false);
        GirlViewHolder holder = new GirlViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(GirlViewHolder holder, int position) {

        Girl girl = girls.get(position);
        Glide.with(context).load(girl.getAvatarUrl()).into(holder.ivAvatar);
        holder.tvName.setText("姓名：" + girl.getName());
        holder.tvAge.setText("年龄：" + girl.getAge());
        holder.tvAddress.setText("籍贯：" + girl.getAddress());
    }

    @Override
    public int getItemCount() {
        return girls == null ? 0 : girls.size();
    }

    class GirlViewHolder extends RecyclerView.ViewHolder{

        ImageView ivAvatar;
        TextView tvName;
        TextView tvAge;
        TextView tvAddress;

        public GirlViewHolder(View itemView) {
            super(itemView);
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAge = itemView.findViewById(R.id.tv_age);
            tvAddress = itemView.findViewById(R.id.tv_address);
        }
    }
}
