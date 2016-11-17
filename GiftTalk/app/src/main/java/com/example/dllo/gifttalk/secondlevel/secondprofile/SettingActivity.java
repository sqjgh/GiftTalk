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
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.gifttalk.ComPic;
import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseActivity;
import com.example.dllo.gifttalk.tools.Values;

import java.util.ArrayList;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

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
    private View popupView;
    private TextView jobSetting;
    private TextView sexSetting;
    private boolean popupWindowShow = false;
    private static Bitmap bg;

    @Override
    protected void initData() {

    }

    @Override
    protected void initViews() {
        back = bindView(R.id.back_setting);
        //我的身份
        mystatus = bindView(R.id.mystatus_setting);
        background = bindView(R.id.background_setting);

        sexSetting = bindView(R.id.tv_sex_setting);
        jobSetting = bindView(R.id.tv_job_setting);
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
        switch (view.getId()) {
            case R.id.back_setting:
                finish();
                break;
            case R.id.mystatus_setting:
                popupWindowShow = !popupWindowShow;
                if (popupWindowShow){
                    mystatusPopupWindow();
                }
                break;

        }
    }

    private void mystatusPopupWindow() {
        final ArrayList<String> set = new ArrayList<>();
        if (bg == null) {
            // 屏幕截图
            Bitmap bitmap = myShot(SettingActivity.this);
            // 图片压缩
            Bitmap bitmapQuarter = resizeAccurate(bitmap.getWidth() / 5, bitmap.getHeight() / 5, bitmap);
            bg = ComPic.doBlur(bitmapQuarter, 4, false);
        }
        // 截图虚化
        background.setImageBitmap(bg);

        background.setVisibility(View.VISIBLE);
        popupView = LayoutInflater.from(this).inflate(R.layout.popupwidow_mystatus, null);
        next = (Button) popupView.findViewById(R.id.next_mystatus_setting);
        backPopup = (ImageView) popupView.findViewById(R.id.back_popupwindow_setting);
        boyCheck = (RadioButton) popupView.findViewById(R.id.check_boy_popupwindow);
        girlCheck = (RadioButton) popupView.findViewById(R.id.check_girl_popupwindow);
        backPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (boyCheck.isChecked()) {
                    Values.USER_SEX = "boy";
                    set.add("男孩");
                }
                if (girlCheck.isChecked()) {
                    Values.USER_SEX = "girl";
                    set.add("女孩");
                }

//                ObjectAnimator ota4 = ObjectAnimator.ofFloat(popupView, "translationY", 0, -30, 1000);
//                ota4.setDuration(500);
//                ota4.start();
                // TODO 属性动画结束的监听
                popupWindow.dismiss();
                background.setVisibility(View.VISIBLE);
                // job页面popupWindow
                final View jobPopupView = LayoutInflater.from(SettingActivity.this).inflate(R.layout.job_popupwindow_setting, null);
                ImageView back = (ImageView) jobPopupView.findViewById(R.id.back_job_popupwindow);
                ImageView close = (ImageView) jobPopupView.findViewById(R.id.close_job_popupwindow_setting);
                final RadioGroup group = (RadioGroup) jobPopupView.findViewById(R.id.radiogroup_job);
                TextView save = (Button) jobPopupView.findViewById(R.id.save_job_popupwindow_setting);

                final PopupWindow jobPopupWindow = new PopupWindow(jobPopupView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                ColorDrawable dw = new ColorDrawable(getResources().getColor(R.color.NO));
                jobPopupWindow.setBackgroundDrawable(dw);
                // 焦点是否可以改变到窗口外
                jobPopupWindow.setFocusable(true);
                ObjectAnimator ota1 = ObjectAnimator.ofFloat(jobPopupView, "translationY", -600, -450, 80, 0, -30, 0);
                //插值器
//              ota4.setInterpolator(new BounceInterpolator());//跳动
                ota1.setDuration(700);
                ota1.start();

                ObjectAnimator ota2 = ObjectAnimator.ofFloat(jobPopupView, "rotation", 20, 5, 0);
                ota2.setDuration(700);
                ota2.start();
                jobPopupWindow.showAtLocation(backPopup, Gravity.NO_GRAVITY, 0, 0);


                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int select = group.getCheckedRadioButtonId();
                        switch (select) {
                            case R.id.mid_job_popupwindow:
                                set.add("初中生");
                                break;
                            case R.id.high_job_popupwindow:
                                set.add("高中生");
                                break;
                            case R.id.big_job_popupwindow:
                                set.add("大学生");
                                break;
                            case R.id.new_job_popupwindow:
                                set.add("职场新人");
                                break;
                            case R.id.old_job_popupwindow:
                                set.add("资深工作党");
                                break;
                        }

                        jobPopupWindow.dismiss();
                        sexSetting.setText(set.get(0));
                        jobSetting.setText(set.get(1));
                        // 检测是否登录状态
                        UserBean userBean = UserBean.getCurrentUser(UserBean.class);
                        if (userBean != null) {
                            userBean.setSex(Values.USER_SEX);
                            userBean.update(userBean.getObjectId(), new UpdateListener() {
                                @Override
                                public void done(BmobException e) {
                                    if(e==null){

                                    }else{
                                        Toast.makeText(SettingActivity.this, "设置数据同步失败", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    }
                });
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        jobPopupWindow.dismiss();
                        mystatusPopupWindow();

                    }
                });
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        jobPopupWindow.dismiss();
                    }
                });
                jobPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        background.setVisibility(View.INVISIBLE);

                    }
                });
            }
        });


        popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        // 实例化一个ColorDrawable颜色
        ColorDrawable dw = new ColorDrawable(getResources().getColor(R.color.NO));
        popupWindow.setBackgroundDrawable(dw);
        // 焦点是否可以改变到窗口外
        popupWindow.setFocusable(true);


        ObjectAnimator ota4 = ObjectAnimator.ofFloat(popupView, "translationY", -600, -450, 80, 0, -30, 0);
        //插值器
//        ota4.setInterpolator(new BounceInterpolator());//跳动
        ota4.setDuration(700);
        ota4.start();

        ObjectAnimator ota3 = ObjectAnimator.ofFloat(popupView, "rotation", 20, 5, 0);
        ota3.setDuration(700);
        ota3.start();

        popupWindow.showAtLocation(backPopup, Gravity.NO_GRAVITY, 0, 0);


        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                background.setVisibility(View.INVISIBLE);
                popupWindowShow = false;
            }
        });

    }

    /**
     * @param reqW   目标宽
     * @param reqH   目标高
     * @param bitmap 元素图片
     * @return 压缩后的图片
     */
    private Bitmap resizeAccurate(int reqW, int reqH, Bitmap bitmap) {
        float scaled = Math.max(bitmap.getHeight() / reqH, bitmap.getWidth() / reqW);
        reqH = (int) (bitmap.getHeight() / scaled);
        reqW = (int) (bitmap.getWidth() / scaled);
        bitmap = bitmap.createScaledBitmap(bitmap, reqW, reqH, false);
        return bitmap;
    }

    // 更新性别
    public void updataSex(){

    }

    /**
     * 原图不加载进内存, 通过采样率来压缩图片
     * 用采样率压缩的好处是原图不加载进内存, 但是, 不能做到精确的压缩到目标宽高
     * 采样率的有效值, 只能是2的整数次幂 , 如果不是, 就会自动改为最接近的值
     * <p>
     * //     * @param reqW 目标宽
     * //     * @param reqH 目标高
     *
     * @return 压缩后的图片
     */
//    private Bitmap resize(int reqW, int reqH) {
//        // 加载图片的设置类, 可以设置怎么加载图片
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        // 只解码图片的宽高, 使用这个options, 不会真正把图片加载进内存
//        // 只会读取图片的宽高信息
//        options.inJustDecodeBounds = true;
//        // 使用这个options来加载图片
//        BitmapFactory.decodeResource(getResources(), R.mipmap.test, options);
//        // 拿到图片的宽高信息
//        int w = options.outWidth;
//        int h = options.outHeight;
//        // 设定采样率, 由宽/ 目标宽 和高/ 目标高的最大值决定
//        // 采样率越大 图片越小
//        options.inSampleSize = Math.max(w / reqW, h / reqH);
//        // 不只解析宽高信息
//        options.inJustDecodeBounds = false;
//        //获得压缩后的图片
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test, options);
//        return bitmap;
//    }
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
        return bmp;
    }


}
