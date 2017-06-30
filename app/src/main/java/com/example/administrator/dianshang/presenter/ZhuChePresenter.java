package com.example.administrator.dianshang.presenter;
import android.util.Log;
import com.example.administrator.dianshang.model.mymodel.MyResModel;
import com.example.administrator.dianshang.model.onclick.OnResListener;
import com.example.administrator.dianshang.view.iview.ZhuCe;
/**
 * date:${DATA}
 * author:孟淑英
 * function:
 */
public class ZhuChePresenter implements OnResListener{
    private final ZhuCe mZhuCe;
    private final MyResModel mMyResModel;

    public ZhuChePresenter(ZhuCe zhuCe){
         mZhuCe =zhuCe;
        mMyResModel = new MyResModel();
     }
    public void res(){
        String name = mZhuCe.getName();
        Log.i("zzz",name);
        String password = mZhuCe.getPassword();
        Log.i("zzz",password);
        String password1 = mZhuCe.getPassword1();
        Log.i("zzz",password1);
        String email = mZhuCe.getEmail();
        Log.i("zzz",email);
        String client = mZhuCe.getClient();
        Log.i("zzz",client);
        mMyResModel.zhu(name,password,password1,email,client,this);
    }
    @Override
    public void onUsernameError() {
        mZhuCe.showToast("用户名不能为空");
    }

    @Override
    public void onPasswordError() {
        mZhuCe.showToast("密码不能为空");
    }

    @Override
    public void onPasswordError1() {
        mZhuCe.showToast("请再次输入密码");
    }

    @Override
    public void onEmail() {
        mZhuCe.showToast("请输入邮箱地址");
    }

    @Override
    public void onPasswordError2() {
        mZhuCe.showToast("密码不一样");
    }

    @Override
    public void onSuccess() {
        mZhuCe.showToast("注册成功");
        mZhuCe.moveToIndex();
    }

    @Override
    public void onEmail1() {
        mZhuCe.showToast("邮箱格式不正确");
    }

    @Override
    public void onFailure(String stt) {
        mZhuCe.showToast(stt);
    }
}
