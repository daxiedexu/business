package com.zhang.kinds.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.zhang.kinds.R;
import com.zhang.kinds.net.entitiy.KindsEntitiy;

import java.util.List;

/**
 * @ClassName KindsAdapter
 * @Author 孔晨亮
 * @Date 2021/9/15 20:08
 * User: msi
 */
public class KindsAdapter extends RecyclerView.Adapter<KindsAdapter.ViewHolder> {
    private Context context;
    private List<KindsEntitiy.DataBean> list;

    public KindsAdapter(Context context, List<KindsEntitiy.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_rv_kinds, parent,false);
        return new ViewHolder(inflate);
    }
    boolean isCheck=true;
    @Override
    public void onBindViewHolder(@NonNull KindsAdapter.ViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getCategory_name());

        if (isCheck){
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.textView.setTextColor(Color.parseColor("#F49F21"));
                    holder.textView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    isCheck=false;
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
//        public RadioButton radioButton;
        public TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.kinds_tv_name);
//            radioButton=itemView.findViewById(R.id.kinds_btn);
        }
    }
}
