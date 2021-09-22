package com.zhang.mvp;

import com.zhang.mvp_core.view.IView;

/**
 * @ClassName View
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/21 19:31
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public interface View extends IView {
    void kindsSuccess(String msg);
    void kindsFailed(Throwable throwable);
}
