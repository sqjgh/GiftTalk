package com.example.dllo.gifttalk.home;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.beans.TabLayoutBeans;

/**
 * Created by dllo on 16/11/6.
 */
public class PopupWindowRVAdapter extends RecyclerView.Adapter<PopupWindowRVAdapter.ViewHolder> {
    TabLayoutBeans tabLayoutBeans;
    private Context context;
    private int itemPosition;

    public void setItemPosition(int itemPosition) {
        this.itemPosition = itemPosition;
    }
    public PopupWindowRVAdapter(Context context) {
        this.context = context;
    }

    public void setTabLayoutBeans(TabLayoutBeans tabLayoutBeans) {
        this.tabLayoutBeans = tabLayoutBeans;
    }

    @Override
    public PopupWindowRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_popwindow, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.name.setText(tabLayoutBeans.getData().getChannels().get(position).getName());
        holder.rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeFragment.setToItem(position);
            }
        });
        // 进入popupwindow颜色监听
        if (itemPosition == position){
            holder.rl.setBackgroundResource(R.drawable.background_popupwindow);
            holder.name.setTextColor(Color.RED);
        }else {
            holder.rl.setBackgroundColor(Color.WHITE);
        }
    }

    @Override
    public int getItemCount() {
        return tabLayoutBeans.getData().getChannels().size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private RelativeLayout rl;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name_popupwindow);
            rl = (RelativeLayout) itemView.findViewById(R.id.ll_popupwindow);
        }
    }
}
