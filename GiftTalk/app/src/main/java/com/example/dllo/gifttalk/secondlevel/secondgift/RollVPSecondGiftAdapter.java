package com.example.dllo.gifttalk.secondlevel.secondgift;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dllo.gifttalk.beantools.VolleySingleton;
import com.example.dllo.gifttalk.beans.TabLayoutItemBeansGift;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;

/**
 * Created by dllo on 16/11/4.
 */
public class RollVPSecondGiftAdapter extends LoopPagerAdapter{

    private TabLayoutItemBeansGift beans;
    private int pos;

    public void setPosition(int pos) {
        this.pos = pos;
    }

    public void setBeans(TabLayoutItemBeansGift beans) {
        this.beans = beans;
    }

    public RollVPSecondGiftAdapter(RollPagerView viewPager) {
        super(viewPager);
    }

    @Override
    public View getView(ViewGroup container, int position) {
        ImageView view = new ImageView(container.getContext());
        VolleySingleton.getInstance().getImage(beans.getData().getItems().get(pos).getImage_urls().get(position),view);
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return view;
    }

    @Override
    public int getRealCount() {
        return beans.getData().getItems().get(pos).getImage_urls().size();
    }
}
