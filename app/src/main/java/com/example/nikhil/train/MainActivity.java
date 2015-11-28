package com.example.nikhil.train;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    EditText tnum;
    Button search,rmap;
    ListView lv;
    List<String> infoList;
    BufferedReader rd;
    StringBuilder sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tnum = (EditText) findViewById(R.id.trainNumber);
        search = (Button) findViewById(R.id.button2);
        rmap = (Button) findViewById(R.id.button3);
        lv = (ListView) findViewById(R.id.listView);
        rmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iw=new Intent(MainActivity.this,MapsActivity.class);
                iw.putExtra("tnumber",tnum.getText().toString());
                startActivity(iw);
            }
        });
        infoList = new ArrayList<>();

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {



                } catch (Exception e) {

                }
            }
        });


    }


    public class Task extends AsyncTask<String, Void, String> {

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL("http://api.railwayapi.com/route/train/" + params[0] + "/apikey/hyzjf4954/");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();

                rd = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                sb = new StringBuilder();
                String line = null;
                while ((line = rd.readLine()) != null) {
                    sb.append(line + "\n");
                }





                //  String response = new ApiCal(TrainRoutes.this).execute("http://api.railwayapi.com/route/train/" + tnu.getText().toString() + "/apikey/cfpwq4935/").get();


            } catch (Exception e) {

            }
            return sb.toString();


        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item1) {
            Intent i = new Intent(MainActivity.this, BetweenStations.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
