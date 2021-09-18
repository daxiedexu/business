package com.zhang.home;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zhang.common.utils.Config;
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
public class SearchActivity extends BaseActivity {
    private EditText searchEt;
    private TextView searchTv;
    private RecyclerView searchRv;
    ArrayList<String> strings;
    private TextView searchTvHide;
    private Button searchRemove;
    boolean isAdd;

    @Override
    protected void initData() {

        Toast.makeText(this, ""+strings.size(), Toast.LENGTH_SHORT).show( );
        isAdd=true;
        searchTvHide = (TextView) findViewById(R.id.search_tv_hide);
        searchRv.setLayoutManager(new LinearLayoutManager(this));
        Search_Adapter search_adapter=new Search_Adapter(strings);
        searchRv.setAdapter(search_adapter);

        searchTv.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                for (String string : strings) {
                    if(string.equals(searchEt.getText().toString())){
                        isAdd=false;
                        return;
                    }else {
                        isAdd=true;
                    }
                }
                if(isAdd){
                    searchTvHide.setVisibility(View.GONE);
                    strings.add(searchEt.getText().toString());
                    search_adapter.notifyDataSetChanged();
                }

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
    }

    @Override
    protected void initView() {
        searchEt = (EditText) findViewById(R.id.search_et);
        searchTv = (TextView) findViewById(R.id.search_tv);
        searchRv = (RecyclerView) findViewById(R.id.search_rv);
        searchRemove = (Button) findViewById(R.id.search_remove);
        strings=new ArrayList<>( );
    }

    @Override
    protected int bindLayout() {
        return R.layout.search;
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
