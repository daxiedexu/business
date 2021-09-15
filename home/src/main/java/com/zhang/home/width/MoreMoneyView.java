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
        textPaint = new Paint();
        textPaint.setTextSize(36);
        textPaint.setColor(Color.BLACK);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setStrokeWidth(10);
        mPath = new Path();
        mPaint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.moveTo(80,200);
        mPath.lineTo(200,200);
        mPath.lineTo(200,300);
        mPath.close();
        canvas.drawPath(mPath,mPaint);
    }
}
