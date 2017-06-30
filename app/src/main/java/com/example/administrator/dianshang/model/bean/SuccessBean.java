package com.example.administrator.dianshang.model.bean;

/**
 * date:${DATA}
 * author:孟淑英
 * function:
 */

public class SuccessBean{

    /**
     * code : 200
     * datas : {"username":"mengshuyi","userid":"3","key":"73ed6d1a181d0f43066d874a71a1324d"}
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
         * username : mengshuyi
         * userid : 3
         * key : 73ed6d1a181d0f43066d874a71a1324d
         */

        private String username;
        private String userid;
        private String key;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "DatasBean{" +
                    "username='" + username + '\'' +
                    ", userid='" + userid + '\'' +
                    ", key='" + key + '\'' +
                    '}';
        }
    }
}
