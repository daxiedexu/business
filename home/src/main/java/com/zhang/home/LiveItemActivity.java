package com.zhang.home;

import android.animation.ObjectAnimator;
import android.view.SurfaceControl;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.zhang.common.utils.Config;
import com.zhang.mvp_core.view.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName LiveItemActivity
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/25 18:38
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */

@Route(path=Config.MODULE_LIVE_ITEM)
public class LiveItemActivity extends BaseActivity {
    private LinearLayout card;
    TXCloudVideoView mView;
    TXLivePlayer mLivePlayer;
    Timer timer;

    @Override
    protected void initData() {
        //mPlayerView 即 step1 中添加的界面 view

        mView=(TXCloudVideoView)findViewById(R.id.video_view);
        //创建 player 对象

        mLivePlayer=new TXLivePlayer(this);
        //关键 player 对象与界面 view
        mLivePlayer.setPlayerView(mView);
        String flvUrl = "https://txdirect.flv.huya.com/src/71862053-2645534014-11362482070585606144-3684952466-10057-A-0-1.flv?wsSecret=03dd117686e19c0eeec49231e55fa29e&wsTime=61601dfb&seqid=3095818531908&ctype=tars_mobile&ver=1&txyp=o%3Afz6%3B&fs=bgct&&sphdcdn=al_7-tx_3-js_3-ws_7-bd_2-hw_2&sphdDC=huya&sphd=264_*-265_*&t=103&ratio=2000&uid=1462215847569&uuid=3501718114&t=103&sv=2109081108";
        //String flvUrl="https://cctvksh5c.v.kcdnvip.com/live/cdrmcctv15_1/index.m3u8?BR=td&region=beijing";
        mLivePlayer.startPlay(flvUrl, TXLivePlayer.PLAY_TYPE_VOD_HLS); //推荐 FLV

        timer=new Timer( );


            timer.schedule(new TimerTask( ) {
                @Override
                public void run() {
                    card.post(new Runnable( ) {
                        @Override
                        public void run() {
                            card.setVisibility(View.VISIBLE);
                            ObjectAnimator translationX=ObjectAnimator.ofFloat(card, "TranslationX", 800, 0);
                            translationX.setDuration(3000);
                            translationX.start();
                            timer.schedule(new TimerTask( ) {
                                @Override
                                public void run() {
                                    card.post(new Runnable( ) {
                                        @Override
                                        public void run() {
                                            ObjectAnimator translationX=ObjectAnimator.ofFloat(card, "TranslationX", 0, 800);
                                            translationX.setDuration(3000);
                                            translationX.start();
                                        }
                                    });
                                }
                            },6000);
                        }
                    });
                }
            },3000);

        }

    @Override
    protected void initView() {
        card = (LinearLayout) findViewById(R.id.card);
    }

    @Override
    protected int bindLayout() {
        return R.layout.live_page;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy( );
        timer.cancel();
        mLivePlayer.stopPlay(true); // true 代表清除最后一帧画面
        mView.onDestroy();
    }
}
