package com.zhang.home;

import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zhang.common.utils.Config;
import com.zhang.mvp_core.view.BaseActivity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName LiveActivity
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/24 19:01
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
@Route(path=Config.MODULE_LIVE)
public class LiveActivity extends BaseActivity implements OnItemClickListener {
    private RecyclerView liveRv;
    Random random;


    @Override
    protected void initData() {
        ArrayList<String> strings=new ArrayList<>( );
        strings.add("直播1");
        strings.add("直播2");
        strings.add("直播3");
        strings.add("直播4");
        strings.add("直播5");

        random=new Random( );
        liveRv.setLayoutManager(new LinearLayoutManager(this));
        LiveAdapter liveAdapter=new LiveAdapter(strings);
        liveRv.setAdapter(liveAdapter);
        liveAdapter.setOnItemClickListener(this::onItemClick);

    }

    @Override
    protected void initView() {
        liveRv = (RecyclerView) findViewById(R.id.live_rv);
    }

    @Override
    protected int bindLayout() {
        return R.layout.live;
    }

    @Override
    public void onItemClick(@NonNull @NotNull BaseQuickAdapter<?, ?> adapter, @NonNull @NotNull View view, int position) {
        ARouter.getInstance().build(Config.MODULE_LIVE_ITEM).greenChannel().navigation();
    }

    public class LiveAdapter extends BaseQuickAdapter<String, BaseViewHolder>{

        public LiveAdapter( @Nullable List<String> data) {
            super(R.layout.live_item, data);
        }

        @Override
        protected void convert(@NotNull BaseViewHolder baseViewHolder, String s) {
            baseViewHolder.setText(R.id.live_item_tv1,s);
            baseViewHolder.setText(R.id.live_item_tv2,random.nextInt( 1000)+"人正在观看");
        }
    }
}
