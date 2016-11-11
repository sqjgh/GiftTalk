package com.example.dllo.gifttalk.secondlevel.secondhome;

import android.content.Intent;
import android.widget.EditText;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseActivity;
import com.example.dllo.gifttalk.beantools.Values;

/**
 * Created by dllo on 16/11/11.
 */
public class SearchThirdActivity extends BaseActivity{

    private EditText raidersUtf8;
    private EditText singleUtf8;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        raidersUtf8.setText(Values.RAIDERS_KEY_FRONT + intent.getStringExtra("utf8") + Values.RAIDERS_KEY_BACK);
        singleUtf8.setText(Values.SINGLE_KEY_FRONT + intent.getStringExtra("utf8") + Values.SINGLE_KEY_BACK);

    }

    @Override
    protected void initViews() {

        raidersUtf8 = bindView(R.id.raiders_utf8);
        singleUtf8 = bindView(R.id.single_utf8);
    }

    @Override
    protected int getLayout() {
        return R.layout.third_search;
    }
}
