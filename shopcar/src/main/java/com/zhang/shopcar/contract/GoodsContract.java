package com.zhang.shopcar.contract;

import com.zhang.mvp_core.model.IModel;
import com.zhang.mvp_core.view.IView;
import com.zhang.shopcar.net.entitiy.GoodsCarEntitiy;

import java.util.List;

/**
 * @ClassName GoodsContract
 * @Author 孔晨亮
 * @Date 2021/9/23 15:55
 * User: msi
 */
public interface GoodsContract extends IView {
    void goodsSuccess(List<GoodsCarEntitiy> goods);
    void goodsFailds(Throwable throwable);
}
