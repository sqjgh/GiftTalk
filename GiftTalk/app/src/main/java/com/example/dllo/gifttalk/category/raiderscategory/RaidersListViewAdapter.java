package com.example.dllo.gifttalk.category.raiderscategory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.beans.ListViewRaidersBeans;
import com.example.dllo.gifttalk.tools.VolleySingleton;

/**
 * Created by dllo on 16/10/27.
 */
public class RaidersListViewAdapter extends BaseAdapter{
    private Context context;
    private ListViewRaidersBeans listViewRaidersBeans;

    public void setListViewRaidersBeans(ListViewRaidersBeans listViewRaidersBeans) {
        this.listViewRaidersBeans = listViewRaidersBeans;
    }

    public RaidersListViewAdapter(Context context) {

        this.context = context;
    }

    @Override
    public int getCount() {
        return listViewRaidersBeans.getData().getChannel_groups().size();
    }

    @Override
    public Object getItem(int i) {
        return listViewRaidersBeans.getData().getChannel_groups().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_lv_raiders_category, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        VolleySingleton.getInstance().getImage(listViewRaidersBeans.getData().getChannel_groups().get(i).getChannels().get(0).getCover_image_url(),viewHolder.picOne);
        viewHolder.picOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "item" + i + "    " + 1 + "号位", Toast.LENGTH_SHORT).show();

            }
        });
        viewHolder.picTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "item" + i + "    " + 2 + "号位", Toast.LENGTH_SHORT).show();

            }
        });
        viewHolder.picThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "item" + i + "    " + 3 + "号位", Toast.LENGTH_SHORT).show();

            }
        });
        viewHolder.picFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "item" + i + "    " + 4 + "号位", Toast.LENGTH_SHORT).show();

            }
        });
        viewHolder.picFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "item" + i + "    " + 5 + "号位", Toast.LENGTH_SHORT).show();

            }
        });
        viewHolder.picSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "item" + i + "    " + 6 + "号位", Toast.LENGTH_SHORT).show();

            }
        });

        VolleySingleton.getInstance().getImage(listViewRaidersBeans.getData().getChannel_groups().get(i).getChannels().get(1).getCover_image_url(),viewHolder.picTwo);

        VolleySingleton.getInstance().getImage(listViewRaidersBeans.getData().getChannel_groups().get(i).getChannels().get(2).getCover_image_url(),viewHolder.picThree);

        VolleySingleton.getInstance().getImage(listViewRaidersBeans.getData().getChannel_groups().get(i).getChannels().get(3).getCover_image_url(),viewHolder.picFour);

        VolleySingleton.getInstance().getImage(listViewRaidersBeans.getData().getChannel_groups().get(i).getChannels().get(4).getCover_image_url(),viewHolder.picFive);

        VolleySingleton.getInstance().getImage(listViewRaidersBeans.getData().getChannel_groups().get(i).getChannels().get(5).getCover_image_url(),viewHolder.picSix);

        viewHolder.name.setText(listViewRaidersBeans.getData().getChannel_groups().get(i).getName());
        if (listViewRaidersBeans.getData().getChannel_groups().get(i).getChannels().size() <= 6){
            viewHolder.all.setVisibility(View.GONE);
        }
        return view;
    }



    private class ViewHolder {

        private ImageView picOne;
        private ImageView picTwo;
        private ImageView picThree;
        private ImageView picFour;
        private ImageView picFive;
        private ImageView picSix;
        private TextView name;
        private TextView all;

        public ViewHolder(View view) {
            picOne = (ImageView) view.findViewById(R.id.picOne_raiders_category);
            picTwo = (ImageView) view.findViewById(R.id.picTwo_raiders_category);
            picThree = (ImageView) view.findViewById(R.id.picThree_raiders_category);
            picFour = (ImageView) view.findViewById(R.id.picFour_raiders_category);
            picFive = (ImageView) view.findViewById(R.id.picFive_raiders_category);
            picSix = (ImageView) view.findViewById(R.id.picSix_raiders_category);
            name = (TextView) view.findViewById(R.id.name_raiders_category);
            all = (TextView) view.findViewById(R.id.all_category);
        }
    }

}
