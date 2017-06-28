package com.shuvojitkar.recylerview__wiseass.View;

import com.shuvojitkar.recylerview__wiseass.Data.ListItem;

import java.util.List;

/**
 * Created by SHOBOJIT on 6/16/2017.
 */

public interface ViewInterface {

    void startDetailActivity(String dateandtime,String message,int colorres);
    void setUpAdapterAndView(List<ListItem> listofData);
}
