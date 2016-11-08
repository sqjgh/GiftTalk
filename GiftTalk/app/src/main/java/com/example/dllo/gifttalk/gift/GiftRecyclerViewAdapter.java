package com.example.dllo.gifttalk.gift;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.beantools.VolleySingleton;
import com.example.dllo.gifttalk.beans.TabLayoutItemBeansGift;
import com.example.dllo.gifttalk.secondlevel.secondgift.SecondGiftActivity;

/**
 * Created by dllo on 16/10/25.
 */
public class GiftRecyclerViewAdapter extends RecyclerView.Adapter<GiftRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private TabLayoutItemBeansGift tabLayoutItemBeansGift;


    public void setTabLayoutItemBeansGift(TabLayoutItemBeansGift tabLayoutItemBeansGift) {
        this.tabLayoutItemBeansGift = tabLayoutItemBeansGift;

    }

    public GiftRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_rv_gift, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final GiftRecyclerViewAdapter.ViewHolder holder, final int position) {
        if (position < 3){
            holder.num.setTextColor(Color.WHITE);
            holder.top.setTextColor(Color.WHITE);
            holder.numberLl.setBackgroundResource(R.drawable.red_background_ll_item_everyday);
        }else {
            holder.num.setTextColor(Color.RED);
            holder.top.setTextColor(Color.RED);
            holder.numberLl.setBackgroundResource(R.drawable.background_ll_item_everyday);
        }
            holder.num.setText(String.valueOf(position + 1));

        holder.price.setText("¥" +" "+ tabLayoutItemBeansGift.getData().getItems().get(position).getPrice());
        holder.title.setText(tabLayoutItemBeansGift.getData().getItems().get(position).getShort_description());
        holder.title2.setText(tabLayoutItemBeansGift.getData().getItems().get(position).getName());
        VolleySingleton.getInstance().getImage(tabLayoutItemBeansGift.getData().getItems().get(position).getCover_image_url(),holder.pic);
        holder.rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, SecondGiftActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("tabLayoutItemBeansGift", tabLayoutItemBeansGift);
                intent.putExtras(bundle);
                intent.putExtra("position",position + "");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tabLayoutItemBeansGift == null ? 0 : tabLayoutItemBeansGift.getData().getItems().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView price;
        private final TextView title2;
        private final TextView title;
        private final ImageView pic;
        private final LinearLayout numberLl;
        private final TextView top;
        private final TextView num;
        private final RelativeLayout rl;

        public ViewHolder(View itemView) {
            super(itemView);
            rl = (RelativeLayout) itemView.findViewById(R.id.rl_gift);
            pic = (ImageView) itemView.findViewById(R.id.imageview_item_gift);
            title = (TextView) itemView.findViewById(R.id.title_item_gift);
            title2 = (TextView) itemView.findViewById(R.id.title2_item_gift);
            price = (TextView) itemView.findViewById(R.id.price_item_gift);
            numberLl = (LinearLayout) itemView.findViewById(R.id.ll_item_everyday);
            top = (TextView) itemView.findViewById(R.id.top_item_everyday_gift);
            num = (TextView) itemView.findViewById(R.id.num_item_everyday_gift);
        }
    }
}
