package com.zhang.kinds;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.zhang.kinds.adapter.KindsAdapters;
import com.zhang.kinds.contrant.KindsContrant;
import com.zhang.kinds.net.entitiy.KindsEntitiy;
import com.zhang.kinds.presenter.KindsPresenterImpls;
import com.zhang.kinds.repository.KindsRepositoryImpl;
import com.zhang.mvp_core.view.BaseFragment;



import java.util.List;

public class KindsFragment  {


//    private RecyclerView kindsRvGroup;
//    private ViewPager kindsVpDetail;
//
//    @Override
//    public void kindsSuccess(KindsEntitiy kindsEntitiy) {
//        List<KindsEntitiy.DataBean> data = kindsEntitiy.getData();
////        KindsAdapter kindsAdapter = new KindsAdapter(getActivity(), data);
//        KindsAdapters kindsAdapters = new KindsAdapters(data);
//        kindsRvGroup.addItemDecoration(new DividerItemDecoration(getActivity(),1));
//
//        kindsRvGroup.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
//
//        kindsRvGroup.setAdapter(kindsAdapters);
//
//        kindsAdapters.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter,@NotNull View view, int position) {
//
//            }
//        });
//    }
//
//    @Override
//    public void kindsFailds(Throwable throwable) {
//
//    }
//
//    @Override
//    protected int bindLayout() {
//        return R.layout.fragment_kinds;
//    }
//
//    @Override
//    protected void initInject() {
//
//    }
//
//    @Override
//    protected void initData() {
//        pPresenter = new KindsPresenterImpls(new KindsRepositoryImpl(),this);
//        pPresenter.showKinds();
//    }
//
//    @Override
//    protected void initView() {
//
//        kindsRvGroup = (RecyclerView) getActivity().findViewById(R.id.kinds_rv_group);
//        kindsVpDetail = (ViewPager) getActivity().findViewById(R.id.kinds_vp_detail);
//    }
}