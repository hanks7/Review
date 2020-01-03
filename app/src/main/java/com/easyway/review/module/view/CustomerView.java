package com.easyway.review.module.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.hanks.frame.utils.Ulog;


/**
 * @Package: com.easyway.review.module.view.CustomerView
 * @Author: 侯建军
 * @CreateDate: 2020/1/2 13:28
 * @Description: 请填写描述
 */
public class CustomerView extends View implements View.OnClickListener {

    // 定义画笔
    private Paint mPaint;
    // 用于获取文字的宽和高
    private Rect mRect;
    // 计数值，每点击一次本控件，其值增加1
    private int mCount = 0;

    public CustomerView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // 初始化画笔、Rect
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mRect = new Rect();
        // 本控件的点击事件
        setOnClickListener(this);
    }

    /**
     * 一个int型整数可以表示两个东西（大小模式和大小的值）
     * https://blog.csdn.net/qq_24954199/article/details/48286729
     * <p>
     * //这个是由我们给出的尺寸大小和模式生成一个包含这两个信息的int变量，这里这个模式这个参数，传三个常量中的一个。
     * <p>
     * public static int makeMeasureSpec(int size, int mode)
     * <p>
     * <p>
     * <p>
     * //这个是得到这个变量中表示的模式信息，将得到的值与三个常量进行比较。
     * <p>
     * public static int getMode(int measureSpec)
     * <p>
     * <p>
     * <p>
     * //这个是得到这个变量中表示的尺寸大小的值。
     * <p>
     * public static int getSize(int measureSpec)
     * <p>
     * <p>
     * <p>
     * //把这个变量里面的模式和大小组成字符串返回来，方便打日志
     * <p>
     * public static String toString(int measureSpec)
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Ulog.i("widthMeasureSpec", MeasureSpec.toString(widthMeasureSpec));
        Ulog.i("heightMeasureSpec", MeasureSpec.toString(heightMeasureSpec));

        Ulog.i("getWidth", getWidth());
        Ulog.i("getHeight", getHeight());

        //布局的宽高都是有这个方法指定
        //指定控件的宽高,需要测量
        //获取宽高的模式
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        /**
         * MeasureSpec.AT_MOST : 在布局中指定了wrap_content
         * MeasureSpec.EXACTLY : 在不居中指定了确切的值  100dp   match_parent  fill_parent
         * MeasureSpec.UNSPECIFIED : 尽可能的大,很少能用到，ListView , ScrollView 在测量子布局的时候会用UNSPECIFIED
         */
        //获取宽高的大小
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.BLACK);
        // 绘制一个填充色为蓝色的矩形
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(50);
        String text = String.valueOf(mCount);
        // 获取文字的宽和高
        mPaint.getTextBounds(text, 0, text.length(), mRect);
        float textWidth = mRect.width();
        float textHeight = mRect.height();

        // 绘制字符串
        canvas.drawText("点了我" + text + "次", getWidth() / 2 - textWidth / 2, getHeight() / 2 + textHeight / 2, mPaint);
        Ulog.i("onDraw");
    }

    @Override
    public void onClick(View view) {
        mCount++;
        invalidate();
    }

}
