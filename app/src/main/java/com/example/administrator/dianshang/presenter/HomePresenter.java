package com.example.administrator.dianshang.presenter;

import com.example.administrator.dianshang.view.iview.IHomeView;

/**
 * date:${DATA}
 * author:孟淑英
 * function:
 */

public class HomePresenter extends BasePresenter{
      private IHomeView mIHomeView;
     public void attachView(IHomeView homeView){
         mIHomeView=homeView;
     }
}
