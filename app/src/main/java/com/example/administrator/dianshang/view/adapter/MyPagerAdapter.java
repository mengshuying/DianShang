package com.example.administrator.dianshang.view.adapter;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.example.administrator.dianshang.model.bean.XiangQingBean;
import java.util.List;
/**
 * date:${DATA}
 * author:孟淑英
 * function:
 */
public class MyPagerAdapter extends PagerAdapter{
    private final Context mContext;
    private final String mString;
    public MyPagerAdapter(Context context, String stt){
        mString =stt;
        mContext =context;
    }
    @Override
    public int getCount(){
        return 1;
    }
    @Override
    public boolean isViewFromObject(View view, Object object){
        return view==object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position){
        ImageView imageView = new ImageView(mContext);
        Glide.with(mContext).load(mString).into(imageView);
        container.addView(imageView);
        return imageView;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((View) object);
    }
}
