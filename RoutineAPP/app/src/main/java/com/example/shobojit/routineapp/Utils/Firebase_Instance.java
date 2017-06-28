package com.example.shobojit.routineapp.Utils;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by SHOBOJIT on 5/23/2017.
 */

public class Firebase_Instance {
    private static FirebaseDatabase mdatabase;
    public static FirebaseDatabase getFirebaseDatabaseInstance(){
        if (mdatabase ==null){
            mdatabase =FirebaseDatabase.getInstance();
            mdatabase.setPersistenceEnabled(true);
        }
        return  mdatabase;
    }
}
