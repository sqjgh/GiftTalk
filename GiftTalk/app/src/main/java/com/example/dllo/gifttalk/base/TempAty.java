package com.example.dllo.gifttalk.base;

import android.widget.ListView;

import com.example.dllo.gifttalk.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/11/7.
 */
public class TempAty extends BaseActivity {

    private ListView listView;

    @Override
    protected void initData() {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add("---" + i);
        }

        BaseListViewAdapter<String> baseListViewAdapter = new BaseListViewAdapter<String>(R.layout.temp_item) {
            @Override
            protected void bindData(CommonViewHolder holder, String s) {
                holder.setText(R.id.temp_tv,s);
            }
        };

        listView.setAdapter(baseListViewAdapter);

        baseListViewAdapter.setData(data);
    }

    @Override
    protected void initViews() {
        listView = bindView(R.id.temp_lv);
    }

    @Override
    protected int getLayout() {
        return R.layout.temp;
    }
}
