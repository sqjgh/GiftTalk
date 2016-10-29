package com.example.dllo.gifttalk.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.home.beantools.VolleySingleton;
import com.example.dllo.gifttalk.home.homebeans.TabLayoutItemBeans;

/**
 * Created by dllo on 16/10/27.
 */
public class FirstListViewAdapter extends BaseAdapter {
    private Context context;
    private TabLayoutItemBeans tabLayoutItemBeans;
    final String TYPE_PIC1 = "ad";
    final String TYPE_NORMAL1 = "post";
    final int VIEW_TYPE = 3;
    final int TYPE_PIC = 1;
    final int TYPE_NORMAL = 2;

    public void setTabLayoutItemBeans(TabLayoutItemBeans tabLayoutItemBeans) {
        this.tabLayoutItemBeans = tabLayoutItemBeans;
    }

    public FirstListViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return tabLayoutItemBeans == null ? 0 : tabLayoutItemBeans.getData().getItems().size();
    }

    @Override
    public int getItemViewType(int position) {
        if (tabLayoutItemBeans.getData().getItems().get(position).getType().equals("ad")){
            return TYPE_PIC;
        }else{
            return TYPE_NORMAL;
        }
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE;
    }

    @Override
    public Object getItem(int i) {
        return tabLayoutItemBeans.getData().getItems().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder1 viewHolder1 = null;
        ViewHolder2 viewHolder2 = null;
        int type = getItemViewType(i);

        if (view == null) {
            switch (type){
                case TYPE_PIC:
                    view = LayoutInflater.from(context).inflate(R.layout.image_item_home, viewGroup,false);
                    viewHolder1 = new ViewHolder1(view);
                    view.setTag(viewHolder1);
                    break;
                case TYPE_NORMAL:
                    view = LayoutInflater.from(context).inflate(R.layout.item_rv_vp_home, viewGroup,false);
                    viewHolder2 = new ViewHolder2(view);
                    view.setTag(viewHolder2);
                    break;
            }
        } else {
            switch (type){
                case TYPE_PIC:
                    viewHolder1 = (ViewHolder1) view.getTag();
                    break;
                case TYPE_NORMAL:
                    viewHolder2 = (ViewHolder2) view.getTag();
                    break;
            }
        }
        switch (type){

            case TYPE_PIC:
                VolleySingleton.getInstance().getImage(tabLayoutItemBeans.getData().getItems().get(i).getImage_url(),viewHolder1.imageView);
                break;
            case TYPE_NORMAL:
                VolleySingleton.getInstance().getImage(tabLayoutItemBeans.getData().getItems().get(i).getCover_image_url(),viewHolder2.pic);
                viewHolder2.title.setText(tabLayoutItemBeans.getData().getItems().get(i).getTitle());
                String str = tabLayoutItemBeans.getData().getItems().get(i).getIntroduction();
                if (str.length() > 46){
                    String re = str.substring(0,45);
                    viewHolder2.title2.setText(re + "...");
                }else{
                    viewHolder2.title2.setText(tabLayoutItemBeans.getData().getItems().get(i).getIntroduction());
                }
                viewHolder2.follow.setText(String.valueOf(tabLayoutItemBeans.getData().getItems().get(i).getLikes_count()));

        }

        return view;
    }

    private class ViewHolder1 {

        private final ImageView imageView;

        public ViewHolder1(View itemView) {
            imageView = (ImageView) itemView.findViewById(R.id.imageview_item_home);

        }
    }

    private class ViewHolder2 {
        private final ImageView pic;
        private final TextView title;
        private final TextView title2;
        private final TextView column;
        private final TextView column2;
        private final TextView follow;

        public ViewHolder2(View itemView) {
            pic = (ImageView) itemView.findViewById(R.id.iv_item_home);
            title = (TextView) itemView.findViewById(R.id.title_item_home);
            title2 = (TextView) itemView.findViewById(R.id.title2_item_home);
            column = (TextView) itemView.findViewById(R.id.column_item_home);
            column2 = (TextView) itemView.findViewById(R.id.column2_item_home);
            follow = (TextView) itemView.findViewById(R.id.follow_item_home);
        }
    }
}