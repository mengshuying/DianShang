package com.example.administrator.dianshang.view.adapter;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.administrator.dianshang.R;
import com.example.administrator.dianshang.model.api.RetrofitService;
import com.example.administrator.dianshang.model.bean.Class2Bean;
import com.example.administrator.dianshang.model.bean.Class3Bean;
import com.example.administrator.dianshang.model.bean.XiangQingBean;
import com.example.administrator.dianshang.model.utils.Constant;
import com.example.administrator.dianshang.view.activity.SecondActivity;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.administrator.dianshang.model.utils.Constant.code1;
import static com.example.administrator.dianshang.model.utils.Constant.code3;

/**
 * date:${DATA}
 * author:孟淑英
 * function:
 */
public class MyRecycleViewClass2 extends RecyclerView.Adapter<MyRecycleViewClass2.ViewHolder>{
    private final Context mContext;
    private final List<Class2Bean.DatasBean.ClassListBean> mClass1Been;
    private List<Class3Bean.DatasBean.ClassListBean> mClass_list;
    //定义一个接口的属性
    private OnItemClickListener onItemClickListener;
    //判断是展开的还是合上的
    private boolean flag=false;
    //定义一个接口
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }
    //将定义的接口和定义的接口属性关联起来
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
    public MyRecycleViewClass2(Context context,List<Class2Bean.DatasBean.ClassListBean> list){
         mContext =context;
         mClass1Been =list;
     }


    @Override
    public MyRecycleViewClass2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view=View.inflate(mContext, R.layout.item_list_class2,null);

        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final MyRecycleViewClass2.ViewHolder holder, final int position){
        holder.mTitleTextView.setText(mClass1Been.get(position).getGc_name());
        for(int i=0;i<holder.contentTextView.length;i++){
            holder.contentTextView[i].setText("");
            if(holder.contentTextView[i].getText().toString().length()==0){
                holder.contentTextView[i].setVisibility(View.GONE);
            }
        }
        if(onItemClickListener!=null){
           holder.mainRelativeLayout.setOnClickListener(new View.OnClickListener(){
               @Override
               public void onClick(View v){

                   onItemClickListener.onItemClick(holder.itemView,position);

                   myhttp2(mClass1Been.get(position).getGc_id(),holder.contentTextView);
                     //必须这么写
                   flag=!flag;
                   myhttp3();
               }
           });
       }
    }
    @Override
    public int getItemCount(){
        return mClass1Been.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private final RelativeLayout mainRelativeLayout;
        private final TextView mTitleTextView;
        //设置contentTextView的长度为51
        public TextView[] contentTextView=new TextView[51];
        public ViewHolder(View itemView){
            super(itemView);
            mainRelativeLayout = (RelativeLayout) itemView.findViewById(R.id.mainRelativeLayout);
            mTitleTextView = (TextView) itemView.findViewById(R.id.titleTextView);
            for(int i=0;i<contentTextView.length;i++){
               //将找到的控件放到这个数组里  注意必须放进去 否则找控件这个数组里是空的 肯定会报空指针异常
                contentTextView[i]= (TextView) itemView.findViewById(R.id.content1TextView+i);
            }
        }
    }
 //网络请求  只能在网络请求里设置数据  我刚开始将这个方法写在监听里 然后在监听里设置数据一直报空指针异常。
    //将这个TextView的数组传过来设置数据
    private void myhttp2(String stt, final TextView[] textViews){
        //GsonConverterFactory.create()只要是针对Bean类
        Retrofit build = new Retrofit.Builder()
                .baseUrl(Constant.LINK_MAIN )
                .addConverterFactory(GsonConverterFactory.create())
                //Retrofit和Rxjava关联必须写这个
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        RetrofitService retrofitService = build.create(RetrofitService.class);
        retrofitService.getfenlei2(stt)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Class3Bean>() {
                    @Override
                    public void onComplete() {
                    }
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(Class3Bean value) {
                        mClass_list = value.getDatas().getClass_list();
                        for(int i=0;i<mClass_list.size();i++){
                            textViews[i].setText(mClass_list.get(i).getGc_name());
                        }
                        for(int i=0;i<textViews.length;i++){
                        if(textViews[i].getText().toString().length()==0){
                            textViews[i].setVisibility(View.GONE);
                         }else{
                            if(flag){
                                textViews[i].setVisibility(View.VISIBLE);
                            }else{
                                textViews[i].setVisibility(View.GONE);
                             }
                           }
                        }
                    }
                    @Override
                    public void onError(Throwable e){
                        Log.i("zzz","啦啦失败"+e.getMessage());
                    }
                });
    }
    private void myhttp3(){
        //GsonConverterFactory.create()只要是针对Bean类
        Retrofit build = new Retrofit.Builder()
                .baseUrl(Constant.LINK_MAIN )
                .addConverterFactory(GsonConverterFactory.create())
                //Retrofit和Rxjava关联必须写这个
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        RetrofitService retrofitService = build.create(RetrofitService.class);
        retrofitService.getfenlei3()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<XiangQingBean>() {
                    @Override
                    public void onComplete() {
                    }
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(XiangQingBean value){
                        List<XiangQingBean.DatasBean.GoodsListBean>   mGoods_list = value.getDatas().getGoods_list();
                        Intent intent=new Intent(mContext, SecondActivity.class);
                        intent.putExtra(Constant.BiaoShi,code3);
                       mContext.startActivity(intent);
                        //传数据
                        EventBus.getDefault().postSticky(mGoods_list);

                    }
                    @Override
                    public void onError(Throwable e){
                        Log.i("zzz","啦啦失败"+e.getMessage());
                    }
                });
    }
}
