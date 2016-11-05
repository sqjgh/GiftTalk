package com.example.dllo.gifttalk.secondlevel.secondgift;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dllo.gifttalk.R;

/**
 * Created by dllo on 16/11/5.
 */
public class HorRVAdapter extends RecyclerView.Adapter<HorRVAdapter.ViewHolder>{
    int pic[] = {R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item_home,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.iv.setImageResource(pic[position]);
    }

    @Override
    public int getItemCount() {
        return pic.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.imageview_item_home);
        }
    }
}
