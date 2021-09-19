package com.zhang.home.width;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;

/**
 * @ClassName MoreMoneyView
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/13 8:10
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class MoreMoneyView extends androidx.appcompat.widget.AppCompatTextView {
    private Paint mPaint;
    private Paint textPaint;
    private Path mPath;
    private Path textPath;
    public MoreMoneyView(Context context) {
        super(context);
        init();
    }

    public MoreMoneyView(Context context,AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MoreMoneyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPath = new Path();
        textPaint = new Paint();
        textPath = new Path();
        //属性设置
        textPaint.setTextSize(30);
        textPaint.setColor(Color.WHITE);
        textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.moveTo(80,0);
        mPath.lineTo(200,0);
        mPath.lineTo(200,100);
        mPath.close();
        textPath.lineTo(300,80);
        textPath.moveTo(200,200);
        textPath.close();
        canvas.drawPath(mPath,mPaint);
        canvas.drawTextOnPath("折扣",textPath,0,0,textPaint);
    }
}
