package com.example.keshavjha.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Adapters.NumAdapter;
import UriFile.Connections;

public class NumSearch extends AppCompatActivity {

  public  ListView lv;
 public  String val, name;
  public  List<String> trainNo, trainName, sourceCity, destCity, status, runningDays, arrtime, depttime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_search);



            trainName = new ArrayList<>();
            trainNo = new ArrayList<>();
            status = new ArrayList<>();
            sourceCity = new ArrayList<>();
            destCity = new ArrayList<>();
            runningDays = new ArrayList<>();
            arrtime = new ArrayList<>();
            depttime = new ArrayList<>();



            lv = (ListView) findViewById(R.id.listView2);



        Connections conn = new Connections(NumSearch.this,"http://192.168.1.100:80/keshav/getbynumber.php",getIntent().getExtras().getString("number"));
        conn.sendRequestForNumber();


    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
