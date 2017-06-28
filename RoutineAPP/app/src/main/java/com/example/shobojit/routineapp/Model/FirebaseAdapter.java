package com.example.shobojit.routineapp.Model;

/**
 * Created by SHOBOJIT on 5/24/2017.
 */

public class FirebaseAdapter {
    String end;
    String name;
    String room;
    String start;
    String tname;

    public FirebaseAdapter() {
    }

    public FirebaseAdapter(String end, String name, String room, String start, String tname) {
        this.end = end;
        this.name = name;
        this.room = room;
        this.start = start;
        this.tname = tname;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
