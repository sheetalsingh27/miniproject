package com.example.nikhil.train;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BetweenStations extends AppCompatActivity {

    String val=" ";
    EditText stA, stB;
    TextView tv;
    Button get;
    StringBuilder sb;
    BufferedReader rd;


    public List<String> city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_between_stations);
        stA = (EditText) findViewById(R.id.stationA);
        tv = (TextView) findViewById(R.id.inform);
        city = new ArrayList<>();
        stB = (EditText) findViewById(R.id.stationB);
        get = (Button) findViewById(R.id.button);


        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {


                    String res = new Task().execute(stA.getText().toString(),stB.getText().toString() ).get();




                    JSONObject jsonObject = new JSONObject(res);

                    JSONArray jsonArray = jsonObject.getJSONArray("train");
                    StringBuilder sb2 = new StringBuilder();
                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        val=val+"Destination Arrival Time:  "+
                                jsonObject1.getString("dest_arrival_time") + "\nSource Arrival Time:  " +
                                jsonObject1.getString("src_departure_time") + "\nTo:  "
                                + jsonObject1.getJSONObject("to").getString("name") + "\nFrom:  "
                                + jsonObject1.getJSONObject("from").getString("name") + "\nTrain Name:  " +
                                jsonObject1.getString("name") + "\nTrain Number:  " +
                                jsonObject1.getString("number")+"\n\n";


                    }
                    tv.setText(val);

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

                // http://api.railwayapi.com/between/source/"+ params[0]+"/dest/"+ params[1]+"/date/5-12-2015/apikey/hyzjf4954/
                URL url = new URL("http://api.railwayapi.com/between/source/" + params[0] + "/dest/" + params[1] + "/date/5-12-2015/apikey/hyzjf4954/");
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
}
