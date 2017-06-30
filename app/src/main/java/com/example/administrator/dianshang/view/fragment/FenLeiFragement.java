package com.example.administrator.dianshang.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.dianshang.R;
import com.example.administrator.dianshang.model.api.RetrofitService;
import com.example.administrator.dianshang.model.bean.Class1Bean;
import com.example.administrator.dianshang.model.bean.Class2Bean;
import com.example.administrator.dianshang.model.utils.Constant;
import com.example.administrator.dianshang.view.activity.SecondActivity;
import com.example.administrator.dianshang.view.adapter.MyRecycleViewClass1;
import com.example.administrator.dianshang.view.adapter.MyRecycleViewClass2;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * date:${DATA}
 * author:孟淑英
 * function:
 */
public class FenLeiFragement extends Fragment {
    @Bind(R.id.class1ListView)
    RecyclerView mClass1ListView;
    @Bind(R.id.class2ListView)
    RecyclerView mClass2ListView;
    public static final String url = Constant.LINK_MAIN;
    @Bind(R.id.leftImageView)
    ImageView mLeftImageView;
    @Bind(R.id.titleEditText)
    EditText mTitleEditText;
    @Bind(R.id.rightImageView)
    ImageView mRightImageView;
    private MyRecycleViewClass1 mMyRecycleViewClass1;
    private List<Class1Bean.DatasBean.ClassListBean> mClass_list;
    private List<Class2Bean.DatasBean.ClassListBean> mClass_list1;
    private MyRecycleViewClass2 mMMyRecycleViewClass2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fenleifragment, null);
        ButterKnife.bind(this, view);
        myhttp();
        return view;
    }

    private void myhttp() {
        //GsonConverterFactory.create()只要是针对Bean类
        Retrofit build = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                //Retrofit和Rxjava关联必须写这个
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        RetrofitService retrofitService = build.create(RetrofitService.class);
        retrofitService.getfenlei()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Class1Bean>() {
                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Class1Bean value) {
                        mClass_list = value.getDatas().getClass_list();
                        Log.i("zzz", value.toString());
                        mMyRecycleViewClass1 = new MyRecycleViewClass1(getActivity(), mClass_list);
                        mClass1ListView.setAdapter(mMyRecycleViewClass1);
                        mClass1ListView.setLayoutManager(new LinearLayoutManager(getActivity()));


                        JianTing();

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("zzz", "啦啦失败" + e.getMessage());
                    }
                });
    }

    private void myhttp1(String stt) {
        //GsonConverterFactory.create()只要是针对Bean类
        Retrofit build = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                //Retrofit和Rxjava关联必须写这个
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        RetrofitService retrofitService = build.create(RetrofitService.class);
        retrofitService.getfenlei1(stt)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Class2Bean>() {
                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Class2Bean value) {
                        mClass_list1 = value.getDatas().getClass_list();
                        Log.i("zzz", value.toString());
                        mMMyRecycleViewClass2 = new MyRecycleViewClass2(getActivity(), mClass_list1);
                        mClass2ListView.setAdapter(mMMyRecycleViewClass2);
                        mClass2ListView.setLayoutManager(new LinearLayoutManager(getActivity()));
                        JianTing1();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("zzz", "啦啦失败" + e.getMessage());
                    }
                });
    }

    public void JianTing() {
        mMyRecycleViewClass1.setOnItemClickListener(new MyRecycleViewClass1.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mMyRecycleViewClass1.notifyDataSetChanged();
                myhttp1(mClass_list.get(position).getGc_id());

            }
        });
    }

    public void JianTing1() {
        mMMyRecycleViewClass2.setOnItemClickListener(new MyRecycleViewClass2.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {


            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.leftImageView, R.id.titleEditText, R.id.rightImageView})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.leftImageView:
                Intent intent=new Intent(getActivity(), SecondActivity.class);
                intent.putExtra(Constant.BiaoShi,Constant.code2);
                startActivity(intent);
                break;
            case R.id.titleEditText:

                break;
            case R.id.rightImageView:
                break;
        }
    }
}
