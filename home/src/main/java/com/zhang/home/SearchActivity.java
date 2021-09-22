package com.zhang.home;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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
import com.zhang.common.utils.back.SharedManger;
import com.zhang.mvp_core.view.BaseActivity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SearchActivity
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/17 19:07
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
@Route(path=Config.MODULE_SEARCH)
public class SearchActivity extends BaseActivity implements OnItemClickListener {
    private EditText searchEt;
    private TextView searchTv;
    private RecyclerView searchRv;
    ArrayList<String> strings;
    private TextView searchTvHide;
    private Button searchRemove;
    boolean isAdd;
    private ImageView searchBack;
    private TextView searchSearchHide;
    Search_Adapter search_adapter;

    @Override
    protected void initData() {

        searchSearchHide.setVisibility(View.GONE);
        isAdd=false;
        searchTvHide = (TextView) findViewById(R.id.search_tv_hide);
        searchRv.setLayoutManager(new LinearLayoutManager(this));
        search_adapter=new Search_Adapter(strings);
        searchRv.setAdapter(search_adapter);
        search_adapter.setOnItemClickListener(this::onItemClick);

        searchTv.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                if(strings.size()==0){
                    isAdd=true;
                }else {
                    for (String string : strings) {
                        if(string.equals(searchEt.getText().toString())){
                            isAdd=false;
                        }else {
                            isAdd=true;
                        }
                    }
                }

                if(isAdd){
                    strings.add(searchEt.getText().toString());
                    searchTvHide.setVisibility(View.GONE);
                    //searchSearchHide.setVisibility(View.GONE);
                }
                ARouter.getInstance().build(Config.MODULE_DETAIL).withString(Config.DETAIL_KEY,searchEt.getText().toString()).greenChannel().navigation();
                search_adapter.notifyDataSetChanged();
            }
        });

        searchRemove.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                strings.clear();
                search_adapter.notifyDataSetChanged();
                searchTvHide.setVisibility(View.VISIBLE);
            }
        });
        searchBack.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        searchEt.addTextChangedListener(new TextWatcher( ) {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //searchTvHide.setVisibility(View.GONE);

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(searchEt.getText().toString().isEmpty()){
                    searchTvHide.setVisibility(View.VISIBLE);
                }
            }
        });


    }

    @Override
    protected void initView() {
        searchEt = (EditText) findViewById(R.id.search_et);
        searchTv = (TextView) findViewById(R.id.search_tv);
        searchRv = (RecyclerView) findViewById(R.id.search_rv);
        searchRemove = (Button) findViewById(R.id.search_remove);
        searchBack = (ImageView) findViewById(R.id.search_back);
        searchSearchHide = (TextView) findViewById(R.id.search_search_hide);
        strings=new ArrayList<>( );
    }

    @Override
    protected int bindLayout() {
        return R.layout.search;
    }

    @Override
    public void onItemClick(@NonNull @NotNull BaseQuickAdapter<?, ?> adapter, @NonNull @NotNull View view, int position) {
        ARouter.getInstance().build(Config.MODULE_DETAIL).withString(Config.DETAIL_KEY,searchEt.getText().toString()).greenChannel().navigation();
    }


    public class Search_Adapter extends BaseQuickAdapter<String, BaseViewHolder>{
        public Search_Adapter( @Nullable List<String> data) {
            super(R.layout.search_item, data);
        }

        @Override
        protected void convert(@NotNull BaseViewHolder baseViewHolder, String s) {
            baseViewHolder.setText(R.id.search_item_tv,s);
        }
    }

}
