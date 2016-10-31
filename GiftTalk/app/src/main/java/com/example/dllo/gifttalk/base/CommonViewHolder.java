package com.example.dllo.gifttalk.base;



import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by dllo on 16/10/31.
 */
public class CommonViewHolder extends RecyclerView.ViewHolder{  // 不是不可以112的写法吗
    // 用它来存放所有的View, Key就是View的id
    private SparseArray<View> views;
    private View itemView; // 行布局

    public CommonViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        views = new SparseArray<>();
    }

    /**
     * 通过View的id来获得指定View
     * 如果该View没有赋值, 就先执行findViewById
     * 然后 把它放到View的集合里
     * @param id
     * @return 指定View
     * 使用泛型来取消强转
     * 泛型:方法返回值前面 类: 继承后面
     */
    public <T extends View> T getView(int id) {
        View view = views.get(id);
        if (view == null) {
            // 证明 集合里没有这个 id 的view
            view = itemView.findViewById(id);
            views.put(id, view);
        }
        return (T) view;
    }


    // 给listView使用的方法
    public static CommonViewHolder getViewHolder(View LVitemView, ViewGroup LVparent, int LVitemID){
        CommonViewHolder commonViewHolder;
        if (LVitemView == null){
            Context context = LVparent.getContext();
            LVitemView = LayoutInflater.from(context).inflate(LVitemID,LVparent,false);
            commonViewHolder = new CommonViewHolder(LVitemView);
            LVitemView.setTag(commonViewHolder);
        }else {
            commonViewHolder = (CommonViewHolder) LVitemView.getTag();
        }
        return commonViewHolder;
    }

    // 给RecycleView使用的方法
    public static CommonViewHolder getViewHolder(ViewGroup RVparent, int RVitemID){
        return getViewHolder(null,RVparent,RVitemID);
    }

    // 返回行布局
    public View getItemView() {
        return itemView;
    }

    /**************ViewHolder 设置数据的方法**************/
    public CommonViewHolder setText(int id,String text){
        TextView textView = getView(id);
        textView.setText(text);
        return this;
    }

    public CommonViewHolder setImage(int id,int imageId){
        ImageView imageView = getView(id);
        imageView.setImageResource(imageId);
        return this;
    }

    public CommonViewHolder setImage(int id,String url){
        ImageView imageView = getView(id);
        //TODO Volly 或者 picasso (网络图片请求)
        return this;
    }
    // 行布局设置点击事件
    public CommonViewHolder setItemClick(View.OnClickListener onClickListener){
        itemView.setOnClickListener(onClickListener);
        return this;
    }
    // 详细布局设置点击事件
    public CommonViewHolder setViewClick(int id, View.OnClickListener onClickListener){
        getView(id).setOnClickListener(onClickListener);
        return this;
    }
}

