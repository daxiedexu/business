package com.zhang.home.width;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @ClassName SlantView
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/13 17:06
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class SlantView extends View {
    private Paint textPaint;
    public SlantView(Context context) {
        super(context);
        init();
    }

    public SlantView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SlantView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        textPaint = new Paint();
        textPaint.setTextSize(36);
        textPaint.setColor(Color.BLACK);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setStrokeWidth(10);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.rotate(30, this.getWidth() / 2f, this.getHeight() / 2f);
        canvas.drawText("折扣",80,200,textPaint);
    }
}
