package com.example.shobojit.routineapp.Ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;

public class MainActivity extends AppCompatActivity {
    DatabaseReference databaseReference = Firebase_Instance.getFirebaseDatabaseInstance().getReference("dpt");
    List <String>dpt;
    List<FirebaseAdapter> SAT;
    String selectdpt;
    ProgressDialog pd;

    Context cn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cn = this;

        Get_Data_From_Firebase();
        findViewById(R.id.scbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectdpt==null){
                    Toast.makeText(cn, "Please select a dpt ", Toast.LENGTH_SHORT).show();
                }else{
                    startActivity(new Intent(MainActivity.this,Routine_Viewpager.class).putExtra("Name",selectdpt));
                }
            }
        });

        findViewById(R.id.ssp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dpt ==null){
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
                    Get_Data_From_Firebase();

                }else {
                   SpinnerDialog spinnerDialog;
                   spinnerDialog=new SpinnerDialog(MainActivity.this, (ArrayList<String>) dpt,"Select or Search Your Dpt");
                   spinnerDialog.showSpinerDialog();
                   spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
                        @Override
                        public void onClick(String item, int position) {
                  //   Toast.makeText(MainActivity.this, item , Toast.LENGTH_SHORT).show();
                            selectdpt = item;

                        }
                    });

                }

            }
        });
    }


    void Get_Data_From_Firebase(){
        dpt = new ArrayList<>();
        final ProgressDialog Dialog = new ProgressDialog(cn);
        Dialog.setMessage("Doing something...");
        Dialog.show();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dpt.clear();
                for (DataSnapshot i : dataSnapshot.getChildren()){
                    if(i!=null){
                        for (DataSnapshot user : i.getChildren()){
                            String value = user.getValue().toString();
                            dpt.add(value);
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
}
