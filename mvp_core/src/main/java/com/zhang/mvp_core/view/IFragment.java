package com.zhang.mvp_core.view;

import android.view.View;

import androidx.annotation.IdRes;

/**
 * @ClassName IActivity
 * @Author 孔晨亮
 * @Date 2021/9/3 10:01
 * User: msi
 */
public interface IFragment extends IActivity{
    <T extends View> T findViewById(@IdRes int id);
}
