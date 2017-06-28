package com.example.shobojit.eventbus.adapter;

/**
 * Created by SHOBOJIT on 1/9/2017.
 */

public class MessageEvent {
   private String mesg;

    public MessageEvent(String mesg) {
        this.mesg = mesg;
    }
    public String getMesg(){
        return  mesg;
    }


}
