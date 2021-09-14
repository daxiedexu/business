package com.zhang.mvp_core.view;

import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.zhang.mvp_core.presenter.IPresenter;

import javax.inject.Inject;

/**
 * @ClassName BaseActivity
 * @Author 孔晨亮
 * @Date 2021/9/3 10:01
 * User: msi
 */
public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity {

    protected P pPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        initView();
        initData();
        //注入Dagger2
        initInject();
    }

    protected abstract void initInject();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int bindLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (pPresenter!=null){
            pPresenter.destory();
            pPresenter=null;
        }
    }
}
