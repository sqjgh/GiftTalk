package com.example.dllo.gifttalk.beantools;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/24.
 *
 *
 */
public final class Values {
    public static final int TAB_COLOR = 0xFF2D47;
    // 首页
    public static final String TABLAYOUT_URL_HOME = "http://api.liwushuo.com/v2/channels/preset?gender=1&generation=4";
    public static final String ROLLVIEW_URL = "http://api.liwushuo.com/v2/banners";
    public static ArrayList<String> TABLAYOUT_ID_HOME;
    public static final String TABLAYOUT_ITEMSFRONT_HOME = "http://api.liwushuo.com/v2/channels/";
    public static final String TABLAYOUT_ITEMSBACK_HOME = "/items_v2?ad=2&gender=1&generation=1&limit=20&offset=0";
    // 榜单
    public static final String TABLAYOUT_ITEMSFRONT_GIFT= "http://api.liwushuo.com/v2/ranks_v2/ranks/";
    public static final String TABLAYOUT_ITEMSBACK_GIFT= "?limit=20&offset=0";
    public static final String TABLAYOUT_URL_GIFT= "http://api.liwushuo.com/v2/ranks_v2/ranks";
    public static ArrayList<String> TABLAYOUT_ID_GIFT;
    // 分类- 栏目
    public static final String COLUMN_RAIDERS_CATEGORY = "http://api.liwushuo.com/v2/columns?limit=20&offset=0";
    // 攻略--listView
    public static final String ALL_RAIDERS_CATEGORY = "http://api.liwushuo.com/v2/channel_groups/all";
    // 单品
    public static final String SINGLE_CATEGORY = "http://api.liwushuo.com/v2/item_categories/tree";
    // 首页普通二级

    //榜单--二级界面
    public static final String SECOND_GIFT_FRONT = "http://api.liwushuo.com/v2/items/";
    public static final String SECOND_GIFT_BACK = "/recommend?num=20&post_num=5";
    // 榜单二级界面  评论
    public static final String SECOND_COMMENTS_FRONT = "http://api.liwushuo.com/v2/items/";
    public static final String SECOND_COMMENTS_BACK = "/comments?limit=20&offset=0";

    //搜索
    public static final String SECOND_SEARCH = "http://api.liwushuo.com/v2/search/hot_words";

    // 点击搜索
    public  static  final String RAIDERS_KEY_FRONT ="http://api.liwushuo.com/v2/search/post?keyword=";
    public  static  final String RAIDERS_KEY_BACK = "&limit=40&offset=0&sort=";


    public static  final  String SINGLE_KEY_FRONT = "http://api.liwushuo.com/v2/search/item?keyword=";
    public static  final  String SINGLE_KEY_BACK = "&limit=40&offset=0&sort=";

}
