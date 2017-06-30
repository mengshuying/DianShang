package com.example.administrator.dianshang.model.utils;
import android.app.Activity;
import android.widget.Toast;
/**
 * date:${DATA}
 * author:孟淑英
 * function:
 */
public class ToastUtil{
    public static Toast sToast=null;
   public static void show(Activity activity,String stt){
      if(sToast==null){
          sToast= Toast.makeText(activity,stt,Toast.LENGTH_SHORT);
      }else{
          sToast.setText(stt);
          sToast.setDuration(Toast.LENGTH_SHORT);
      }
       sToast.show();
   }
}
