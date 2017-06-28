package com.example.shobojit.siuroutineapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.shobojit.siuroutineapp.Util.Utils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.student) Button stdbtn;
    @BindView(R.id.teacher) Button teacherbtn;
    List<String>dptname;
    SharedPreferences preferences;
    DatabaseReference databaseReference = Utils.getDatabase().getReference("dpt");
    Context cn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences("RoutineData",MODE_PRIVATE);
        ButterKnife.bind(this);
        cn = this;
        StartAlgo();
    }

    void   StartAlgo(){
        String result = preferences.getString("First","null");
        if (result=="null"){
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("First","firsttime");
            editor.commit();
        }

        if (haveNetworkConnection()==true){
            GetDataFromNet();
        }else {
            GetDataFromNet();
            ShowDialog();
        }
    }

    @OnClick(R.id.student)
    void Student(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        View dialogView = getLayoutInflater().inflate(R.layout.student_dialog,null);
        final Spinner sp = (Spinner) dialogView.findViewById(R.id.sp);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.spinner, dptname);
        // adapter.notifyDataSetChanged();
        sp.setAdapter(adapter);
        Button studentbtn = (Button)dialogView.findViewById(R.id.studentdialogbtn);
        studentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value  = sp.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        });

        builder.setView(dialogView);
        AlertDialog dialog = builder.create();
        dialog.show();

    }


    void ShowDialog(){
        String result = preferences.getString("First","null");
        if (result=="null"){
            AlertDialog alertDialog = new AlertDialog.Builder(cn).create();
            alertDialog.setTitle("No Internet Connection");
            alertDialog.setMessage("Would you like to try Again");
            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "NO",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            finish();
                        }
                    });
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "YES",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            StartAlgo();
                        }
                    });

            alertDialog.show();
        }else {
            AlertDialog alertDialog = new AlertDialog.Builder(cn).create();
            alertDialog.setTitle("Attention");
            alertDialog.setMessage("No Internet Connection");
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "YES",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }


    }
    void GetDataFromNet(){
         final ProgressDialog Dialog = new ProgressDialog(cn);
        Dialog.setMessage("Doing something...");
        Dialog.show();
        dptname = new ArrayList<>();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dptname.clear();
                for (DataSnapshot i : dataSnapshot.getChildren()){
                    if(i!=null){
                        for (DataSnapshot user : i.getChildren()){
                            String value = user.getValue().toString();
                            dptname.add(value);
                        }
                    }
                }
                Dialog.hide();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }


    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }
}
