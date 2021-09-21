package com.zhang.kinds.view;

import android.util.Log;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.zhang.kinds.R;
import com.zhang.kinds.adapter.KindsAdapter;
import com.zhang.kinds.adapter.KindsAdapters;
import com.zhang.kinds.contrant.KindsContrant;
import com.zhang.kinds.net.di.component.DaggerKindsComponent;
import com.zhang.kinds.net.di.module.KindsViewModule;
import com.zhang.kinds.net.entitiy.KindsEntitiy;
import com.zhang.kinds.presenter.KindsPresenterImpl;
import com.zhang.mvp_core.view.BaseMVPFragment;

import java.util.List;

import javax.inject.Inject;

public class KindsFragment  extends BaseMVPFragment implements KindsContrant {
    @Inject
    KindsPresenterImpl kindsPresenter;
    private RecyclerView kindsRvGroup;
    private ViewPager kindsVpDetail;

    @Override
    protected void injectComponent() {
        DaggerKindsComponent.builder().fragmentComponent(fragmentComponent)
                .kindsViewModule(new KindsViewModule(this))
                .build().injectKinds(this);

    }

    @Override
    public void kindsSuccess(KindsEntitiy kindsEntitiy) {
        List<KindsEntitiy.DataBean> data = kindsEntitiy.getData();
        Log.i("111111", "kindsSuccess: "+data.size());
        KindsAdapter kindsAdapter = new KindsAdapter(getActivity(), data);
        KindsAdapters kindsAdapters = new KindsAdapters(data);
        kindsRvGroup.addItemDecoration(new DividerItemDecoration(getActivity(),1));

        kindsRvGroup.setLayoutManager(new LinearLayoutManager(getActivity()));

        kindsRvGroup.setAdapter(kindsAdapters);
    }

    @Override
    public void kindsFailds(Throwable throwable) {

    }
    @Override
    protected int bindLayout() {
        return R.layout.fragment_kinds;
    }

    @Override
    protected void initData() {
        kindsPresenter.showKinds();
    }

    @Override
    protected void initView() {
        kindsRvGroup = (RecyclerView) getActivity().findViewById(R.id.kinds_rv_group);
        kindsVpDetail = (ViewPager) getActivity().findViewById(R.id.kinds_vp_detail);
    }

}