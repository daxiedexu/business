package com.zhang.kinds;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhang.kinds.contrant.KindsContrant;
import com.zhang.kinds.net.entitiy.KindsEntitiy;
import com.zhang.kinds.presenter.KindsPresenterImpl;
import com.zhang.kinds.repository.KindsRepositoryImpl;
import com.zhang.mvp_core.view.BaseFragment;

import java.util.List;

public class KindsFragment extends BaseFragment<KindsPresenterImpl> implements KindsContrant.KindsView {


    @Override
    public void kindsSuccess(KindsEntitiy kindsEntitiy) {
        List<KindsEntitiy.DataBean> data = kindsEntitiy.getData();
        Log.d("123456", "kindsSuccess: "+data.size());
    }

    @Override
    public void kindsFailds(Throwable throwable) {

    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_kinds;
    }

    @Override
    protected void initInject() {

    }

    @Override
    protected void initData() {
        pPresenter=new KindsPresenterImpl(new KindsRepositoryImpl(),this);
        pPresenter.showKinds();
    }

    @Override
    protected void initView() {

    }
}