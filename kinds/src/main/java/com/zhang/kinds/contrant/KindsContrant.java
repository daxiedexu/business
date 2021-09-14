package com.zhang.kinds.contrant;

import com.zhang.kinds.net.entitiy.KindsEntitiy;
import com.zhang.mvp_core.model.IModel;
import com.zhang.mvp_core.view.IView;

import io.reactivex.Observable;

/**
 * @ClassName KindsContrant
 * @Author 孔晨亮
 * @Date 2021/9/14 8:38
 * User: msi
 */
public interface KindsContrant {
    interface kindsModel extends IModel{
        Observable<KindsEntitiy> getModel();
    }
    interface kindsView extends IView {
        void kindsSuccess(KindsEntitiy kindsEntitiy);
        void kindsFailds(Throwable throwable);
    }
}
