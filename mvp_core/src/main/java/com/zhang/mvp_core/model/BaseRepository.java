package com.zhang.mvp_core.model;



import com.zhang.common.utils.back.MVPModelException;

import java.lang.reflect.Field;

/**
 * @ClassName BaseRepository
 * @Author 孔晨亮
 * @Date 2021/9/8 19:19
 * User: msi
 */
public abstract class BaseRepository {

    public BaseRepository() {
        initModel();
    }

    private void initModel() {
        Class<? extends BaseRepository> aClass = BaseRepository.this.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        if (declaredFields.length == 0 || declaredFields == null) {
            throw new MVPModelException("no have any fields info...");
        }
        boolean hashModel = false;
        for (Field field : declaredFields) {
            Model annotation = field.getAnnotation(Model.class);
            if (annotation != null) {
                hashModel = true;
                field.setAccessible(true);
                String typeNama = field.getType().getName();

                try {
                    Class<?> fieldClass = Class.forName(typeNama);
                    Object fieldinstance = fieldinstance = fieldClass.newInstance();
                    field.set(this, fieldinstance);

                } catch (InstantiationException e) {
                    throw new MVPModelException(e.getMessage());
                } catch (IllegalAccessException e) {
                    throw new MVPModelException(e.getMessage());
                } catch (ClassNotFoundException e) {
                    throw new MVPModelException(e.getMessage());
                }
            }
        }
        if (!hashModel) {
            throw new MVPModelException("not set any Model...");
        }
    }
}
