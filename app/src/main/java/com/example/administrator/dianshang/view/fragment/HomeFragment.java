package com.example.administrator.dianshang.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.dianshang.R;
import com.example.administrator.dianshang.model.utils.Constant;
import com.example.administrator.dianshang.view.activity.SecondActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * date:${DATA}
 * author:孟淑英
 * function:
 */
public class HomeFragment extends Fragment {
    @Bind(R.id.leftImageView)
    ImageView mLeftImageView;
    @Bind(R.id.titleEditText)
    EditText mTitleEditText;
    @Bind(R.id.rightImageView)
    ImageView mRightImageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.homefragment, null);

        ButterKnife.bind(this, view);
        return view;
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
