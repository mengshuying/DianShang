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
import com.example.administrator.dianshang.presenter.DengLuPresenter;
import com.example.administrator.dianshang.view.activity.MainActivity;
import com.example.administrator.dianshang.view.activity.SecondActivity;
import com.example.administrator.dianshang.view.iview.DengLu;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import static com.example.administrator.dianshang.model.utils.Constant.code1;
/**
 * date:${DATA}
 * author:孟淑英
 * function:
 */
public class LoginFragment extends Fragment implements DengLu{
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
    @Bind(R.id.contentLinearLayout)
    LinearLayout mContentLinearLayout;
    @Bind(R.id.loginTextView)
    TextView mLoginTextView;
    @Bind(R.id.regTextView)
    TextView mRegTextView;
    @Bind(R.id.backTextView)
    TextView mBackTextView;
    @Bind(R.id.mainLinearLayout)
    LinearLayout mMainLinearLayout;
    private DengLuPresenter mDengLuPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.denglu, null);
        ButterKnife.bind(this, view);
        mDengLuPresenter = new DengLuPresenter(this);
        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);

    }
    @OnClick({R.id.leftImageView, R.id.titleTextView, R.id.rightImageView, R.id.usernameEditText, R.id.passwordEditText, R.id.contentLinearLayout, R.id.loginTextView, R.id.regTextView, R.id.backTextView, R.id.mainLinearLayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.leftImageView:
                getActivity().finish();
                break;
            case R.id.titleTextView:
                break;
            case R.id.rightImageView:
                break;
            case R.id.usernameEditText:
                break;
            case R.id.passwordEditText:
                break;
            case R.id.contentLinearLayout:
                break;
            case R.id.loginTextView:
                mDengLuPresenter.login();
                break;
            case R.id.regTextView:
                Intent intent=new Intent(getActivity(), SecondActivity.class);
                intent.putExtra(Constant.BiaoShi,code1);
               startActivity(intent);
                break;
            case R.id.backTextView:
                break;
            case R.id.mainLinearLayout:
                break;
        }
    }

    @Override
    public void moveToIndex() {
        Intent intent=new Intent(getActivity(), MainActivity.class);
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
    public String getClient() {
        return Constant.SYSTEM_TYPE;
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }
}
