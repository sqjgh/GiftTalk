package com.example.dllo.gifttalk;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/24.
 * //TODO 刷新图片默认是机器人
 *
 */
public class Values {
    public static final int TAB_COLOR = 0xFF2D47;
    // 首页
    public static final String TABLAYOUT_URL_HOME = "http://api.liwushuo.com/v2/channels/preset?gender=1&generation=4";
    public static final String ROLLVIEW_URL = "http://api.liwushuo.com/v2/banners";
    public static ArrayList<String> TABLAYOUT_ID_HOME;
    public static final String TABLAYOUT_ITEMSFRONT_HOME = "http://api.liwushuo.com/v2/channels/";
    public static final String TABLAYOUT_ITEMSBACK_HOME = "/items?ad=2&gender=1&generation=4&limit=20&set=0";
    // 榜单
    public static final String TABLAYOUT_ITEMSFRONT_GIFT= "http://api.liwushuo.com/v2/ranks_v2/ranks/";
    public static final String TABLAYOUT_ITEMSBACK_GIFT= "?limit=20&offset=0";
    public static final String TABLAYOUT_URL_GIFT= "http://api.liwushuo.com/v2/ranks_v2/ranks";
    public static ArrayList<String> TABLAYOUT_ID_GIFT;
    // 分类- 栏目
    public static final String COLUMN_RAIDERS_CATEGORY = "http://api.liwushuo.com/v2/columns?limit=20&offset=0";
    // 攻略--listView
    public static final String ALL_RAIDERS_CATEGORY = "http://api.liwushuo.com/v2/channel_groups/all";



}
