package com.example.dllo.gifttalk.secondlevel.secondgift;

import android.graphics.Color;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseFragment;
import com.example.dllo.gifttalk.gift.giftbeans.TabLayoutItemBeansGift;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;

/**
 * Created by dllo on 16/11/4.
 */
public class SingleSecondGiftFragment extends BaseFragment implements SecondGiftBeans {

    private RollPagerView rollVp;
    SecondGiftActivity secondGiftActivity;
    @Override
    protected void initData() {
        secondGiftActivity.setSecondGiftBeans(this);

    }

    @Override
    protected void initView() {
        rollVp = bindView(R.id.rollvp_second_gift);
    }

    @Override
    protected int getLayout() {
        return R.layout.second_single_gift;
    }

    @Override
    public void SecondGiftBeans(TabLayoutItemBeansGift Beans, int position) {
        RollPagerView rollPagerView = bindView(R.id.rollvp_second_gift);
        rollPagerView.setHintView(new ColorPointHintView(context, Color.RED, Color.WHITE));
        RollVPSecondGiftAdapter adapter = new RollVPSecondGiftAdapter(rollPagerView);
        adapter.setBeans(Beans);
        adapter.setPosition(position);
        rollPagerView.setAdapter(adapter);
    }
}
