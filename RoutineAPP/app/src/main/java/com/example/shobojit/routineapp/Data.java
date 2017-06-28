package com.example.shobojit.routineapp;

import com.example.shobojit.routineapp.Model.FirebaseAdapter;

import java.util.List;

/**
 * Created by SHOBOJIT on 6/23/2017.
 */

public class Data {
    List<FirebaseAdapter>data;

    public Data(List<FirebaseAdapter> data) {
        this.data = data;
    }

    public Data() {
    }

    List<FirebaseAdapter> GetData(){
        if(data==null){
            return null;
        }
    return data;
    }
}
