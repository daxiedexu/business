package com.zhang.net;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.zhang.net.db.DaoMaster;
import com.zhang.net.db.DaoSession;


public class Sqlutils {
    public static Sqlutils sqlutils;

    public static Sqlutils getInstance() {
        if (sqlutils==null){
            synchronized (Sqlutils.class){
                if (sqlutils==null){
                    sqlutils=new Sqlutils();
                }
            }
        }
        return sqlutils;
    }
    public DaoSession getDaoUtils(Context context){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "shopping");
        SQLiteDatabase writableDatabase = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(writableDatabase);

        DaoSession daoSession = daoMaster.newSession();
        return daoSession;
    }
    public DaoSession getDaoUser(Context context){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "user");
        SQLiteDatabase writableDatabase = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(writableDatabase);

        DaoSession daoSession = daoMaster.newSession();
        return daoSession;
    }



}
