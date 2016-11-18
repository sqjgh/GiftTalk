package com.example.dllo.gifttalk.secondlevel.secondprofile;

import android.util.Log;
import android.widget.ListView;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseActivity;
import com.example.dllo.gifttalk.base.BaseListViewAdapter;
import com.example.dllo.gifttalk.base.CommonViewHolder;

import java.util.ArrayList;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;

/**
 * Created by dllo on 16/11/17.
 */
public class FollowActivity extends BaseActivity{

    private ListView lv;
    private ArrayList<String> collect;

    @Override
    protected void initData() {
        // 网络拉取收藏记录
        initUserData();

    }

    @Override
    protected void initViews() {
        lv = bindView(R.id.lv_collect_profile);
    }

    @Override
    protected int getLayout() {
        return R.layout.follow_profile;
    }

    private void initUserData() {

        // 获取网络存取的收藏
        UserBean userBean = UserBean.getCurrentUser(UserBean.class);
        if (userBean != null){
            BmobQuery<UserBean> query = new BmobQuery<UserBean>();
            query.getObject(userBean.getObjectId(), new QueryListener<UserBean>() {

                @Override
                public void done(UserBean object, BmobException e) {
                    if(e==null){
                        //收藏记录
                        collect = object.getCollect();
                        Log.d("F11111", "collect.size():" + collect.size());
                        initListViewAdapter();
                    }else{
                        Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                    }
                }
            });
        }
    }


    private void initListViewAdapter(){
        BaseListViewAdapter<String> baseListViewAdapter = new BaseListViewAdapter<String>(R.layout.item_verlv_search_second) {
            @Override
            protected void bindData(CommonViewHolder holder, String s) {
                holder.setText(R.id.history_search_second,s);
            }
        };

        lv.setAdapter(baseListViewAdapter);
        baseListViewAdapter.setData(collect);
    }

}
