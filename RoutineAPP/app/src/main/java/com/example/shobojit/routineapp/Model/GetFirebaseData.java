package com.example.shobojit.routineapp.Model;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Toast;

import com.example.shobojit.routineapp.Ui.Routine_Viewpager;
import com.example.shobojit.routineapp.Utils.Firebase_Instance;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHOBOJIT on 5/23/2017.
 */

public class GetFirebaseData {
    public interface GetFireBaseInterface{
        void SetUpAdapter(List result);
    }

    public static List <FirebaseAdapter> SATdata ;
    public static List <FirebaseAdapter> MONdata ;
    public static List <FirebaseAdapter> SUNdata ;
    public static List <FirebaseAdapter> THUdata ;
    public static List <FirebaseAdapter> WEDdata ;
    public static List <FirebaseAdapter> TUEdata ;
    public static ProgressDialog pd;
    GetFireBaseInterface in;
    public static List AllDATA = new ArrayList();
    public  void FetchFirebaseData(Context cn, String s){
        if(cn instanceof Routine_Viewpager){
            in = (GetFireBaseInterface) cn;
        }

      //  pd = new ProgressDialog(cn);
    DatabaseReference df = Firebase_Instance.getFirebaseDatabaseInstance().getReference(s);
        SATdata = new ArrayList<>();
        SUNdata = new ArrayList<>();
        MONdata = new ArrayList<>();
        THUdata = new ArrayList<>();
        TUEdata = new ArrayList<>();
        WEDdata = new ArrayList<>();
final Context cnn = cn;

      df.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            SATdata.clear(); MONdata.clear(); SUNdata.clear();
            THUdata.clear(); WEDdata.clear(); TUEdata.clear();
                 for (DataSnapshot i : dataSnapshot.getChildren()){
                    if (i!=null){
                        String DAY = i.getKey().toString();
                        if (DAY.equals("SAT")) {

                            for (DataSnapshot ii : i.getChildren()) {
                                FirebaseAdapter adapter = new FirebaseAdapter();
                                for (DataSnapshot iii : ii.getChildren()) {
                                    String key = iii.getKey().toString();
                                    if (key.equals("end")){
                                        adapter.setEnd(iii.getValue().toString());
                                     //   Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if (key.equals("name")){
                                        adapter.setName(iii.getValue().toString());
                                    //    Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if (key.equals("room")){
                                        adapter.setRoom(iii.getValue().toString());
                                   //     Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if (key.equals("start")){
                                        adapter.setStart(iii.getValue().toString());
                                   //     Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if(key.equals("tname")){
                                        adapter.setTname(iii.getValue().toString());
                                   //     Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                                SATdata.add(adapter);
                            }
                        }else if (DAY.equals("SUN")){
                            for (DataSnapshot ii : i.getChildren()) {
                                FirebaseAdapter adapter = new FirebaseAdapter();
                                for (DataSnapshot iii : ii.getChildren()) {
                                    String key = iii.getKey().toString();
                                    if (key.equals("end")){
                                        adapter.setEnd(iii.getValue().toString());
                                     //   Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if (key.equals("name")){
                                        adapter.setName(iii.getValue().toString());
                                   //     Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if (key.equals("room")){
                                        adapter.setRoom(iii.getValue().toString());
                                   //     Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if (key.equals("start")){
                                        adapter.setStart(iii.getValue().toString());
                                   //     Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if(key.equals("tname")){
                                        adapter.setTname(iii.getValue().toString());
                                   //     Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                                SUNdata.add(adapter);

                            }
                        }else if (DAY.equals("MON")){
                            for (DataSnapshot ii : i.getChildren()) {
                                FirebaseAdapter adapter = new FirebaseAdapter();
                                for (DataSnapshot iii : ii.getChildren()) {
                                    String key = iii.getKey().toString();
                                    if (key.equals("end")){
                                        adapter.setEnd(iii.getValue().toString());
                                      //  Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if (key.equals("name")){
                                        adapter.setName(iii.getValue().toString());
                                     //   Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if (key.equals("room")){
                                        adapter.setRoom(iii.getValue().toString());
                                    //    Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if (key.equals("start")){
                                        adapter.setStart(iii.getValue().toString());
                                     //   Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if(key.equals("tname")){
                                        adapter.setTname(iii.getValue().toString());
                                   //     Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                                MONdata.add(adapter);

                            }
                        }
                        else if (DAY.equals("THU")){
                            for (DataSnapshot ii : i.getChildren()) {
                                FirebaseAdapter adapter = new FirebaseAdapter();
                                for (DataSnapshot iii : ii.getChildren()) {
                                    String key = iii.getKey().toString();
                                    if (key.equals("end")){
                                        adapter.setEnd(iii.getValue().toString());
                                    //    Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if (key.equals("name")){
                                        adapter.setName(iii.getValue().toString());
                                    //    Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if (key.equals("room")){
                                        adapter.setRoom(iii.getValue().toString());
                                   //     Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if (key.equals("start")){
                                        adapter.setStart(iii.getValue().toString());
                                   //     Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if(key.equals("tname")){
                                        adapter.setTname(iii.getValue().toString());
                                   //     Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                                THUdata.add(adapter);

                            }
                        }else if (DAY.equals("TUE")){
                            for (DataSnapshot ii : i.getChildren()) {
                                FirebaseAdapter adapter = new FirebaseAdapter();
                                for (DataSnapshot iii : ii.getChildren()) {
                                    String key = iii.getKey().toString();
                                    if (key.equals("end")){
                                        adapter.setEnd(iii.getValue().toString());
                                  //      Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if (key.equals("name")){
                                        adapter.setName(iii.getValue().toString());
                                   //     Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if (key.equals("room")){
                                        adapter.setRoom(iii.getValue().toString());
                                   //     Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if (key.equals("start")){
                                        adapter.setStart(iii.getValue().toString());
                                  //      Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if(key.equals("tname")){
                                        adapter.setTname(iii.getValue().toString());
                                 //       Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                                TUEdata.add(adapter);

                            }
                        }else if (DAY.equals("WED")){
                            for (DataSnapshot ii : i.getChildren()) {
                                FirebaseAdapter adapter = new FirebaseAdapter();
                                for (DataSnapshot iii : ii.getChildren()) {
                                    String key = iii.getKey().toString();
                                    if (key.equals("end")){
                                        adapter.setEnd(iii.getValue().toString());
                                     //   Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if (key.equals("name")){
                                        adapter.setName(iii.getValue().toString());
                                     //   Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if (key.equals("room")){
                                        adapter.setRoom(iii.getValue().toString());
                                    //    Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if (key.equals("start")){
                                        adapter.setStart(iii.getValue().toString());
                                     //   Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }else if(key.equals("tname")){
                                        adapter.setTname(iii.getValue().toString());
                                      //  Toast.makeText(cnn, DAY+" : "+ii.getKey()+ " : "+iii.getValue().toString(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                                WEDdata.add(adapter);

                            }

                        }
                }
            }
            AllDATA.add(SATdata);
           // AllDATA.add(SUNdata);
            //AllDATA.add(MONdata);
            //AllDATA.add(TUEdata);
            //AllDATA.add(WEDdata);
            //AllDATA.add(THUdata);
       // pd.dismiss();
       // ToastData(cnn);
            in.SetUpAdapter(SATdata);

        }


        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });
}


static  void ToastData(Context cnn){
     List <FirebaseAdapter> Sat =null ;
    for (int i =0;i<AllDATA.size();i++){
        Sat = (List<FirebaseAdapter>) AllDATA.get(i);
        for (int j = 0; j < Sat.size(); j++) {
      /*      List <FirebaseAdapter> ss = (List) Sat.get(i);
            for (int k = 0;k<ss.size();k++){
                String value =ss.get(i).
            }*/
            String s = Sat.get(j).getTname();
            Toast.makeText(cnn, "Class Name: &&"+j+ " :" + Sat.get(j).getName(), Toast.LENGTH_SHORT).show();
            Toast.makeText(cnn, "Teacher Name &&"+j+ " :" + Sat.get(j).getTname(), Toast.LENGTH_SHORT).show();
         /*   Toast.makeText(cnn, "ToastData: &&"+j+ " :" + s, Toast.LENGTH_SHORT).show();
            Toast.makeText(cnn, "ToastData: &&"+j+ " :" + s, Toast.LENGTH_SHORT).show();
            Toast.makeText(cnn, "ToastData: &&"+j+ " :" + s, Toast.LENGTH_SHORT).show();*/

        }
        if (i==0) break;
    }

}

    public static List<FirebaseAdapter> getSATdata() {
        return SATdata;
    }

    public static List<FirebaseAdapter> getMONdata() {
        return MONdata;
    }

    public static List<FirebaseAdapter> getSUNdata() {
        return SUNdata;
    }

    public static List<FirebaseAdapter> getTHUdata() {
        return THUdata;
    }

    public static List<FirebaseAdapter> getWEDdata() {
        return WEDdata;
    }

    public static List<FirebaseAdapter> getTUEdata() {
        return TUEdata;
    }
}
