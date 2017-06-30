package com.example.administrator.dianshang.view.fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.example.administrator.dianshang.R;
import com.example.administrator.dianshang.model.bean.XiangQingBean;
import com.example.administrator.dianshang.model.utils.Constant;
import com.example.administrator.dianshang.view.activity.SecondActivity;
import com.example.administrator.dianshang.view.adapter.MyAdapter;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import java.util.ArrayList;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;

import static com.example.administrator.dianshang.model.utils.Constant.code3;
import static com.example.administrator.dianshang.model.utils.Constant.code4;

/**
 * date:${DATA}
 * author:孟淑英
 * function:
 */
public class XiangQingFragment extends Fragment{
    @Bind(R.id.mainListView)
    ListView mMainListView;
    @Bind(R.id.mainLinearLayout)
    LinearLayout mMainLinearLayout;
    List<XiangQingBean.DatasBean.GoodsListBean> mGoods_list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.activity_search, null);
        ButterKnife.bind(this, view);
        //注册EventBus
        EventBus.getDefault().register(this);
        mGoods_list=new ArrayList<>();

        return view;
    }
    //3. 接收黏性事件,多了一个属性Sticky,改为true方是启动黏性事件  一定要写注解   注意：一定是对方发什么这边接什么
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void ReceviceMessage(final List<XiangQingBean.DatasBean.GoodsListBean> mGoods_list){
        this.mGoods_list=mGoods_list;
        MyAdapter myAdapter=new MyAdapter(getActivity(),mGoods_list);
        mMainListView.setAdapter(myAdapter);
        mMainListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),SecondActivity.class);
                intent.putExtra(Constant.BiaoShi,code4);
                intent.putExtra("name",mGoods_list.get(position).getGoods_name());
                intent.putExtra("url",mGoods_list.get(position).getGoods_image_url());
                intent.putExtra("price",mGoods_list.get(position).getGoods_price());
                startActivity(intent);
            }
        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
