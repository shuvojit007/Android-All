package com.shuvojitkar.recylerview__wiseass.View;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shuvojitkar.recylerview__wiseass.Data.DataSourceInterface;
import com.shuvojitkar.recylerview__wiseass.Data.FakeDataSource;
import com.shuvojitkar.recylerview__wiseass.Data.ListItem;
import com.shuvojitkar.recylerview__wiseass.Logic.Controller;
import com.shuvojitkar.recylerview__wiseass.R;

import java.util.List;

public class List_Activity extends AppCompatActivity implements  ViewInterface {

    private static final String EXTRA_DATE_AND_TIME = "EXTRA_DATE_AND_TIME";
    private static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    private static final String EXTRA_COLOR = "EXTRA_COLOR";
    private  List<ListItem>lisOfData;

    private LayoutInflater inflater;
    private RecyclerView recyclerView;
    private CustomAdapter adapter;
    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recyclerView = (RecyclerView) findViewById(R.id.rec_lis_activity);
        inflater = getLayoutInflater();
        controller = new Controller(this,new FakeDataSource());
    }

    @Override
    public void startDetailActivity(String dateandtime, String message, int colorres) {
        Intent i = new Intent(this, DetailActivity.class);
        i.putExtra(EXTRA_DATE_AND_TIME, dateandtime);
        i.putExtra(EXTRA_MESSAGE, message);
        i.putExtra(EXTRA_COLOR, colorres);
        startActivity(i);
    }

    @Override
    public void setUpAdapterAndView(List<ListItem> listofData) {
        this.lisOfData = listofData;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapter();
        recyclerView.setAdapter(adapter);
    }

    private class  CustomAdapter extends  RecyclerView.Adapter<CustomAdapter.CustomViewHolder>{

        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = inflater.inflate(R.layout.item_data, parent, false);
            return new CustomViewHolder(v);
        }

        @Override
        public void onBindViewHolder(CustomViewHolder holder, int position) {
            ListItem currentItem = lisOfData.get(position);
            holder.coloredCircle.setBackgroundResource(currentItem.getColorResource());
            holder.message.setText(currentItem.getMessage());
            holder.dateAndTime.setText(currentItem.getDateAndTime());

        }

        @Override
        public int getItemCount() {
            return lisOfData.size();
        }


        class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            private View coloredCircle;
            private TextView dateAndTime;
            private TextView message;
            private ViewGroup container;
            public CustomViewHolder(View itemView) {
                super(itemView);
                this.coloredCircle = itemView.findViewById(R.id.list_img);
                this.dateAndTime = (TextView) itemView.findViewById(R.id.lbl_date_and_time);
                this.message = (TextView) itemView.findViewById(R.id.lbl_message);

                this.container = (ViewGroup) itemView.findViewById(R.id.root_list_item);
                container.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                ListItem listItem = lisOfData.get(this.getAdapterPosition());
                controller.onListItemClick(listItem);
            }
        }

    }

}
