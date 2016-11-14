package com.example.dllo.gifttalk.category.raiderscategory;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseFragment;
import com.example.dllo.gifttalk.beantools.GsonRequest;
import com.example.dllo.gifttalk.beantools.Values;
import com.example.dllo.gifttalk.beantools.VolleySingleton;
import com.example.dllo.gifttalk.beans.ColumnRaidersBeans;
import com.example.dllo.gifttalk.beans.ListViewRaidersBeans;

/**
 * Created by dllo on 16/10/24.
 */
public class RaidersFragment extends BaseFragment{

    private ListView listView;
    private RaidersListViewAdapter listViewAdapter;
    private HeadRecyclerViewRaidersAdapter recyclerViewAdapter;
    private RecyclerView headRecyclerView;
    private View v;
    private ImageView loading;

    @Override
    protected void initData() {

        initHeadNetData();
    }

    @Override
    protected void initView() {
        loading = bindView(R.id.loading_anim_category);
        listView = bindView(R.id.listview_raiders_category);
        listViewAdapter = new RaidersListViewAdapter(getActivity());
        recyclerViewAdapter = new HeadRecyclerViewRaidersAdapter(getActivity());

    }



    @Override
    protected int getLayout() {
        return R.layout.fragment_raiders_category;
    }

    // 攻略-栏目 recyclerView 数据
    private void initHeadNetData() {
        GsonRequest<ColumnRaidersBeans> gsonRequest1 = new GsonRequest<>(ColumnRaidersBeans.class, Values.COLUMN_RAIDERS_CATEGORY, new Response.Listener<ColumnRaidersBeans>() {
            @Override
            public void onResponse(ColumnRaidersBeans response) {
                // 请求成功的方法

                v = LayoutInflater.from(context).inflate(R.layout.head_raiders_category, null);
                TextView all = (TextView) v.findViewById(R.id.all_head_raiders);
                all.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "查看全部", Toast.LENGTH_SHORT).show();
                    }
                });
                headRecyclerView = (RecyclerView) v.findViewById(R.id.rv_raiders_category);
                recyclerViewAdapter.setColumnRaidersBeans(response);
                headRecyclerView.setAdapter(recyclerViewAdapter);
                GridLayoutManager manager = new GridLayoutManager(getActivity(),3, LinearLayoutManager.HORIZONTAL,false);
                headRecyclerView.setLayoutManager(manager);
                initListViewData();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        //请求放入请求队列
        VolleySingleton.getInstance().addRequest(gsonRequest1);
    }

    // 攻略listView 网络数据
    private void initListViewData() {
        GsonRequest<ListViewRaidersBeans> gsonRequest = new GsonRequest<>(ListViewRaidersBeans.class, Values.ALL_RAIDERS_CATEGORY, new Response.Listener<ListViewRaidersBeans>() {
            @Override
            public void onResponse(ListViewRaidersBeans response) {
                // 请求成功的方法
                loading.setVisibility(View.GONE);
                listViewAdapter.setListViewRaidersBeans(response);
                listView.addHeaderView(v);
                listView.setAdapter(listViewAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        //请求放入请求队列
        VolleySingleton.getInstance().addRequest(gsonRequest);
    }

}
