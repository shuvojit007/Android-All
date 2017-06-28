package com.example.shobojit.firebasenewpractise.Utils;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by SHOBOJIT on 5/27/2017.
 */

public class FirebaseGetInstanceClass {

    private static FirebaseDatabase firebaseDatabase;

    public static  FirebaseDatabase GetFirebaseDatabaseInstance(){

        if (firebaseDatabase ==null){
            firebaseDatabase = FirebaseDatabase.getInstance();
            firebaseDatabase.setPersistenceEnabled(true);
        }
        return firebaseDatabase;
    }
}
