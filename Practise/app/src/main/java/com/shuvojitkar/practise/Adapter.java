package com.shuvojitkar.practise;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by SHOBOJIT on 6/22/2017.
 */

public class Adapter  implements Parcelable{
    private String name;
    private String phn;
    private String addr;

    public Adapter(String name, String phn, String addr) {
        this.name = name;
        this.phn = phn;
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public String getPhn() {
        return phn;
    }

    public String getAddr() {
        return addr;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(phn);
        dest.writeString(addr);
    }

    private Adapter(Parcel in){
        this.name = in.readString();
        this.phn = in.readString();
        this.addr = in.readString();
    }

    public static final Parcelable.Creator<Adapter> CREATOR = new Parcelable.Creator<Adapter>() {

        @Override
        public Adapter createFromParcel(Parcel source) {
            return new Adapter(source);
        }

        @Override
        public Adapter[] newArray(int size) {
            return new Adapter[size];
        }
    };
}
