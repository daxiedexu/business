package com.zhang.common.utils.back;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @ClassName SharedManger
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/13 19:35
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class SharedManger {
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

   //初始化Sp、editor
    public SharedManger(Context context,String spName) {
        sharedPreferences = context.getSharedPreferences(spName,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    //sp存储数据
    public void putValue(String name,Object value){
        if (value instanceof String){
            editor.putString(name, (String) value);
        }else if (value instanceof Boolean){
            editor.putBoolean(name, (Boolean) value);
        }else if (value instanceof Integer){
            editor.putInt(name, (Integer) value);
        }else {
            throw new IllegalArgumentException("存储类型异常!");
        }
        editor.commit();
    }

    //根据key删除数据
    public void remove(String key){
        editor.remove(key);
        editor.commit();
    }

    //清除所有sp数据
    public void clearAll(){
        editor.clear();
        editor.commit();
    }

    //获得当前sq对象
    public static SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }
}
