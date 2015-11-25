package com.example.keshavjha.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Adapters.RecyclerAdapter;
import UriFile.Connections;

public class BetweenStations extends AppCompatActivity {
    public RecyclerView rv;

    EditText stA,stB;
    TextView tv;
    Button get;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_between_stations);
stA=(EditText)findViewById(R.id.stationA);
        tv=(TextView)findViewById(R.id.theader);

        stB=(EditText)findViewById(R.id.stationB);
        get=(Button)findViewById(R.id.button);

        rv = (RecyclerView) findViewById(R.id.rv1);


        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(stA.getText().toString()+" and "+stB.getText().toString());
                Connections conn = new Connections(BetweenStations.this, "http://192.168.1.100:80/keshav/betweenstations.php",stA.getText().toString(),stB.getText().toString());
                conn.betweenTrains();


                stA.getText().clear();
                stB.getText().clear();
            }
        });





        //LinearLayoutManager lm = new LinearLayoutManager(this);

//lm.setOrientation(LinearLayoutManager.HORIZONTAL);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.between,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.item1)
        {
            Intent i=new Intent(BetweenStations.this,MapsActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }




}
