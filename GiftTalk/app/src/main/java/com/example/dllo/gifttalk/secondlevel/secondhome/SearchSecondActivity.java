package com.example.dllo.gifttalk.secondlevel.secondhome;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseActivity;
import com.example.dllo.gifttalk.base.BaseListViewAdapter;
import com.example.dllo.gifttalk.base.CommonViewHolder;
import com.example.dllo.gifttalk.beans.SearchListBean;
import com.example.dllo.gifttalk.beans.SearchSecondBean;
import com.example.dllo.gifttalk.beantools.GsonRequest;
import com.example.dllo.gifttalk.beantools.Values;
import com.example.dllo.gifttalk.beantools.VolleySingleton;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by dllo on 16/11/7.
 */
public class SearchSecondActivity extends BaseActivity implements View.OnClickListener {

    private ListView lv;
    private RecyclerView rv;
    private TextView search;
    private EditText et;
    private ArrayList<String> inArrayList;
    private BaseListViewAdapter<String> baseListViewAdapter;
    private SharedPreferences sp;
    private SharedPreferences.Editor spET;
    private ImageView allDelete;
    public SearchRVSecondAdapter adapter;
    private RelativeLayout allDeleteRL;
    private ImageView deleteEt;
    private String result;
    private ListView list;
    private BaseListViewAdapter searchListAdapter;

    @Override
    protected int getLayout() {
        return R.layout.second_search;
    }

    @Override
    protected void onResume() {
        super.onResume();
        et.setText("");
        list.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void initData() {

        inArrayList = new ArrayList<>();
        sp = getSharedPreferences("searchHistory", MODE_PRIVATE);
        spET = sp.edit();
        for (int i = 0; i < sp.getAll().size(); i++) {
            inArrayList.add(sp.getString(i + "", "居然没获取到数据"));
        }
        initGridView();
        initListView();
        searchListListView();
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0) {
                    deleteEt.setVisibility(View.GONE);
                    search.setText("退出");
                    list.setVisibility(View.INVISIBLE);
                } else {
                    deleteEt.setVisibility(View.VISIBLE);
                    search.setText("搜索");
                    list.setVisibility(View.VISIBLE);
                    //创建请求
                    GsonRequest<SearchListBean> gsonRequest = new GsonRequest<>(SearchListBean.class, Values.LIST_SECOND_SEARCH + et.getText().toString(), new Response.Listener<SearchListBean>() {
                        @Override
                        public void onResponse(SearchListBean response) {
                            ArrayList<String> listSearchArrayList = new ArrayList<String>();
                            for (int i = 0; i < response.getData().getWords().size(); i++) {
                                listSearchArrayList.add(response.getData().getWords().get(i).getWord());
                            }
                            searchListAdapter.setData(listSearchArrayList);
                            list.setAdapter(searchListAdapter);
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
        });
    }


    @Override
    protected void initViews() {
        deleteEt = bindView(R.id.delete_et_second_search);
        allDeleteRL = bindView(R.id.rv_alldelete_search_second);
        lv = bindView(R.id.lv_search_second);
        rv = bindView(R.id.rv_search_second);
        search = bindView(R.id.btn_search_second);
        et = bindView(R.id.et_search_second);
        allDelete = bindView(R.id.alldelete_search_second);
        list = bindView(R.id.list_second_search);
        allDelete.setOnClickListener(this);
        search.setOnClickListener(this);
        deleteEt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_search_second:
                searchBtn();
                break;
            case R.id.alldelete_search_second:
                inArrayList.clear();
                spET.clear();
                allDeleteRL.setVisibility(View.GONE);
                baseListViewAdapter.setData(inArrayList);
                break;
            case R.id.delete_et_second_search:
                et.setText("");
        }
    }

    // 点击有内容搜索,没内容退出
    private void searchBtn() {
        if (et.getText().toString().trim().length() == 0) {
            finish();
        } else {
            if (inArrayList.toString().trim() == null) {
                allDeleteRL.setVisibility(View.GONE);
            } else {
                allDeleteRL.setVisibility(View.VISIBLE);
            }

            inArrayList.add(0,et.getText().toString());
            baseListViewAdapter.setData(inArrayList);
            lv.setAdapter(baseListViewAdapter);
            Intent intent = new Intent(this, SearchThirdActivity.class);
            try {
                result = new String(et.getText().toString().trim().getBytes("UTF-8"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            intent.putExtra("utf8", result);
            startActivity(intent);
        }
    }

    private void searchListListView(){
        searchListAdapter = new BaseListViewAdapter<String>(R.layout.item_verlv_search_second) {
            @Override
            protected void bindData(final CommonViewHolder holder, final String s) {
                notifyDataSetChanged();
                holder.setText(R.id.history_search_second,s);
                holder.setViewClick(R.id.rl_lv_search, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        et.setText(s);
                        searchBtn();
                    }
                });
            }


        };

        list.setAdapter(searchListAdapter);
    }

    @Override
    public void onBackPressed() {
        if (list.getVisibility() == 0){
            et.setText("");
        }else {
            super.onBackPressed();
        }
    }

    private void initListView() {
        // 点击设置editText文字
        // 点击删除监听
        baseListViewAdapter = new BaseListViewAdapter<String>(R.layout.item_verlv_search_second) {
            @Override
            protected void bindData(final CommonViewHolder holder, String s) {
                notifyDataSetChanged();
                holder.setText(R.id.history_search_second, s);
                holder.setViewClick(R.id.rl_lv_search, new View.OnClickListener() {
                    private String result;

                    @Override
                    public void onClick(View view) {
                        // 点击设置editText文字
                        et.setText(inArrayList.get(holder.getPos()));
                        inArrayList.add(0, inArrayList.get(holder.getPos()));
                        inArrayList.remove(holder.getPos() + 1);
                        if (inArrayList.toString().trim() == null) {
                            allDeleteRL.setVisibility(View.GONE);
                        } else {
                            allDeleteRL.setVisibility(View.VISIBLE);
                        }
                        notifyDataSetChanged();
                        Intent intent = new Intent(SearchSecondActivity.this, SearchThirdActivity.class);
                        try {
                            result = new String(et.getText().toString().trim().getBytes("UTF-8"), "UTF-8");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        intent.putExtra("utf8", result);
                        startActivity(intent);
                    }
                });
                // 点击删除监听
                holder.setViewClick(R.id.delete_search_second, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        inArrayList.remove(holder.getPos());

                        if (inArrayList.size() == 0) {
                            allDeleteRL.setVisibility(View.GONE);
                        } else {
                            allDeleteRL.setVisibility(View.VISIBLE);
                        }
                        notifyDataSetChanged();
                    }
                });
            }
        };
        if (inArrayList.toString().trim() == null) {
            allDeleteRL.setVisibility(View.GONE);
        } else {
            allDeleteRL.setVisibility(View.VISIBLE);
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
            spET.putString(i + "", inArrayList.get(i));
        }
        spET.commit();
        super.onPause();
    }


    public void initGridView() {
        //创建请求
        GsonRequest<SearchSecondBean> gsonRequest = new GsonRequest<>(SearchSecondBean.class, Values.SECOND_SEARCH, new Response.Listener<SearchSecondBean>() {
            @Override
            public void onResponse(SearchSecondBean response) {
                adapter = new SearchRVSecondAdapter();
                adapter.setSearchSecondBean(response);
                rv.setAdapter(adapter);
                StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.VERTICAL);
                rv.setLayoutManager(manager);
                if (sp.getAll().size() == 0) {
                    allDeleteRL.setVisibility(View.GONE);
                } else {
                    allDeleteRL.setVisibility(View.VISIBLE);
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
    public class SearchRVSecondAdapter extends RecyclerView.Adapter<SearchRVSecondAdapter.ViewHolder> {

        SearchSecondBean searchSecondBean;

        public void setSearchSecondBean(SearchSecondBean searchSecondBean) {
            this.searchSecondBean = searchSecondBean;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horsearch_second, parent, false);
            ViewHolder viewholder = new ViewHolder(v);
            return viewholder;
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.tv.setText(searchSecondBean.getData().getHot_words().get(position));
            holder.tv.setOnClickListener(new View.OnClickListener() {
                private String result;

                @Override
                public void onClick(View view) {
                    allDeleteRL.setVisibility(View.VISIBLE);
                    et.setText(searchSecondBean.getData().getHot_words().get(position));
                    inArrayList.add(0, searchSecondBean.getData().getHot_words().get(position));
                    baseListViewAdapter.setData(inArrayList);
                    Intent intent = new Intent(SearchSecondActivity.this, SearchThirdActivity.class);
                    try {
                        result = new String(et.getText().toString().trim().getBytes("UTF-8"), "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    intent.putExtra("utf8", result);
                    startActivity(intent);
                }
            });
            if (position < 3) {
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
