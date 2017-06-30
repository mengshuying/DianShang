package com.example.administrator.dianshang.presenter;
import com.example.administrator.dianshang.model.mymodel.MyLoginModel;
import com.example.administrator.dianshang.model.onclick.OnLoginListener;
import com.example.administrator.dianshang.view.iview.DengLu;
/**
 * date:${DATA}
 * author:孟淑英
 * function:
 */
public class DengLuPresenter implements OnLoginListener{
    private final DengLu mDengLu;
    private final MyLoginModel mMyLoginModel;

    public DengLuPresenter(DengLu dengLu){
       mDengLu =dengLu;
        mMyLoginModel = new MyLoginModel();
    }
    public void login(){
        String name = mDengLu.getName();
        String password = mDengLu.getPassword();
        String client = mDengLu.getClient();
        mMyLoginModel.zhu(name,password,client,this);
    }
    @Override
    public void onUsernameError() {
        mDengLu.showToast("用户名不能为空");
    }

    @Override
    public void onPasswordError() {
        mDengLu.showToast("密码不能为空");
    }

    @Override
    public void onSuccess() {
        mDengLu.showToast("登录成功");
        mDengLu.moveToIndex();
    }

    @Override
    public void onFailure(String stt) {
        mDengLu.showToast(stt);
    }

}
