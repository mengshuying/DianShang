package com.example.administrator.dianshang.view.activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.example.administrator.dianshang.R;
import com.example.administrator.dianshang.view.fragment.FenLeiFragement;
import com.example.administrator.dianshang.view.fragment.GouWuCheFragment;
import com.example.administrator.dianshang.view.fragment.HomeFragment;
import com.example.administrator.dianshang.view.fragment.WoDeFragement;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private HomeFragment mHomeFragment;
    private GouWuCheFragment mGouWuCheFragment;
    private FenLeiFragement mFenLeiFragement;
    private WoDeFragement mWoDeFragement;
    private RadioButton r1;
    private RadioButton r2;
    private RadioButton r3;
    private RadioButton r4;
    private Fragment fragment;
    private FrameLayout fram;
    private RadioGroup r;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r1 = (RadioButton) findViewById(R.id.r1);
        r2 = (RadioButton) findViewById(R.id.r2);
        r3 = (RadioButton) findViewById(R.id.r3);
        r4 = (RadioButton) findViewById(R.id.r4);
        r = (RadioGroup) findViewById(R.id.r);
        fram = (FrameLayout) findViewById(R.id.fram);
        r1.setOnClickListener(this);
        r2.setOnClickListener(this);
        r3.setOnClickListener(this);
        r4.setOnClickListener(this);
        if(mHomeFragment==null){
            mHomeFragment=new HomeFragment();
        }
        add(mHomeFragment);
        r.check(R.id.r1);
    }
    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.r1:
                if(mHomeFragment==null){

                    mHomeFragment=new HomeFragment();
                }
                add(mHomeFragment);
                break;
            case R.id.r2:

                if(mFenLeiFragement==null){
                    mFenLeiFragement=new FenLeiFragement();
                }
                add(mFenLeiFragement);


                break;
            case R.id.r3:
                if(mGouWuCheFragment==null){
                    mGouWuCheFragment=new GouWuCheFragment();
                }
                add(mGouWuCheFragment);
                break;
            case R.id.r4:
                if(mWoDeFragement==null){
                    mWoDeFragement=new WoDeFragement();
                }
                add(mWoDeFragement);
                break;
        }
    }
    public void add(Fragment f){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(fragment!=null){
            transaction.hide(fragment);
        }
        if(!f.isAdded()){
            transaction.add(R.id.fram,f);
        }
        transaction.show(f);
        transaction.commit();
        fragment=f;
    }
}

