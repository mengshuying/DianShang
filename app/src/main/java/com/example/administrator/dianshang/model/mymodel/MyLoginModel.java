package com.example.administrator.dianshang.model.mymodel;

import android.text.TextUtils;
import android.util.Log;

import com.example.administrator.dianshang.model.api.RetrofitService;
import com.example.administrator.dianshang.model.bean.ErrorBean;
import com.example.administrator.dianshang.model.onclick.MyDengLu;
import com.example.administrator.dianshang.model.onclick.OnLoginListener;
import com.example.administrator.dianshang.model.utils.ToastUtil;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static com.example.administrator.dianshang.model.mymodel.MyResModel.url;

/**
 * date:${DATA}
 * author:孟淑英
 * function:
 */

public class MyLoginModel implements MyDengLu{
    @Override
    public void zhu(final String name, final String password, String client, final OnLoginListener onLoginListener) {
        if(TextUtils.isEmpty(name)){
            onLoginListener.onUsernameError();
            return;
        }
        if(TextUtils.isEmpty(password)){
            onLoginListener.onPasswordError();
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
        retrofitService.getdata(name, password,client)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>(){
                    @Override
                    public void onComplete() {

                    }
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(String s){
                        if(s.contains("\"code\":200")){
                            onLoginListener.onSuccess();
                            Log.i("zzz","登录成功");
                        }
                        else{
                            Gson gson=new Gson();
                            ErrorBean errorBean = gson.fromJson(s, ErrorBean.class);
                            String error = errorBean.getDatas().getError();
                            onLoginListener.onFailure(error);

                            Log.i("zzz","登录失败"+error);
                        }
                    }
                    @Override
                    public void onError(Throwable e){
                        Log.i("zzz","啦啦失败"+e.getMessage());
                    }
                });
    }
}
