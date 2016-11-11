package com.example.dllo.gifttalk.secondlevel.secondprofile;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.dllo.gifttalk.ComPic;
import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseActivity;

/**
 * Created by dllo on 16/11/10.
 */
public class SettingActivity extends BaseActivity implements View.OnClickListener {

    private ImageView back;
    private LinearLayout mystatus;
    private ImageView background;
    private ImageView backPopup;
    private PopupWindow popupWindow;
    private Button next;
    private RadioButton boyCheck;
    private RadioButton girlCheck;

    @Override
    protected void initData() {

    }

    @Override
    protected void initViews() {
        back = bindView(R.id.back_setting);
        //我的身份
        mystatus = bindView(R.id.mystatus_setting);
        background = bindView(R.id.background_setting);

        onItemClickSetting();
    }

    private void onItemClickSetting() {
        back.setOnClickListener(this);

        mystatus.setOnClickListener(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.setting;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.back_setting:
                finish();
                break;
            case R.id.mystatus_setting:
                mystatusPopupWindow();
                break;

        }
    }

    private void mystatusPopupWindow() {

        // 屏幕截图
        Bitmap bitmap = myShot(SettingActivity.this);
        // 截图虚化
        background.setImageBitmap(ComPic.doBlur(bitmap,1,false));

        background.setVisibility(View.VISIBLE);
        View view = LayoutInflater.from(this).inflate(R.layout.popupwidow_mystatus,null);
        next = (Button) view.findViewById(R.id.next_mystatus_setting);
        backPopup = (ImageView) view.findViewById(R.id.back_popupwindow_setting);
        boyCheck = (RadioButton) view.findViewById(R.id.check_boy_popupwindow);
        girlCheck = (RadioButton) view.findViewById(R.id.check_girl_popupwindow);
        backPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (boyCheck.isChecked()){
                    Toast.makeText(SettingActivity.this, "boy", Toast.LENGTH_SHORT).show();
                }if (girlCheck.isChecked()){
                    Toast.makeText(SettingActivity.this, "girl", Toast.LENGTH_SHORT).show();
                }
            }
        });


        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        // 实例化一个ColorDrawable颜色
        ColorDrawable dw = new ColorDrawable(getResources().getColor(R.color.NO));
        popupWindow.setBackgroundDrawable(dw);
        // 焦点是否可以改变到窗口外
        popupWindow.setFocusable(true);


        ObjectAnimator ota4 = ObjectAnimator.ofFloat(view,"translationY",-600,-450,80,0,-30,0);
        // 补间动画
//        ota4.setInterpolator(new BounceInterpolator());//跳动
        ota4.setDuration(700);
        ota4.start();

        ObjectAnimator ota3 = ObjectAnimator.ofFloat(view,"rotation",20,5,0);
        ota3.setDuration(700);
        ota3.start();

        popupWindow.showAtLocation(backPopup, Gravity.NO_GRAVITY,0,0);





        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                background.setVisibility(View.INVISIBLE);
            }
        });

    }

    public Bitmap myShot(Activity activity) {
        // 获取windows中最顶层的view
        View view = activity.getWindow().getDecorView();
        view.buildDrawingCache();

        // 获取状态栏高度
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int statusBarHeights = rect.top;
        Display display = activity.getWindowManager().getDefaultDisplay();

        // 获取屏幕宽和高
        int widths = display.getWidth();
        int heights = display.getHeight();

        // 允许当前窗口保存缓存信息
        view.setDrawingCacheEnabled(true);

        // 去掉状态栏
        Bitmap bmp = Bitmap.createBitmap(view.getDrawingCache(), 0,
                statusBarHeights, widths, heights - statusBarHeights);

        // 销毁缓存信息
        view.destroyDrawingCache();
//        bmp.setConfig(Bitmap.Config.RGB_565);
        return bmp;
    }


//    public Bitmap suofangBitmap(Bitmap bitmap){
//        Bitmap bitmap1 = BitmapFactory.decodeResource()
//
//
//        return bitmap;
//    }
}
