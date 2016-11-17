package com.example.dllo.gifttalk.secondlevel.secondgift;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.secondlevel.secondgift.secondgiftbeans.CommentGiftBeans;
import com.example.dllo.gifttalk.tools.VolleySingleton;

import java.text.SimpleDateFormat;

/**
 * Created by dllo on 16/11/5.
 */
public class CommentSecondLVAdapter extends BaseAdapter{
    private CommentGiftBeans commentGiftBeans;

    public void setCommentGiftBeans(CommentGiftBeans commentGiftBeans) {
        this.commentGiftBeans = commentGiftBeans;
    }


    @Override
    public int getCount() {
        return commentGiftBeans.getData().getComments().size();
    }

    @Override
    public Object getItem(int i) {
        return commentGiftBeans.getData().getComments().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_second_comment_gift,viewGroup,false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

            viewHolder.name.setText(commentGiftBeans.getData().getComments().get(i).getUser().getNickname());
            viewHolder.text.setText(commentGiftBeans.getData().getComments().get(i).getContent());
            VolleySingleton.getInstance().getImage(commentGiftBeans.getData().getComments().get(i).getUser().getAvatar_url(),viewHolder.pic);

            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
            String time = format.format(Long.valueOf(commentGiftBeans.getData().getComments().get(i).getCreated_at())*1000);
            viewHolder.time.setText(time);



        return view;
    }

    private class ViewHolder {

        private ImageView pic;
        private TextView name;
        private TextView time;
        private TextView text;


        public ViewHolder(View view) {
            pic = (ImageView) view.findViewById(R.id.pic_second_comment_gift);
            name = (TextView) view.findViewById(R.id.name_second_comment_gift);
            time = (TextView) view.findViewById(R.id.time_second_comment_gift);
            text = (TextView) view.findViewById(R.id.text_second_comment_gift);
        }
    }
}
