package com.example.keshavjha.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Adapters.NumAdapter;
import Adapters.SaveVal;
import UriFile.Connections;

public class NameSearch extends AppCompatActivity {

  public  ListView lv;
  public  String val, name;
   public  List<String> trainNo, trainName, sourceCity, destCity, status, runningDays, arrtime, depttime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_search);


        lv = (ListView) findViewById(R.id.listView2);
        trainNo=new ArrayList<String>();
        trainName=new ArrayList<String>();
        sourceCity=new ArrayList<String>();
        destCity=new ArrayList<String>();
        status=new ArrayList<String>();
        runningDays=new ArrayList<String>();
        arrtime=new ArrayList<String>();
        depttime=new ArrayList<String>();




        Connections conn = new Connections(NameSearch.this, "http://192.168.1.100:80/keshav/byname.php",getIntent().getExtras().getString("name"));
conn.sendRequestForName();



    }
   /* public void saveval(String valueToSave)
    {
        SharedPreferences sp91 = getSharedPreferences("grossinfo", MODE_PRIVATE);
        SharedPreferences.Editor ed11 = sp91.edit();
        ed11.putString("res", valueToSave);
        ed11.commit();
    }*/

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onStop() {super.onStop();
      /*  SaveVal sv=new SaveVal(this);
        sv.clearval();*/
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }
}
