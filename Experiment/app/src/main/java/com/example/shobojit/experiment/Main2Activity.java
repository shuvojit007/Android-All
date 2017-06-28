package com.example.shobojit.experiment;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

public class Main2Activity extends AppCompatActivity implements OnMapReadyCallback {
        GoogleMap googleMapV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(googleServicesAvailable()){
            Toast.makeText(getApplicationContext(),"Perfect",Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_main2);
            init();
        }else{

}
        }
public void init(){
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.frag);
        mapFragment.getMapAsync(this);
        }

public boolean googleServicesAvailable(){
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvailable = api.isGooglePlayServicesAvailable(this);
        if(isAvailable== ConnectionResult.SUCCESS){
        return true;

        }else if(api.isUserResolvableError(isAvailable)){
        Dialog dialog  = api.getErrorDialog(this,isAvailable,0);
        dialog.show();
        }
        else{
        Toast.makeText(getApplicationContext(),"Can't connect to play services ",Toast.LENGTH_SHORT).show();

        }return  false;
        }

@Override
public void onMapReady(GoogleMap googleMap) {
        googleMapV=googleMap;
        }
        }
