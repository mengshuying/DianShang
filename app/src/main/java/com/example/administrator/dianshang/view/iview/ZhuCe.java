package com.example.administrator.dianshang.view.iview;
/**
 * date:${DATA}
 * author:孟淑英
 * function:
 */
public interface ZhuCe{
    //登录成功后跳转到首页
    void moveToIndex();
    //获取界面的姓名
    String getName();
    //获取界面的密码
    String getPassword();
    //再次获取界面的密码
    String getPassword1();
    //获取邮箱
    String getEmail();
    //获取客户端
    String getClient();
    //Toast
    void showToast(String msg);
}
