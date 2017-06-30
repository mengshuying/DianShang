package com.example.administrator.dianshang.view.adapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.administrator.dianshang.R;
import com.example.administrator.dianshang.model.bean.XiangQingBean;
import org.greenrobot.eventbus.EventBus;
import java.util.List;
/**
 * date:${DATA}
 * author:孟淑英
 * function:
 */
public class MyAdapter extends BaseAdapter{
        private final Context mContext;
        private final List<XiangQingBean.DatasBean.GoodsListBean> mComicsBeen;
        public MyAdapter(Context context, List<XiangQingBean.DatasBean.GoodsListBean> list){
             mContext =context;
             mComicsBeen =list;
         }
        @Override
        public int getCount(){
            return mComicsBeen.size();
        }
        @Override
        public Object getItem(int position){
            return mComicsBeen.get(position);
        }
        @Override
        public long getItemId(int position){
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            ViewHolder viewHolder;
            if(convertView==null){
                convertView=View.inflate(mContext, R.layout.xiao_layout,null);
                viewHolder=new ViewHolder();
                viewHolder.imageview= (ImageView) convertView.findViewById(R.id.imageview);
                viewHolder.textview1= (TextView) convertView.findViewById(R.id.textview1);
                viewHolder.textview2= (TextView) convertView.findViewById(R.id.textview2);
                convertView.setTag(viewHolder);
             }else{
                viewHolder= (ViewHolder) convertView.getTag();
             }
            Glide.with(mContext).load(mComicsBeen.get(position).getGoods_image_url()).into(viewHolder.imageview);
            viewHolder.textview1.setText(mComicsBeen.get(position).getGoods_name());
            viewHolder.textview2.setText(mComicsBeen.get(position).getGoods_price());


             return convertView;
        }
        public class ViewHolder{
            ImageView imageview;
            TextView textview1;
            TextView textview2;
        }
}
