package com.zhang.kinds.net.req;

/**
 * @ClassName ReqGoodsList
 * @Author 孔晨亮
 * @Date 2021/9/21 19:05
 * User: msi
 */
public class ReqGoodsList {
    private int categoryId;
    private int pageNo;

    public ReqGoodsList(int categoryId, int pageNo) {
        this.categoryId = categoryId;
        this.pageNo = pageNo;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
}
