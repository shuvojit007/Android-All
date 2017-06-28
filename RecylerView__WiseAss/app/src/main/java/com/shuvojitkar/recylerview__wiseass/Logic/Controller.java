package com.shuvojitkar.recylerview__wiseass.Logic;

import com.shuvojitkar.recylerview__wiseass.Data.DataSourceInterface;
import com.shuvojitkar.recylerview__wiseass.Data.ListItem;
import com.shuvojitkar.recylerview__wiseass.View.ViewInterface;

/**
 * Created by SHOBOJIT on 6/16/2017.
 */

public class Controller {


    private ViewInterface view;
    private DataSourceInterface data;

    public Controller(ViewInterface view, DataSourceInterface data) {
        this.view = view;
        this.data = data;
       getListFromDataSource();
    }

    public void getListFromDataSource() {
        view.setUpAdapterAndView(
                data.getListOfData());
    }


    public void onListItemClick(ListItem testItem) {
    view.startDetailActivity(testItem.getDateAndTime(),
            testItem.getMessage(),
            testItem.getColorResource());
    }

}
