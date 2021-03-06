package com.zhang.net.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.zhang.net.AdressCar;
import com.zhang.net.ShopCar;

import com.zhang.net.db.AdressCarDao;
import com.zhang.net.db.ShopCarDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig adressCarDaoConfig;
    private final DaoConfig shopCarDaoConfig;

    private final AdressCarDao adressCarDao;
    private final ShopCarDao shopCarDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        adressCarDaoConfig = daoConfigMap.get(AdressCarDao.class).clone();
        adressCarDaoConfig.initIdentityScope(type);

        shopCarDaoConfig = daoConfigMap.get(ShopCarDao.class).clone();
        shopCarDaoConfig.initIdentityScope(type);

        adressCarDao = new AdressCarDao(adressCarDaoConfig, this);
        shopCarDao = new ShopCarDao(shopCarDaoConfig, this);

        registerDao(AdressCar.class, adressCarDao);
        registerDao(ShopCar.class, shopCarDao);
    }
    
    public void clear() {
        adressCarDaoConfig.clearIdentityScope();
        shopCarDaoConfig.clearIdentityScope();
    }

    public AdressCarDao getAdressCarDao() {
        return adressCarDao;
    }

    public ShopCarDao getShopCarDao() {
        return shopCarDao;
    }

}
