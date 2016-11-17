package com.example.dllo.gifttalk.category.raiderscategory;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.tools.VolleySingleton;
import com.example.dllo.gifttalk.beans.ColumnRaidersBeans;

/**
 * Created by dllo on 16/10/27.
 */
public class HeadRecyclerViewRaidersAdapter extends RecyclerView.Adapter{
    ColumnRaidersBeans columnRaidersBeans;
    private Context context;
    public static final int TYPE_ITEM = 0;
    public static final int TYPE_FOOT = 1;

    public void setColumnRaidersBeans(ColumnRaidersBeans columnRaidersBeans) {
        this.columnRaidersBeans = columnRaidersBeans;
    }

    public HeadRecyclerViewRaidersAdapter(Context context) {
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE_ITEM:
                View v = LayoutInflater.from(context).inflate(R.layout.item_head_raiders_category,parent,false);
                ViewHolderNormal viewHolderNormal = new ViewHolderNormal(v);
                return viewHolderNormal;

            case TYPE_FOOT:
                View vv = LayoutInflater.from(context).inflate(R.layout.item_foot_headrv_single,parent,false);
                ViewHolderFoot viewHolderFoot = new ViewHolderFoot(vv);
                return viewHolderFoot;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        int type = getItemViewType(position);

        if (type == TYPE_FOOT){
            ViewHolderFoot viewHolder = (ViewHolderFoot) holder;
            viewHolder.tv.setText("点击查看全部");
            viewHolder.allRl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "跳转查看全部", Toast.LENGTH_SHORT).show();
                    //TODO 跳转查看全部
                }
            });

        }else {
            ViewHolderNormal viewHolder = (ViewHolderNormal) holder;
            viewHolder.author.setText(columnRaidersBeans.getData().getColumns().get(position).getAuthor());
            viewHolder.title.setText(columnRaidersBeans.getData().getColumns().get(position).getTitle());
            VolleySingleton.getInstance().getImage(columnRaidersBeans.getData().getColumns().get(position).getBanner_image_url(),viewHolder.imageView);
            viewHolder.rl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "position:" + position, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    @Override
    public int getItemViewType(int position) {

        if (position == 11){
            return TYPE_FOOT;
        }else {
            return TYPE_ITEM;
        }

    }

    @Override
    public int getItemCount() {
        return 12;
    }

    public class ViewHolderNormal extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView title;
        private TextView author;
        private RelativeLayout rl;

        public ViewHolderNormal(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.pic1_head_raiders_category);
            title = (TextView) itemView.findViewById(R.id.title1_head_raiders_category);
            author = (TextView) itemView.findViewById(R.id.from1_head_raiders_category);
            rl = (RelativeLayout) itemView.findViewById(R.id.one_raiders);
        }
    }
    public class ViewHolderFoot extends RecyclerView.ViewHolder {

        private final TextView tv;
        private final RelativeLayout allRl;

        public ViewHolderFoot(View itemView) {
            super(itemView);
            allRl = (RelativeLayout) itemView.findViewById(R.id.all_rl_head_single);
            tv = (TextView) itemView.findViewById(R.id.foot_rv_single);

        }
    }
}
