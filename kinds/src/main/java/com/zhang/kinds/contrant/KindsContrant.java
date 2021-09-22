package com.zhang.kinds.contrant;

import com.zhang.kinds.net.entitiy.Category;
import com.zhang.kinds.net.entitiy.Goods;
import com.zhang.kinds.net.entitiy.KindsEntitiy;
import com.zhang.mvp_core.view.IView;

import java.util.List;

/**
 * @ClassName KindsContrant
 * @Author 孔晨亮
 * @Date 2021/9/14 8:38
 * User: msi
 */
public interface KindsContrant extends IView {
    void kindsSuccess(Category category);
    void kindsFailds(Throwable throwable);

    void computerSuccess(Category category);
    void computerFailds(Throwable throwable);

    void phoneSuccess(Category category);
    void phoneFailds(Throwable throwable);
}
