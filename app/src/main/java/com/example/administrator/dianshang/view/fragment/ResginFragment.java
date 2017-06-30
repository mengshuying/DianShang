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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.dianshang.R;

import com.example.administrator.dianshang.model.utils.Constant;
import com.example.administrator.dianshang.presenter.ZhuChePresenter;
import com.example.administrator.dianshang.view.activity.SecondActivity;
import com.example.administrator.dianshang.view.iview.ZhuCe;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * date:${DATA}
 * author:孟淑英
 * function:
 */
public class ResginFragment extends Fragment implements ZhuCe {

    @Bind(R.id.leftImageView)
    ImageView mLeftImageView;
    @Bind(R.id.titleTextView)
    TextView mTitleTextView;
    @Bind(R.id.rightImageView)
    ImageView mRightImageView;
    @Bind(R.id.usernameEditText)
    EditText mUsernameEditText;
    @Bind(R.id.passwordEditText)
    EditText mPasswordEditText;
    @Bind(R.id.passwordRepeatEditText)
    EditText mPasswordRepeatEditText;
    @Bind(R.id.emailEditText)
    EditText mEmailEditText;
    @Bind(R.id.contentLinearLayout)
    LinearLayout mContentLinearLayout;
    @Bind(R.id.regTextView)
    TextView mRegTextView;
    @Bind(R.id.mainLinearLayout)
    LinearLayout mMainLinearLayout;
    private ZhuChePresenter mZhuChePresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.zhuce, null);
        ButterKnife.bind(this, view);
        mZhuChePresenter = new ZhuChePresenter(this);
        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);

    }

    @OnClick({R.id.leftImageView, R.id.titleTextView, R.id.rightImageView, R.id.usernameEditText, R.id.passwordEditText, R.id.passwordRepeatEditText, R.id.emailEditText, R.id.contentLinearLayout, R.id.regTextView, R.id.mainLinearLayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.leftImageView:

                break;
            case R.id.titleTextView:
                break;
            case R.id.rightImageView:
                break;
            case R.id.usernameEditText:
                break;
            case R.id.passwordEditText:
                break;
            case R.id.passwordRepeatEditText:
                break;
            case R.id.emailEditText:
                break;
            case R.id.contentLinearLayout:
                break;
            case R.id.regTextView:
                mZhuChePresenter.res();
            case R.id.mainLinearLayout:
                break;
        }
    }

    @Override
    public void moveToIndex() {
        Intent intent=new Intent(getActivity(), SecondActivity.class);
        intent.putExtra(Constant.BiaoShi,Constant.code);
        startActivity(intent);
    }

    @Override
    public String getName() {
        return mUsernameEditText.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return mPasswordEditText.getText().toString().trim();
    }

    @Override
    public String getPassword1() {
        return mPasswordRepeatEditText.getText().toString().trim();
    }

    @Override
    public String getEmail() {
        return mEmailEditText.getText().toString().trim();
    }

    @Override
    public String getClient() {
        return Constant.SYSTEM_TYPE;
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }
}
