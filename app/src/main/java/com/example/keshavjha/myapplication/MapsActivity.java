package com.example.keshavjha.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.Map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setTrafficEnabled(true);


        // Add a marker in Sydney and move the camera
        LatLng Dehradun = new LatLng(30.316495, 78.032192);
        LatLng mugalsarai = new LatLng(25.281495, 83.119820);
        mMap.addMarker(new MarkerOptions().position(Dehradun).title(" Dehradun"));
        mMap.addMarker(new MarkerOptions().position(mugalsarai).title("Mugalsarai"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Dehradun));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mugalsarai));
    }

    public Double[] findLatLong() {


        RequestQueue rq = Volley.newRequestQueue(MapsActivity.this);
        StringRequest postRequest = new StringRequest(Request.Method.POST, "https://maps.googleapis.com/maps/api/geocode/json" +
                "?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA" +
                "&key=AIzaSyDZ_oqe9-TFzN7yZ68jpXXYP4ctd49d3ow",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {



            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();


                return params;
            }
        };

        rq.add(postRequest);


        return null;
    }


}
