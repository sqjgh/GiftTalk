package com.example.dllo.gifttalk.category.raiderscategory;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.beantools.VolleySingleton;
import com.example.dllo.gifttalk.category.categorybeans.ColumnRaidersBeans;

/**
 * Created by dllo on 16/10/27.
 */
public class HeadRecyclerViewRaidersAdapter extends RecyclerView.Adapter<HeadRecyclerViewRaidersAdapter.ViewHolder>{
    ColumnRaidersBeans columnRaidersBeans;
    private Context context;

    public void setColumnRaidersBeans(ColumnRaidersBeans columnRaidersBeans) {
        this.columnRaidersBeans = columnRaidersBeans;
    }

    public HeadRecyclerViewRaidersAdapter(Context context) {
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_head_raiders_category,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            holder.author.setText(columnRaidersBeans.getData().getColumns().get(position).getAuthor());
            holder.title.setText(columnRaidersBeans.getData().getColumns().get(position).getTitle());
            VolleySingleton.getInstance().getImage(columnRaidersBeans.getData().getColumns().get(position).getBanner_image_url(),holder.imageView);

    }

    @Override
    public int getItemCount() {
        return 12;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView title;
        private TextView author;
        private RelativeLayout rl;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.pic1_head_raiders_category);
            title = (TextView) itemView.findViewById(R.id.title1_head_raiders_category);
            author = (TextView) itemView.findViewById(R.id.from1_head_raiders_category);
            rl = (RelativeLayout) itemView.findViewById(R.id.one_raiders);
        }
    }
}
