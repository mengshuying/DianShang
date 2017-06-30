package com.example.administrator.dianshang.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.dianshang.R;
import com.example.administrator.dianshang.model.utils.Constant;
import com.example.administrator.dianshang.view.activity.SecondActivity;

/**
 * date:${DATA}
 * author:孟淑英
 * function:
 */

public class WoDeFragement extends Fragment implements View.OnClickListener {
    private ImageView mHeadImageView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.wodefragment,null);
        initView(view);

        return view;
    }
    private void initView(View view) {
        mHeadImageView = (ImageView) view.findViewById(R.id.headImageView);
        mHeadImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent1 = getIntent(Constant.BiaoShi,Constant.code);
        startActivity(intent1);
    }
    public Intent getIntent(String stt,int code){
        Intent intent = tiaozhuan();
        intent.putExtra(stt,code);
        return intent;

    }
    public Intent tiaozhuan(){
        Intent intent=new Intent(getActivity(),SecondActivity.class);
        return intent;
    }
}
