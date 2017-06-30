package com.example.administrator.dianshang.view.activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import com.example.administrator.dianshang.R;
import com.example.administrator.dianshang.model.utils.Constant;
import com.example.administrator.dianshang.view.fragment.LoginFragment;
import com.example.administrator.dianshang.view.fragment.ResginFragment;
import com.example.administrator.dianshang.view.fragment.ScanFragment;
import com.example.administrator.dianshang.view.fragment.XiangQingFragment;
import com.example.administrator.dianshang.view.fragment.XiangQingFragment1;
import butterknife.Bind;
import butterknife.ButterKnife;
public class SecondActivity extends AppCompatActivity{
    @Bind(R.id.fram)
    FrameLayout mFram;
    private int mIntExtra;
    private FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        //得到传过来的int值
        Intent intent = getIntent();
        mIntExtra = intent.getIntExtra(Constant.BiaoShi, 2);
        //开启事物
        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        panduan();
     }
    public void panduan(){
       if(mIntExtra==Constant.code){
           Manager(new LoginFragment());
       }else if(mIntExtra==Constant.code1){
           Manager(new ResginFragment());
       }else if(mIntExtra==Constant.code2){
           Manager(new ScanFragment());
       }else if(mIntExtra==Constant.code3){
           Manager(new XiangQingFragment());
       }else if(mIntExtra==Constant.code4){
           Manager(new XiangQingFragment1());
       }
    }

    private void Manager(Fragment fragment) {
        mFragmentTransaction.add(R.id.fram,fragment);
        mFragmentTransaction.show(fragment);
        mFragmentTransaction.commit();
    }


}
