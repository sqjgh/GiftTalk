package com.example.dllo.gifttalk.secondlevel.secondgift;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.tools.VolleySingleton;
import com.example.dllo.gifttalk.beans.TabLayoutItemBeansGift;

/**
 * Created by dllo on 16/11/5.
 */
public class VerRVAdapter extends RecyclerView.Adapter<VerRVAdapter.ViewHolder>{

    private TabLayoutItemBeansGift newBeans;
    private Context context;

    public VerRVAdapter(Context context) {
        this.context = context;
    }

    public void setNewBeans(TabLayoutItemBeansGift newBeans) {
        this.newBeans = newBeans;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_rv_gift,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.price.setText(newBeans.getData().getRecommend_items().get(position).getPrice());
        holder.title.setText(newBeans.getData().getRecommend_items().get(position).getName());
        if (newBeans.getData().getRecommend_items().get(position).getPurchase_status() == 0){
            holder.over.setVisibility(View.VISIBLE);
        }
        holder.ll.setVisibility(View.GONE);
        VolleySingleton.getInstance().getImage(newBeans.getData().getRecommend_items().get(position).getCover_image_url(),holder.iv);
        holder.rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(context,SecondGiftActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("tabLayoutItemBeansGift", newBeans);
//                intent.putExtras(bundle);
//                intent.putExtra("position",position);
//                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newBeans.getData().getRecommend_items().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView price;
        private TextView over;
        private LinearLayout ll;
        private ImageView iv;
        private RelativeLayout rl;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.imageview_item_gift);
            over = (TextView) itemView.findViewById(R.id.over_second_gift);
            title = (TextView) itemView.findViewById(R.id.title_item_gift);
            price = (TextView) itemView.findViewById(R.id.price_item_gift);
            ll = (LinearLayout) itemView.findViewById(R.id.ll_item_everyday);
            rl = (RelativeLayout) itemView.findViewById(R.id.rl_gift);
        }
    }
}
