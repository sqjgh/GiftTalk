package com.example.dllo.gifttalk.category.raiderscategory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.category.categorybeans.ListViewRaidersBeans;
import com.example.dllo.gifttalk.home.beantools.VolleySingleton;

/**
 * Created by dllo on 16/10/27.
 */
public class RaidersListViewAdapter extends BaseAdapter {
    private int[] arrayList = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_lv_raiders_category, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        VolleySingleton.getInstance().getImage(listViewRaidersBeans.getData().getChannel_groups().get(i).getChannels().get(0).getCover_image_url(),viewHolder.pic1);
        VolleySingleton.getInstance().getImage(listViewRaidersBeans.getData().getChannel_groups().get(i).getChannels().get(1).getCover_image_url(),viewHolder.pic2);
        VolleySingleton.getInstance().getImage(listViewRaidersBeans.getData().getChannel_groups().get(i).getChannels().get(2).getCover_image_url(),viewHolder.pic3);
        VolleySingleton.getInstance().getImage(listViewRaidersBeans.getData().getChannel_groups().get(i).getChannels().get(3).getCover_image_url(),viewHolder.pic4);
        VolleySingleton.getInstance().getImage(listViewRaidersBeans.getData().getChannel_groups().get(i).getChannels().get(4).getCover_image_url(),viewHolder.pic5);
        VolleySingleton.getInstance().getImage(listViewRaidersBeans.getData().getChannel_groups().get(i).getChannels().get(5).getCover_image_url(),viewHolder.pic6);
        viewHolder.name.setText(listViewRaidersBeans.getData().getChannel_groups().get(i).getName());
        if (listViewRaidersBeans.getData().getChannel_groups().get(i).getChannels().size() <= 6){
            viewHolder.all.setVisibility(View.GONE);
        }
        return view;
    }

    private class ViewHolder {

        private final ImageView pic1;
        private final ImageView pic2;
        private final ImageView pic3;
        private final ImageView pic4;
        private final ImageView pic5;
        private final ImageView pic6;
        private final TextView name;
        private final TextView all;

        public ViewHolder(View view) {
            pic1 = (ImageView) view.findViewById(R.id.pic1_raiders_category);
            pic2 = (ImageView) view.findViewById(R.id.pic2_raiders_category);
            pic3 = (ImageView) view.findViewById(R.id.pic3_raiders_category);
            pic4 = (ImageView) view.findViewById(R.id.pic4_raiders_category);
            pic5 = (ImageView) view.findViewById(R.id.pic5_raiders_category);
            pic6 = (ImageView) view.findViewById(R.id.pic6_raiders_category);
            name = (TextView) view.findViewById(R.id.name_raiders_category);
            all = (TextView) view.findViewById(R.id.all_category);
        }
    }
}
