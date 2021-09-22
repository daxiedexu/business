package com.zhang.kinds.net.entitiy;

import java.util.List;

/**
 * @ClassName KindsEntitiy
 * @Author 孔晨亮
 * @Date 2021/9/14 8:25
 * User: msi
 */
public class KindsEntitiy {
    /**
     * code : 200
     * data : [{"id":5470,"category_id":16,"parent_id":0,"category_name":"女装/女士精品"},{"id":5471,"category_id":30,"parent_id":0,"category_name":"男装"},{"id":5490,"category_id":50011740,"parent_id":0,"category_name":"流行男鞋"},{"id":5513,"category_id":50012100,"parent_id":0,"category_name":"生活电器"},{"id":5514,"category_id":50010388,"parent_id":0,"category_name":"运动鞋"},{"id":5521,"category_id":1512,"parent_id":0,"category_name":"手机"},{"id":5525,"category_id":1101,"parent_id":0,"category_name":"笔记本电脑"}]
     * msg : 操作成功
     */

    private int code;
    private String msg;
    /**
     * id : 5470
     * category_id : 16
     * parent_id : 0
     * category_name : 女装/女士精品
     */

    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int id;
        private int category_id;
        private int parent_id;
        private String category_name;
        private boolean isCheck;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCategory_id() {
            return category_id;
        }

        public void setCategory_id(int category_id) {
            this.category_id = category_id;
        }

        public int getParent_id() {
            return parent_id;
        }

        public void setParent_id(int parent_id) {
            this.parent_id = parent_id;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public boolean isCheck() {
            return isCheck;
        }

        public void setCheck(boolean check) {
            isCheck = check;
        }
    }
}
