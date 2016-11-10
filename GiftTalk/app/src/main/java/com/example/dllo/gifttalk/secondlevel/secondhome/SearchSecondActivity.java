package com.example.dllo.gifttalk.secondlevel.secondhome;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseActivity;
import com.example.dllo.gifttalk.base.BaseListViewAdapter;
import com.example.dllo.gifttalk.base.CommonViewHolder;
import com.example.dllo.gifttalk.beans.SearchSecondBean;
import com.example.dllo.gifttalk.beantools.GsonRequest;
import com.example.dllo.gifttalk.beantools.Values;
import com.example.dllo.gifttalk.beantools.VolleySingleton;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/7.
 */
public class SearchSecondActivity extends BaseActivity implements View.OnClickListener {

    private ListView lv;
    private RecyclerView rv;
    private TextView tv;
    private TextView search;
    private EditText et;
    private ArrayList<String> inArrayList;
    private BaseListViewAdapter<String> baseListViewAdapter;
    private SharedPreferences sp;
    private SharedPreferences.Editor spET;
    private ImageView allDelete;
    public SearchRVSecondAdapter adapter;
    private RelativeLayout allDeleteRV;
    private ImageView deleteEt;

    @Override
    protected void initData() {
        inArrayList = new ArrayList<>();
        sp = getSharedPreferences("searchHistory",MODE_PRIVATE);
        spET = sp.edit();
        for (int i = 0; i < sp.getAll().size(); i++) {
            inArrayList.add(sp.getString(i + "","居然没获取到数据"));
        }
        initGridView();
        initListView();
    }


    @Override
    protected void initViews() {
        deleteEt = bindView(R.id.delete_et_second_search);
        allDeleteRV = bindView(R.id.rv_alldelete_search_second);
        lv = bindView(R.id.lv_search_second);
        rv = bindView(R.id.rv_search_second);
        search = bindView(R.id.btn_search_second);
        et = bindView(R.id.et_search_second);
        allDelete = bindView(R.id.alldelete_search_second);
        allDelete.setOnClickListener(this);
        search.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_search_second:
                searchBtn();
                break;
            case R.id.alldelete_search_second:
                inArrayList.clear();
                spET.clear();
                allDeleteRV.setVisibility(View.GONE);
                baseListViewAdapter.setData(inArrayList);
                break;
            case R.id.delete_et_second_search:
                et.setText("");
        }
    }
    // 点击有内容搜索,没内容退出
    private void searchBtn() {
        if (et.getText().toString().trim().length() == 0){
            finish();
        }else {
            if (inArrayList.toString().trim() == null){
                allDeleteRV.setVisibility(View.GONE);
            }else {
                allDeleteRV.setVisibility(View.VISIBLE);
            }

            inArrayList.add(et.getText().toString());
            baseListViewAdapter.setData(inArrayList);
            lv.setAdapter(baseListViewAdapter);
        }
    }



    private void initListView() {
        // 点击设置editText文字
        // 点击删除监听
        baseListViewAdapter = new BaseListViewAdapter<String>(R.layout.item_verlv_search_second) {
            @Override
            protected void bindData(final CommonViewHolder holder, String s) {
                notifyDataSetChanged();
                holder.setText(R.id.history_search_second,s);
                holder.setViewClick(R.id.history_search_second, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // 点击设置editText文字
                        et.setText(inArrayList.get(holder.getPos()));
                        inArrayList.add(0, inArrayList.get(holder.getPos()));
                        inArrayList.remove(holder.getPos() + 1);
                        if (inArrayList.toString().trim() == null){
                            allDeleteRV.setVisibility(View.GONE);
                        }else {
                            allDeleteRV.setVisibility(View.VISIBLE);
                        }
                        notifyDataSetChanged();
                    }
                });
                // 点击删除监听
                holder.setViewClick(R.id.delete_search_second, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        inArrayList.remove(holder.getPos());

                        if (inArrayList.size() == 0){
                            allDeleteRV.setVisibility(View.GONE);
                        }else {
                            allDeleteRV.setVisibility(View.VISIBLE);
                        }
                        notifyDataSetChanged();
                        Toast.makeText(SearchSecondActivity.this, "holder.getItemId():" + holder.getPos(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        if (inArrayList.toString().trim() == null){
            allDeleteRV.setVisibility(View.GONE);
        }else {
            allDeleteRV.setVisibility(View.VISIBLE);
        }

        baseListViewAdapter.setData(inArrayList);
        lv.setAdapter(baseListViewAdapter);
    }
    // 离开当前页面
    @Override
    protected void onPause() {
        // 清空之前SharedPreferences数据 写入这次的新数据
        spET.clear();
        for (int i = 0; i < inArrayList.size(); i++) {
            spET.putString(i + "",inArrayList.get(i));
        }
        spET.commit();
        super.onPause();
    }

    @Override
    protected int getLayout() {
        return R.layout.second_search;
    }

    public void initGridView(){
        //创建请求
        GsonRequest<SearchSecondBean> gsonRequest = new GsonRequest<>(SearchSecondBean.class, Values.SECOND_SEARCH, new Response.Listener<SearchSecondBean>() {
            @Override
            public void onResponse(SearchSecondBean response) {
                adapter = new SearchRVSecondAdapter();
                adapter.setSearchSecondBean(response);
                rv.setAdapter(adapter);
                StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.VERTICAL);
                rv.setLayoutManager(manager);
                if (sp.getAll().size() == 0){
                    allDeleteRV.setVisibility(View.GONE);
                }else {
                    allDeleteRV.setVisibility(View.VISIBLE);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        //请求放入请求队列
        VolleySingleton.getInstance().addRequest(gsonRequest);
    }



    // 横向RVAdapter
    public class SearchRVSecondAdapter extends RecyclerView.Adapter<SearchRVSecondAdapter.ViewHolder>{

        SearchSecondBean searchSecondBean;

        public void setSearchSecondBean(SearchSecondBean searchSecondBean) {
            this.searchSecondBean = searchSecondBean;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horsearch_second,parent,false);
            ViewHolder viewholder = new ViewHolder(v);
            return viewholder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.tv.setText(searchSecondBean.getData().getHot_words().get(position));
            holder.tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   et.setText(searchSecondBean.getData().getHot_words().get(position));
                    inArrayList.add(searchSecondBean.getData().getHot_words().get(position));
                }
            });
            if (position < 3){
                holder.tv.setTextColor(Color.RED);
            }
        }

        @Override
        public int getItemCount() {
            return searchSecondBean.getData().getHot_words().size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private final TextView tv;

            public ViewHolder(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(R.id.tv_horsearch_second);
            }
        }
    }



}
