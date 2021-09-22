package com.zhang.kinds.view;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.zhang.kinds.R;
import com.zhang.kinds.adapter.ComputerAdapter;
import com.zhang.kinds.adapter.KindsAdapters;
import com.zhang.kinds.contrant.KindsContrant;
import com.zhang.kinds.net.di.component.DaggerKindsComponent;
import com.zhang.kinds.net.di.module.KindsViewModule;
import com.zhang.kinds.net.entitiy.Category;
import com.zhang.kinds.presenter.KindsPresenterImpl;
import com.zhang.mvp_core.view.BaseMVPFragment;

import java.util.List;

import javax.inject.Inject;

public class KindsFragment extends BaseMVPFragment implements KindsContrant {
    @Inject
    KindsPresenterImpl kindsPresenter;

    private RecyclerView kindsRvGroup;
    private RecyclerView kindsRvGoods;
    List<Category.DataBean> data;
    List<Category.DataBean> computerData;
    List<Category.DataBean> phoneData;
    private TextView goodsTv;

    @Override
    protected void injectComponent() {
        DaggerKindsComponent.builder().fragmentComponent(fragmentComponent)
                .kindsViewModule(new KindsViewModule(this))
                .build().injectKinds(this);

    }

    @Override
    protected void initData() {
        kindsPresenter.showKinds();
        kindsPresenter.showComputer();
        kindsPresenter.showPhone();
    }

    @Override
    public void computerSuccess(Category category) {
        computerData = category.getData();

    }

    @Override
    public void phoneSuccess(Category category) {
        phoneData = category.getData();
    }

    @Override
    public void kindsSuccess(Category category) {
        data = category.getData();

        KindsAdapters kindsAdapters = new KindsAdapters(data);
        kindsRvGroup.setAdapter(kindsAdapters);
        kindsRvGroup.addItemDecoration(new DividerItemDecoration(getActivity(), 1));
        kindsRvGroup.setLayoutManager(new LinearLayoutManager(getActivity()));
        kindsAdapters.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter<?, ?> adapter, View view, int position) {
                for (int i = 0; i < data.size(); i++) {
                    data.get(i).setCheck(false);
                }
                data.get(position).setCheck(true);
                kindsAdapters.notifyDataSetChanged();
                if (position == 0) {
                    kindsRvGoods.setVisibility(View.VISIBLE);
                    goodsTv.setVisibility(View.GONE);
                    ComputerAdapter computerAdapter = new ComputerAdapter(R.layout.item_rv_goods, computerData);
                    kindsRvGoods.setAdapter(computerAdapter);
                    kindsRvGoods.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
                } else if (position == 1) {
                    kindsRvGoods.setVisibility(View.VISIBLE);
                    goodsTv.setVisibility(View.GONE);
                    ComputerAdapter computerAdapter = new ComputerAdapter(R.layout.item_rv_goods, phoneData);
                    kindsRvGoods.setAdapter(computerAdapter);
                    kindsRvGoods.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
                } else {
                    kindsRvGoods.setVisibility(View.GONE);
                    goodsTv.setVisibility(View.VISIBLE);
                }

            }
        });
        kindsRvGroup.setAdapter(kindsAdapters);
    }


    @Override
    public void kindsFailds(Throwable throwable) {

    }


    @Override
    public void computerFailds(Throwable throwable) {

    }


    @Override
    public void phoneFailds(Throwable throwable) {

    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_kinds;
    }


    @Override
    protected void initView() {
        kindsRvGroup = (RecyclerView) getActivity().findViewById(R.id.kinds_rv_group);
        kindsRvGoods = (RecyclerView) getActivity().findViewById(R.id.kinds_rv_goods);
        goodsTv = (TextView) getActivity().findViewById(R.id.goods_tv);
    }

}