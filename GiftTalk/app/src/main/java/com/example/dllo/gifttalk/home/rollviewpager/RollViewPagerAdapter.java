package com.example.dllo.gifttalk.home.rollviewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dllo.gifttalk.home.beantools.VolleySingleton;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;

/**
 * Created by dllo on 16/10/27.
 */
public class RollViewPagerAdapter extends LoopPagerAdapter{
    private String str;
    private Context context;

    public void setStr(String str) {
        this.str = str;
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
        VolleySingleton.getInstance().getImage(str,view);
//        view.setImageBitmap(arrayList.get(position));
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return view;
    }

    @Override
    public int getRealCount() {
        return 7;
    }
}
