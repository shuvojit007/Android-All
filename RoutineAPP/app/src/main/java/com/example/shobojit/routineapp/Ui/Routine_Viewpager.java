package com.example.shobojit.routineapp.Ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shobojit.routineapp.Model.FirebaseAdapter;
import com.example.shobojit.routineapp.Model.GetFirebaseData;
import com.example.shobojit.routineapp.R;
import com.example.shobojit.routineapp.Utils.Firebase_Instance;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Routine_Viewpager extends AppCompatActivity implements GetFirebaseData.GetFireBaseInterface {
    TextView tt;
    ListAdapter adapter;
    ListView lv;
    ProgressDialog pd;
    Context cn;

    List<FirebaseAdapter> data;
    List<FirebaseAdapter> SAT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine__viewpager);
        String s = getIntent().getExtras().getString("Name");
        tt = (TextView) findViewById(R.id.tt);
        pd = new ProgressDialog(this);
        pd.show();
        tt.setText(s);
        lv = (ListView) findViewById(R.id.lv);
        cn =this;

       // data = RoutineData(s);
        new GetFirebaseData().FetchFirebaseData(cn,s);

    }


    List<FirebaseAdapter> RoutineData(String s){
        final List<FirebaseAdapter>datalist;
        DatabaseReference df = Firebase_Instance.getFirebaseDatabaseInstance().getReference(s);
        datalist = new ArrayList<>();
        df.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                datalist.clear();
                for (DataSnapshot i : dataSnapshot.getChildren()){
                    if (i!=null){
                        String k = i.getKey().toString();
                        Toast.makeText(cn, "1 : " +i.getKey().toString(), Toast.LENGTH_SHORT).show();
            if (k.equals("MON")){
                            for (DataSnapshot ii :i.getChildren()){
                                for (DataSnapshot iii : ii.getChildren()){
                                    String key = iii.getKey().toString();
                                   // Toast.makeText(cn, "2 : "+ii.getKey().toString()+": " +key+" "+iii.getValue(),Toast.LENGTH_SHORT).show();
                                    if (key.equals("end")){
                                        Toast.makeText(cn, iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if (key.equals("name")){
                                        Toast.makeText(cn, iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if (key.equals("room")){
                                        Toast.makeText(cn, iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if (key.equals("start")){
                                        Toast.makeText(cn, iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if(key.equals("tname")){
                                        Toast.makeText(cn, iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }
                                }

                                
                                
                                
                     //        Toast.makeText(cn, "3 : " +ii.getKey().toString()+" "+ii.getValue(), Toast.LENGTH_SHORT).show();
//                                FirebaseAdapter adapter = ii.getValue(FirebaseAdapter.class);
//                                datalist.add(adapter);
//                                Logger.d(adapter.getName()+" "+ adapter.getTname()+
//                                        " "+ adapter.getRoom());
                        }}
                    }
                    }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        return  datalist;
    }


    @Override
    public void SetUpAdapter(List result) {
        SAT = result;
        if (SAT==null){

        }else {
            pd.dismiss();
            adapter = new ListAdapter(cn,SAT);
            lv.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }
}

class ListAdapter extends ArrayAdapter{
    private Activity cn;
    List<FirebaseAdapter> firebaseAdapters;
    public ListAdapter( Context context,List<FirebaseAdapter>SAT ) {
        super(context,0,SAT);
        this.cn = (Activity) context;
        this.firebaseAdapters = SAT;
    }
    private static class ViewHolder {
        TextView classname,roomno,teachername,starttime,endtime;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater;
        ViewHolder holder;

        if (view == null) {
            holder = new ViewHolder();
            inflater = cn.getLayoutInflater();
            view = inflater.from(cn).inflate(R.layout.routine_list_view, parent, false);
            holder.classname = (TextView) view.findViewById(R.id.classname);
            holder.roomno = (TextView) view.findViewById(R.id.room);
            holder.teachername = (TextView) view.findViewById(R.id.teachername);
            holder.starttime = (TextView) view.findViewById(R.id.starttime);
            holder.endtime = (TextView) view.findViewById(R.id.endtime);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.classname.setText(firebaseAdapters.get(position).getName());
        holder.roomno.setText(firebaseAdapters.get(position).getRoom());
        holder.teachername.setText(firebaseAdapters.get(position).getTname());
        holder.starttime.setText(firebaseAdapters.get(position).getStart());
        holder.endtime.setText(firebaseAdapters.get(position).getEnd());
        return view;
    }
}
