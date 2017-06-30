package com.example.administrator.dianshang.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.administrator.dianshang.R;
import com.example.administrator.dianshang.view.adapter.MyPagerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * date:${DATA}
 * author:孟淑英
 * function:
 */
public class XiangQingFragment1 extends Fragment {
    @Bind(R.id.goodsViewPager)
    ViewPager mGoodsViewPager;
    @Bind(R.id.nameTextView)
    TextView mNameTextView;
    @Bind(R.id.jingleTextView)
    TextView mJingleTextView;
    @Bind(R.id.chooseCartButton)
    Button mChooseCartButton;
    @Bind(R.id.leftImageView)
    ImageView mLeftImageView;
    @Bind(R.id.titleTextView)
    TextView mTitleTextView;
    @Bind(R.id.rightImageView)
    ImageView mRightImageView;
    @Bind(R.id.right1ImageView)
    ImageView mRight1ImageView;
    @Bind(R.id.topLinearLayout)
    LinearLayout mTopLinearLayout;
    @Bind(R.id.pricePromotionTextView)
    TextView mPricePromotionTextView;
    @Bind(R.id.priceTextView)
    TextView mPriceTextView;
    @Bind(R.id.saleNumTextView)
    TextView mSaleNumTextView;
    @Bind(R.id.activityTextView)
    TextView mActivityTextView;
    @Bind(R.id.activityNameTextView)
    TextView mActivityNameTextView;
    @Bind(R.id.activityRemarkTextView)
    TextView mActivityRemarkTextView;
    @Bind(R.id.activityLinearLayout)
    LinearLayout mActivityLinearLayout;
    @Bind(R.id.addressTextView)
    TextView mAddressTextView;
    @Bind(R.id.addressTipTextView)
    TextView mAddressTipTextView;
    @Bind(R.id.choose1TextView)
    TextView mChoose1TextView;
    @Bind(R.id.choose2TextView)
    TextView mChoose2TextView;
    @Bind(R.id.chooseLinearLayout)
    LinearLayout mChooseLinearLayout;
    @Bind(R.id.commentTextView)
    TextView mCommentTextView;
    @Bind(R.id.commentNumTextView)
    TextView mCommentNumTextView;
    @Bind(R.id.commentLinearLayout)
    LinearLayout mCommentLinearLayout;
    @Bind(R.id.bodyTextView)
    TextView mBodyTextView;
    @Bind(R.id.storeTextView)
    TextView mStoreTextView;
    @Bind(R.id.storeDescTextView)
    TextView mStoreDescTextView;
    @Bind(R.id.storeDescStatusTextView)
    TextView mStoreDescStatusTextView;
    @Bind(R.id.storeServerTextView)
    TextView mStoreServerTextView;
    @Bind(R.id.storeServerStatusTextView)
    TextView mStoreServerStatusTextView;
    @Bind(R.id.storeDeliveryTextView)
    TextView mStoreDeliveryTextView;
    @Bind(R.id.storeDeliveryStatusTextView)
    TextView mStoreDeliveryStatusTextView;
    @Bind(R.id.storeLinearLayout)
    LinearLayout mStoreLinearLayout;
    @Bind(R.id.goodsTitleTextView)
    TextView mGoodsTitleTextView;
    @Bind(R.id.mainListView)
    ListView mMainListView;
    @Bind(R.id.scrollLinearLayout)
    LinearLayout mScrollLinearLayout;
    @Bind(R.id.mainScrollView)
    ScrollView mMainScrollView;
    @Bind(R.id.kefuTextView)
    TextView mKefuTextView;
    @Bind(R.id.cartTextView)
    TextView mCartTextView;
    @Bind(R.id.joinCartTextView)
    TextView mJoinCartTextView;
    @Bind(R.id.buyTextView)
    TextView mBuyTextView;
    @Bind(R.id.bottomLinearLayout)
    LinearLayout mBottomLinearLayout;
    @Bind(R.id.backgroundTextView)
    TextView mBackgroundTextView;
    @Bind(R.id.qrCodeCloseImageView)
    ImageView mQrCodeCloseImageView;
    @Bind(R.id.qrCode1LineView)
    View mQrCode1LineView;
    @Bind(R.id.qrCodeContentImageView)
    ImageView mQrCodeContentImageView;
    @Bind(R.id.qrCode2LineView)
    View mQrCode2LineView;
    @Bind(R.id.qrCodeOtherTextView)
    TextView mQrCodeOtherTextView;
    @Bind(R.id.qrCodeRelativeLayout)
    RelativeLayout mQrCodeRelativeLayout;
    @Bind(R.id.chooseImageView)
    ImageView mChooseImageView;
    @Bind(R.id.chooseNameTextView)
    TextView mChooseNameTextView;
    @Bind(R.id.choosePriceTextView)
    TextView mChoosePriceTextView;
    @Bind(R.id.chooseStorageTextView)
    TextView mChooseStorageTextView;
    @Bind(R.id.chooseLine1View)
    View mChooseLine1View;
    @Bind(R.id.chooseSpec1TextView)
    TextView mChooseSpec1TextView;
    @Bind(R.id.chooseSpec1Attr1TextView)
    TextView mChooseSpec1Attr1TextView;
    @Bind(R.id.chooseSpec1Attr2TextView)
    TextView mChooseSpec1Attr2TextView;
    @Bind(R.id.chooseSpec1Attr3TextView)
    TextView mChooseSpec1Attr3TextView;
    @Bind(R.id.chooseSpec1Attr4TextView)
    TextView mChooseSpec1Attr4TextView;
    @Bind(R.id.chooseSpec1Attr5TextView)
    TextView mChooseSpec1Attr5TextView;
    @Bind(R.id.chooseSpec1Attr6TextView)
    TextView mChooseSpec1Attr6TextView;
    @Bind(R.id.chooseSpec1Attr7TextView)
    TextView mChooseSpec1Attr7TextView;
    @Bind(R.id.chooseSpec1Attr8TextView)
    TextView mChooseSpec1Attr8TextView;
    @Bind(R.id.chooseSpec1Attr9TextView)
    TextView mChooseSpec1Attr9TextView;
    @Bind(R.id.chooseSpec1Attr10TextView)
    TextView mChooseSpec1Attr10TextView;
    @Bind(R.id.chooseSpec1ScrollView)
    HorizontalScrollView mChooseSpec1ScrollView;
    @Bind(R.id.chooseLine2View)
    View mChooseLine2View;
    @Bind(R.id.chooseSpec2TextView)
    TextView mChooseSpec2TextView;
    @Bind(R.id.chooseSpec2Attr1TextView)
    TextView mChooseSpec2Attr1TextView;
    @Bind(R.id.chooseSpec2Attr2TextView)
    TextView mChooseSpec2Attr2TextView;
    @Bind(R.id.chooseSpec2Attr3TextView)
    TextView mChooseSpec2Attr3TextView;
    @Bind(R.id.chooseSpec2Attr4TextView)
    TextView mChooseSpec2Attr4TextView;
    @Bind(R.id.chooseSpec2Attr5TextView)
    TextView mChooseSpec2Attr5TextView;
    @Bind(R.id.chooseSpec2Attr6TextView)
    TextView mChooseSpec2Attr6TextView;
    @Bind(R.id.chooseSpec2Attr7TextView)
    TextView mChooseSpec2Attr7TextView;
    @Bind(R.id.chooseSpec2Attr8TextView)
    TextView mChooseSpec2Attr8TextView;
    @Bind(R.id.chooseSpec2Attr9TextView)
    TextView mChooseSpec2Attr9TextView;
    @Bind(R.id.chooseSpec2Attr10TextView)
    TextView mChooseSpec2Attr10TextView;
    @Bind(R.id.chooseSpec2ScrollView)
    HorizontalScrollView mChooseSpec2ScrollView;
    @Bind(R.id.chooseLine3View)
    View mChooseLine3View;
    @Bind(R.id.chooseNumberTextView)
    TextView mChooseNumberTextView;
    @Bind(R.id.chooseAddButton)
    Button mChooseAddButton;
    @Bind(R.id.chooseNumberEditText)
    EditText mChooseNumberEditText;
    @Bind(R.id.chooseSubButton)
    Button mChooseSubButton;
    @Bind(R.id.chooseNumberRelativeLayout)
    RelativeLayout mChooseNumberRelativeLayout;
    @Bind(R.id.chooseLine4View)
    View mChooseLine4View;
    @Bind(R.id.chooseBuyButton)
    Button mChooseBuyButton;
    @Bind(R.id.chooseRelativeLayout)
    RelativeLayout mChooseRelativeLayout;
    @Bind(R.id.mainRelativeLayout)
    RelativeLayout mMainRelativeLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.activity_goods_detail, null);
        ButterKnife.bind(this, view);
        Intent intent = getActivity().getIntent();
        String name = intent.getStringExtra("name");
        String url = intent.getStringExtra("url");
        String price = intent.getStringExtra("price");
        mNameTextView.setText(name);
        mJingleTextView.setText(price);
        MyPagerAdapter myPageradapter = new MyPagerAdapter(getActivity(), url);
        mGoodsViewPager.setAdapter(myPageradapter);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.chooseCartButton)
    public void onViewClicked() {

    }
}
