package com.example.administrator.dianshang.model.mymodel;
import android.text.TextUtils;
import android.util.Log;
import com.example.administrator.dianshang.model.api.RetrofitService;
import com.example.administrator.dianshang.model.bean.ErrorBean;
import com.example.administrator.dianshang.model.onclick.MyZhuZhe;
import com.example.administrator.dianshang.model.onclick.OnResListener;
import com.example.administrator.dianshang.model.utils.Constant;
import com.example.administrator.dianshang.model.utils.TextUtil;
import com.example.administrator.dianshang.model.utils.ToastUtil;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * date:${DATA}
 * author:孟淑英
 * function:
 */

public class MyResModel implements MyZhuZhe{
    public static final String url= Constant.LINK_MAIN;
    @Override
    public void zhu(final String name, final String password, final String password1, final String email, String client, final OnResListener onResListener) {
       if(TextUtils.isEmpty(name)){
           onResListener.onUsernameError();
           return;
       }
        if(TextUtils.isEmpty(password)){
            onResListener.onPasswordError();
            return;
        }
        if (TextUtils.isEmpty(password1)) {
            onResListener.onPasswordError1();
            return;
        }

        if (TextUtils.isEmpty(email)) {
            onResListener.onEmail();
            return;
        }

        if (!password.equals(password1)) {
            onResListener.onPasswordError2();
            return;
        }


        if (!TextUtil.isEmailAddress(email)) {
            onResListener.onEmail1();
            return;
        }
        //GsonConverterFactory.create()只要是针对Bean类
        Retrofit build = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(ScalarsConverterFactory.create())
                //Retrofit和Rxjava关联必须写这个
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        RetrofitService retrofitService = build.create(RetrofitService.class);
        retrofitService.getSearchBook(name, password, password1, email, client)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onComplete() {

                    }
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(String s){
                        Log.i("zzz","啦啦"+s);
                        if(s.contains("\"code\":200")){
                            Log.i("zzz","注册成功");
                            onResListener.onSuccess();
                        }
                        else{
                            Gson gson=new Gson();
                            ErrorBean errorBean = gson.fromJson(s, ErrorBean.class);
                            String error = errorBean.getDatas().getError();
                            Log.i("zzz","注册失败"+error);
                            onResListener.onFailure(error);
                        }
                    }
                    @Override
                    public void onError(Throwable e){
                        Log.i("zzz","啦啦失败"+e.getMessage());
                    }
                });
    }
}
