package com.zhang.kinds.contrant;

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
    void kindsSuccess(KindsEntitiy kindsEntitiy);
    void kindsFailds(Throwable throwable);

}
