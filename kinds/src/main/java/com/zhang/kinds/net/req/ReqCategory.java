package com.zhang.kinds.net.req;

/**
 * @ClassName ReqCategory
 * @Author 孔晨亮
 * @Date 2021/9/21 18:40
 * User: msi
 */
public class ReqCategory {
    private int parentId;

    public ReqCategory(int parentId) {
        this.parentId = parentId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
