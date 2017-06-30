package com.example.administrator.dianshang.model.api;
import com.example.administrator.dianshang.model.bean.Class1Bean;
import com.example.administrator.dianshang.model.bean.Class2Bean;
import com.example.administrator.dianshang.model.bean.Class3Bean;
import com.example.administrator.dianshang.model.bean.XiangQingBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
/**
 * date:${DATA}
 * author:孟淑英
 * function:
 */
public interface RetrofitService{
    //注册
    @FormUrlEncoded//写field的时候 必须写@FormUrlEncoded
    @POST("mobile/index.php?act=login&op=register")
    Observable<String> getSearchBook(@Field("username") String name,
                                     @Field("password") String password,
                                     @Field("password_confirm")String password_confirm,
                                     @Field("email") String email,
                                     @Field("client") String client);

    //登录
    @FormUrlEncoded//写field的时候 必须写@FormUrlEncoded
    @POST("mobile/index.php?act=login")
    Observable<String> getdata(@Field("username") String name,@Field("password") String password,@Field("client") String client);
    //分类1
    @GET("mobile/index.php?act=goods_class")
    Observable<Class1Bean> getfenlei();
    //分类2
    @GET("mobile/index.php?act=goods_class")
    Observable<Class2Bean> getfenlei1(@Query("gc_id") String gc_id);
    //分类3
    @GET("mobile/index.php?act=goods_class")
    Observable<Class3Bean> getfenlei2(@Query("gc_id") String gc_id);
    //分类4
    @GET("mobile/index.php?act=goods&op=goods_list&page=100")
    Observable<XiangQingBean> getfenlei3();
    //分类4
    @GET("mobile/index.php?act=goods&op=goods_list&page=100")
    Observable<XiangQingBean> getfenlei4();
   }
