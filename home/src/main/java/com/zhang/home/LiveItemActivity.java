package com.zhang.home;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.zhang.common.utils.Config;
import com.zhang.mvp_core.view.BaseActivity;

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
    @Override
    protected void initData() {
        //mPlayerView 即 step1 中添加的界面 view
        TXCloudVideoView mView = (TXCloudVideoView)findViewById(R.id.video_view);

        //创建 player 对象
        TXLivePlayer mLivePlayer = new TXLivePlayer(this);

        //关键 player 对象与界面 view
        mLivePlayer.setPlayerView(mView);
        String flvUrl = "https://tv.cctv.com/live/index.shtml?spm=C28340.P9dhkRStLqPh.ENlPq2DiQc4R.2";
        mLivePlayer.startPlay(flvUrl, TXLivePlayer.PLAY_TYPE_LIVE_FLV); //推荐 FLV
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int bindLayout() {
        return R.layout.live_page;
    }
}
