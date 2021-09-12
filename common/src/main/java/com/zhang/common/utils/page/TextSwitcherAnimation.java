package com.zhang.common.utils.page;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.List;

/**
 * @ClassName TextSwitcherAnimation
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/11 18:55
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class TextSwitcherAnimation {
    private int marker;
    private int delayTime=2000;
    private List<String> list;
    private TextSwitcher textSwitcher;
    private AnimationSet InAnimationSet;
    private AnimationSet OutAnimationSet;
    private Handler handler = new Handler();
    private Runnable task = new Runnable() {
        @Override
        public void run() {
            nextView();
            handler.postDelayed(task,delayTime*2);
        }
    };

    public TextSwitcherAnimation setTexts(List<String> list) {
        this.list = list;
        return this;
    }

    public TextSwitcherAnimation(List<String> list, TextSwitcher textSwitcher) {
        this.list = list;
        this.textSwitcher = textSwitcher;
    }

    private void nextView() {
        marker = ++marker % list.size();
        textSwitcher.setText(list.get(marker));
    }

    public void create(){
        marker = 0;
        if (list == null){
            Log.w("TextSwitcherAnimation","list is null");
            return;
        }else if (textSwitcher == null){
            Log.w("TextSwitcherAnimation","textSwitcher  is null");
            return;
        }
        textSwitcher.setText(list.get(0));
        createAnimation();
        textSwitcher.setInAnimation(InAnimationSet);
        textSwitcher.setOutAnimation(OutAnimationSet);
        start();
    }

    public void start(){
        stop();
        handler.postDelayed(task,delayTime);
    }

    public void stop(){
        handler.removeCallbacks(task);
    }


    private void createAnimation() {
        AlphaAnimation alphaAnimation;
        TranslateAnimation translateAnimation;
        int height = textSwitcher.getHeight();
        if (height<=0){
            textSwitcher.measure(0,0);
            height = textSwitcher.getMeasuredHeight();
        }
        InAnimationSet = new AnimationSet(true);
        OutAnimationSet = new AnimationSet(true);

        alphaAnimation = new AlphaAnimation(0,1);
        translateAnimation = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0,
                Animation.ABSOLUTE, height, Animation.ABSOLUTE, 0);
        InAnimationSet.addAnimation(alphaAnimation);
        InAnimationSet.addAnimation(translateAnimation);
        InAnimationSet.setDuration(1000);

        alphaAnimation = new AlphaAnimation(1,0);
        translateAnimation = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0,
                Animation.ABSOLUTE, 0, Animation.ABSOLUTE, -height);
        OutAnimationSet.addAnimation(alphaAnimation);
        OutAnimationSet.addAnimation(translateAnimation);
        OutAnimationSet.setDuration(1000);
    }
}
