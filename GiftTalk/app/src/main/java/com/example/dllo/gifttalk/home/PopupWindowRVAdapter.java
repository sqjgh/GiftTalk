package com.example.dllo.gifttalk.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.home.homebeans.TabLayoutBeans;

/**
 * Created by dllo on 16/11/6.
 */
public class PopupWindowRVAdapter extends RecyclerView.Adapter<PopupWindowRVAdapter.ViewHolder>{
    TabLayoutBeans tabLayoutBeans;

    public void setTabLayoutBeans(TabLayoutBeans tabLayoutBeans) {
        this.tabLayoutBeans = tabLayoutBeans;
    }

    @Override
    public PopupWindowRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_popwindow,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(tabLayoutBeans.getData().getChannels().get(position).getName());
    }

    @Override
    public int getItemCount() {
        return tabLayoutBeans.getData().getChannels().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name_popupwindow);
        }
    }
}
