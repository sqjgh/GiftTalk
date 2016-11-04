package com.example.dllo.gifttalk.category.singlecategory;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.beantools.VolleySingleton;
import com.example.dllo.gifttalk.category.categorybeans.SingleBeans;

/**
 * Created by dllo on 16/11/2.
 */
public class RightRVAdapter extends RecyclerView.Adapter<RightRVAdapter.ViewHolder>{
    private SingleBeans singleBeans;
    private int itemPosition;

    public void setSingleBeans(SingleBeans singleBeans) {
        this.singleBeans = singleBeans;
    }
    public void setItemPosition(int itemPosition) {
        this.itemPosition = itemPosition;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_right_rv_single_category,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        VolleySingleton.getInstance().getImage(singleBeans.getData().getCategories().get(itemPosition).getSubcategories().get(position).getIcon_url(),holder.iv);
        holder.tv.setText(singleBeans.getData().getCategories().get(itemPosition).getSubcategories().get(position).getName());
    }

    @Override
    public int getItemCount() {
        return singleBeans.getData().getCategories().get(itemPosition).getSubcategories().size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv;
        private final TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.image_one);
            tv = (TextView) itemView.findViewById(R.id.tv_one);
        }
    }
}