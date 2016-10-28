package com.example.dllo.gifttalk.gift;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.gifttalk.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/25.
 */
public class GiftRecyclerViewAdapter extends RecyclerView.Adapter<GiftRecyclerViewAdapter.ViewHolder> {
    ArrayList<GiftBeans> arrayList;
    private Context context;

    public GiftRecyclerViewAdapter(Context context) {
        this.context = context;
    }


    public void setArrayList(ArrayList<GiftBeans> arrayList) {
        this.arrayList = arrayList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_rv_gift, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GiftRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.pic.setImageResource(arrayList.get(position).getPic());
        holder.price.setText(arrayList.get(position).getPrice());
        holder.title.setText(arrayList.get(position).getTitle());
        holder.title2.setText(arrayList.get(position).getTitle2());
    }

    @Override
    public int getItemCount() {
        return arrayList == null ? 0 : arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView price;
        private final TextView title2;
        private final TextView title;
        private final ImageView pic;

        public ViewHolder(View itemView) {
            super(itemView);
            pic = (ImageView) itemView.findViewById(R.id.imageview_item_gift);
            title = (TextView) itemView.findViewById(R.id.title_item_gift);
            title2 = (TextView) itemView.findViewById(R.id.title2_item_gift);
            price = (TextView) itemView.findViewById(R.id.price_item_gift);

        }
    }
}
