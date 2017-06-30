package com.example.administrator.dianshang.view.adapter;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.administrator.dianshang.R;
import com.example.administrator.dianshang.model.bean.Class1Bean;
import java.util.ArrayList;
import java.util.List;
/**
 * date:${DATA}
 * author:孟淑英
 * function:
 */
public class MyRecycleViewClass1 extends RecyclerView.Adapter<MyRecycleViewClass1.ViewHolder>{
    private final Context mContext;
    private final List<Class1Bean.DatasBean.ClassListBean> mClass1Been;
   public static List<Integer> list;
    //定义一个接口的属性
    private OnItemClickListener onItemClickListener;
    //定义一个接口
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }
    //将定义的接口和定义的接口属性关联起来
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    public MyRecycleViewClass1(Context context, List<Class1Bean.DatasBean.ClassListBean> list){
         mContext =context;
         mClass1Been =list;
     }
    @Override
    public MyRecycleViewClass1.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view=View.inflate(mContext, R.layout.item_list_class1,null);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final MyRecycleViewClass1.ViewHolder holder, final int position){
        holder.mMainTextView.setText(mClass1Been.get(position).getGc_name());
        Glide.with(mContext).load(mClass1Been.get(position).getImage()).into(holder.mMainImageView);
         //第一次走的是else 因为刚进去没点。所以都是灰的。当点击的时候就走if 并且每次点击的话只保存一个 所以他的下标永远是0
       // 然后点击的时候就是红色 holder.mMainTextView得到所有的TextView.我刚开始传到监听里面做判断 监听里面只能得到当前点击条目的Textview 没办法设置灰色。
         if(list!=null&&list.get(0).equals(position)){
             holder.mMainTextView.setTextColor(Color.RED);
          }else{
             holder.mMainTextView.setTextColor(Color.GRAY);
          }
       if(onItemClickListener!=null){
           holder.mMainRelativeLayout.setOnClickListener(new View.OnClickListener(){
               @Override
               public void onClick(View v){
                   onItemClickListener.onItemClick(holder.itemView,position);
                   //每次都实例化一个List,每次点击的时候都是存一个当前点击的位置位置
                   list=new ArrayList<Integer>();
                   list.add(position);

               }
           });
       }
    }
    @Override
    public int getItemCount(){
        return mClass1Been.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private final ImageView mMainImageView;
        private final TextView mMainTextView;
        private final RelativeLayout mMainRelativeLayout;

        public ViewHolder(View itemView){
            super(itemView);
            mMainImageView = (ImageView) itemView.findViewById(R.id.mainImageView);
            mMainTextView = (TextView) itemView.findViewById(R.id.mainTextView);
            mMainRelativeLayout = (RelativeLayout) itemView.findViewById(R.id.mainRelativeLayout);
        }
    }
}
