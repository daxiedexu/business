package com.zhang.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabLayout;
import com.zhang.common.utils.Config;
import com.zhang.common.utils.MyVPAdapter;
import com.zhang.common.utils.back.SharedManger;
import com.zhang.home.goods.entity.Goods;
import com.zhang.mvp_core.view.BaseActivity;
import com.zhang.net.ShopCar;
import com.zhang.net.Sqlutils;
import com.zhang.net.db.DaoSession;
import com.zhang.net.db.ShopCarDao;
import com.zhang.person.Person_Config;

import java.util.ArrayList;


/**
 * @ClassName CarActivity
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/22 11:03
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
@Route(path=Config.MODULE_CAR)
public class CarActivity extends BaseActivity {
    private ImageView carBack;
    private TabLayout carTab;
    private ViewPager carVp;
    private TextView carCar;
    private TextView carTv;

    @Autowired(name="car")
    Goods goods;
    @Override
    protected void initData() {
        ARouter.getInstance().inject(this);
        ArrayList<String> strings=new ArrayList<>( );
        strings.add("商品");
        strings.add("详情");

        ArrayList<Fragment> fragments=new ArrayList<>( );

        CarGood_Fragment carGood_fragment=new CarGood_Fragment( );
        Particulars_Fragment particulars_fragment=new Particulars_Fragment( );

        fragments.add(carGood_fragment);
        fragments.add(particulars_fragment);

        MyVPAdapter myVPAdapter=new MyVPAdapter(getSupportFragmentManager( ), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, strings, fragments);
        carVp.setAdapter(myVPAdapter);
        carTab.setupWithViewPager(carVp);

        Bundle bundle=new Bundle( );
        bundle.putParcelable("cargood",goods);
        carGood_fragment.setArguments(bundle);
        particulars_fragment.setArguments(bundle);


        SharedManger user=new SharedManger(this, "user");
        boolean isLogin=user.getSharedPreferences( ).getBoolean("isLogin", false);

        carCar.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(CarActivity.this);
                View inflate=getLayoutInflater( ).inflate(R.layout.buy_item, null);
                TextView b11=inflate.findViewById(R.id.buy_1);
                TextView b22=inflate.findViewById(R.id.buy_2);
                TextView b33=inflate.findViewById(R.id.buy_3);
                b11.setText(goods.getGoodsDefaultSku());
                b22.setText(goods.getGoodsDefaultSku());
                b33.setText(goods.getGoodsDefaultSku());
                inflate.findViewById(R.id.goodsCar).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DaoSession daoUtils = Sqlutils.getInstance().getDaoUtils(CarActivity.this);
                        ShopCarDao shopCarDao = daoUtils.getShopCarDao();

                        ShopCar shopCar = new ShopCar();
                        shopCar.setGoodsname(goods.getGoodsDesc());
                        shopCar.setGoodsmsg(goods.getGoodsDefaultSku());
                        shopCar.setPrice(goods.getGoodsDefaultPrice());
                        shopCar.setPic(goods.getGoodsDefaultIcon());
                        shopCar.setNum(1);
                        shopCarDao.insert(shopCar);
                        Toast.makeText(CarActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                    }
                });

//                bottomSheetDialog.setContentView(inflate);
//                bottomSheetDialog.show();

                if(isLogin){
                    BottomSheetDialog bottomSheetDialog1=new BottomSheetDialog(CarActivity.this);
                    View inflate1 = getLayoutInflater().inflate(R.layout.buy_item, null);
                    TextView b1=inflate1.findViewById(R.id.buy_1);
                    TextView b2=inflate1.findViewById(R.id.buy_2);
                    TextView b3=inflate1.findViewById(R.id.buy_3);
                    b1.setText(goods.getGoodsDefaultSku());
                    b2.setText(goods.getGoodsDefaultSku());
                    b3.setText(goods.getGoodsDefaultSku());
                    bottomSheetDialog1.setContentView(inflate);
                    bottomSheetDialog1.show();
                }else {
                    ARouter.getInstance().build(Person_Config.LOGIN).greenChannel().navigation();
                }
            }
        });
    }

    @Override
    protected void initView() {
        carBack = (ImageView) findViewById(R.id.car_back);
        carTab = (TabLayout) findViewById(R.id.car_tab);
        carVp = (ViewPager) findViewById(R.id.car_vp);
        carCar = (TextView) findViewById(R.id.car_car);
        carTv = (TextView) findViewById(R.id.car_tv);

        carTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(Config.MODULE_GOODS).greenChannel().navigation();

                Toast.makeText(CarActivity.this, "55", Toast.LENGTH_SHORT).show( );
            }
        });
    }

    @Override
    protected int bindLayout() {
        return R.layout.car;
    }
}
