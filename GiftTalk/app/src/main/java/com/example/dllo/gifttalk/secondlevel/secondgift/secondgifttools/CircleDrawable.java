package com.example.dllo.gifttalk.secondlevel.secondgift.secondgifttools;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/**
 * Created by dllo on 16/11/7.
 * 显示圆形图片的Drawable
 */
public class CircleDrawable extends Drawable {
    private Bitmap mBitmap; // 原始图片
    private Paint mPaint; // 画笔
    private int r; // 半径

    public CircleDrawable(Bitmap bitmap) {
        mBitmap = bitmap;
        mPaint = new Paint();
        mPaint.setAntiAlias(true); // 抗锯齿
        // MIRROR 镜像翻转 REPEAT重复 CLAMP 固定模式
        // 参数二 横向模式 参数三 纵向模式
        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mPaint.setShader(shader); // 设置画笔的花纹
        // 计算出半径
        r = Math.min(mBitmap.getHeight()/2,mBitmap.getWidth()/2);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawCircle(mBitmap.getWidth()/2,mBitmap.getHeight()/2,r,mPaint);
    }

    @Override
    public void setAlpha(int i) {
        mPaint.setAlpha(i);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }


    @Override
    public int getOpacity() {
        return PixelFormat.UNKNOWN;
    }

    // 负责告诉Drawable 它的宽和高是多少
    @Override
    public int getIntrinsicHeight() {
        return 2 * r;
    }

    @Override
    public int getIntrinsicWidth() {
        return 2 * r;
    }

}
