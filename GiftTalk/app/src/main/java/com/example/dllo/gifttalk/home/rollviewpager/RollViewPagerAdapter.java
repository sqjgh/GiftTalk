package com.example.dllo.gifttalk.home.rollviewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dllo.gifttalk.tools.VolleySingleton;
import com.example.dllo.gifttalk.beans.RollViewBeans;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;

/**
 * Created by dllo on 16/10/27.
 */
public class RollViewPagerAdapter extends LoopPagerAdapter{
    private RollViewBeans rollViewBeans;
    private Context context;

    public void setRollViewBeans(RollViewBeans rollViewBeans) {
        this.rollViewBeans = rollViewBeans;
        notifyDataSetChanged();
    }




    public RollViewPagerAdapter(RollPagerView viewPager, Context context) {
        super(viewPager);
        this.context = context;
    }


    public RollViewPagerAdapter(RollPagerView viewPager) {
        super(viewPager);
    }

    @Override
    public View getView(ViewGroup container, int position) {
        ImageView view = new ImageView(container.getContext());
        VolleySingleton.getInstance().getImage(rollViewBeans.getData().getBanners().get(position).getImage_url(),view);
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return view;
    }

    @Override
    public int getRealCount() {
        return rollViewBeans.getData().getBanners() == null ? 0 : rollViewBeans.getData().getBanners().size();
    }
}
