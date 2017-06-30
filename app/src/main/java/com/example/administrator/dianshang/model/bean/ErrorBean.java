package com.example.administrator.dianshang.model.bean;

/**
 * date:${DATA}
 * author:孟淑英
 * function:
 */

public class ErrorBean{

    /**
     * code : 400
     * datas : {"error":"用户名长度要在6~20个字符"}
     */

    private int code;
    private DatasBean datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DatasBean getDatas() {
        return datas;
    }

    public void setDatas(DatasBean datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        /**
         * error : 用户名长度要在6~20个字符
         */

        private String error;

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        @Override
        public String toString() {
            return "DatasBean{" +
                    "error='" + error + '\'' +
                    '}';
        }
    }
}
