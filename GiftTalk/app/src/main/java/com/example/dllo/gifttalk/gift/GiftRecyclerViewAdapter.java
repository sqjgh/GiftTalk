package com.example.dllo.gifttalk.gift;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.gift.giftbeans.GiftBeans;
import com.example.dllo.gifttalk.gift.giftbeans.TabLayoutItemBeansGift;
import com.example.dllo.gifttalk.home.beantools.VolleySingleton;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/25.
 */
public class GiftRecyclerViewAdapter extends RecyclerView.Adapter<GiftRecyclerViewAdapter.ViewHolder> {
    ArrayList<GiftBeans> arrayList;
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
    public void onBindViewHolder(GiftRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.price.setText(tabLayoutItemBeansGift.getData().getItems().get(position).getPrice());
        holder.title.setText(tabLayoutItemBeansGift.getData().getItems().get(position).getShort_description());
        holder.title2.setText(tabLayoutItemBeansGift.getData().getItems().get(position).getName());
        VolleySingleton.getInstance().getImage(tabLayoutItemBeansGift.getData().getItems().get(position).getCover_image_url(),holder.pic);
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

        public ViewHolder(View itemView) {
            super(itemView);
            pic = (ImageView) itemView.findViewById(R.id.imageview_item_gift);
            title = (TextView) itemView.findViewById(R.id.title_item_gift);
            title2 = (TextView) itemView.findViewById(R.id.title2_item_gift);
            price = (TextView) itemView.findViewById(R.id.price_item_gift);

        }
    }
}
