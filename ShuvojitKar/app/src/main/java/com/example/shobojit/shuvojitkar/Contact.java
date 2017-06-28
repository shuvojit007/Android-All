package com.example.shobojit.shuvojitkar;


import android.net.Uri;

/**
 * Created by Johnny Manson on 23.07.13.
 */
public class Contact {

    private String _name, _phone, _email, _job,_address;
    private Uri _imageURI;
    private int _id;

    public Contact (int id, String name, String phone, String email, String address,String job, Uri imageURI) {
        _id = id;
        _name = name;
        _phone = phone;
        _email = email;
        _address = address;
        _job = job;
        _imageURI = imageURI;
    }

    public int getId() { return _id; }

    public String getName() {
        return _name;
    }

    public String getPhone() {
        return _phone;
    }

    public String getEmail() {
        return _email;
    }

    public String getAddress() {
        return _address;
    }
    public String getjob() {
        return _job;
    }

    public Uri getImageURI() { return _imageURI; }
}
