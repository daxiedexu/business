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
        textPaint = new Paint();
        textPaint.setTextSize(30);
        textPaint.setColor(Color.WHITE);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setStrokeWidth(12);
        mPath = new Path();
        textPath = new Path();
        mPaint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.moveTo(80,0);
        mPath.lineTo(200,0);
        mPath.lineTo(200,100);
        mPath.close();
        textPath.lineTo(200,80);
        textPath.lineTo(200,130);
        canvas.drawPath(mPath,mPaint);
        canvas.drawTextOnPath("折扣",textPath,20,-17,textPaint);
    }
}
