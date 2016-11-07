//package com.example.dllo.gifttalk.secondlevel.secondhome;
//
//import android.graphics.Color;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.example.dllo.gifttalk.R;
//import com.example.dllo.gifttalk.beans.SearchSecondBean;
//
///**
// * Created by dllo on 16/11/7.
// */
//public class SearchRVSecondAdapter extends RecyclerView.Adapter<SearchRVSecondAdapter.ViewHolder>{
//    OnTextClickListener onTextClickListener;
//    SearchSecondBean searchSecondBean;
//
//    public void setOnTextClickListener(OnTextClickListener onTextClickListener) {
//        this.onTextClickListener = onTextClickListener;
//    }
//
//    public void setSearchSecondBean(SearchSecondBean searchSecondBean) {
//        this.searchSecondBean = searchSecondBean;
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horsearch_second,parent,false);
//        ViewHolder viewholder = new ViewHolder(v);
//        return viewholder;
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, final int position) {
//        holder.tv.setText(searchSecondBean.getData().getHot_words().get(position));
//        holder.tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onTextClickListener.OnTextClick(searchSecondBean.getData().getHot_words().get(position));
//            }
//        });
//        if (position < 3){
//            holder.tv.setTextColor(Color.RED);
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return searchSecondBean.getData().getHot_words().size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//
//        private final TextView tv;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            tv = (TextView) itemView.findViewById(R.id.tv_horsearch_second);
//        }
//    }
//}
