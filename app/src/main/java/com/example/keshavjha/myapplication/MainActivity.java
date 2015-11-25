package com.example.keshavjha.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import UriFile.Connections;
import UriFile.InternetConnectivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button numSearch, nameSearch;
    int train_num;
    List<String> li;
    List<Integer> li1;

    String res;


    MultiAutoCompleteTextView auto, auto1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auto = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);
        auto1 = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView2);
        li = new ArrayList<String>();
        li1 = new ArrayList<Integer>();


        numSearch = (Button) findViewById(R.id.numSearch);
        nameSearch = (Button) findViewById(R.id.nameSearch);
        numSearch.setOnClickListener(this);
        nameSearch.setOnClickListener(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        checkInternet();
        add();
        add1();


    }

    private void checkInternet() {
        InternetConnectivity ic = new InternetConnectivity(this);
        if (!ic.isConnectingToInternet()) {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setIcon(R.mipmap.alert);
            adb.setMessage("Do you want to turn on Internet");
            adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.setClassName("com.android.phone", "com.android.phone.NetworkSetting");
                    startActivity(intent);
                }
            });

            adb.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            adb.setCancelable(false);
            adb.show();

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nameSearch:
                /*SharedPreferences sp9 = getSharedPreferences("grossinfo", MODE_PRIVATE);
                SharedPreferences.Editor ed = sp9.edit();
                ed.putString("res", " ");
                ed.commit();*/

                Intent i1 = new Intent(MainActivity.this, NameSearch.class);
                i1.putExtra("name", auto1.getText().toString());

                startActivity(i1);
                auto1.getText().clear();
                break;
            case R.id.numSearch:

               /* SharedPreferences sp91 = getSharedPreferences("grossinfo", MODE_PRIVATE);
                SharedPreferences.Editor ed1 = sp91.edit();
                ed1.putString("res", " ");
                ed1.commit();*/

                Intent i2 = new Intent(MainActivity.this, NumSearch.class);
                i2.putExtra("number", auto.getText().toString());
                startActivity(i2);
                auto.getText().clear();
                break;
            default:
                break;
        }
    }


    private void add() {
        // TODO Auto-generated method stub


        li1.add(13214);
        ArrayAdapter<Integer> adp = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_dropdown_item_1line, li1);

        adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        auto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        auto.setThreshold(1);
        auto.setAdapter(adp);
        auto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                auto.setSelection(position);
                train_num = (int) parent.getItemAtPosition(position);
            }
        });
    }

    private void add1() {
        // TODO Auto-generated method stub
        li.add("mumbai");
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, li);

        adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        auto1.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        auto1.setThreshold(1);
        auto1.setAdapter(adp);
        auto1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                auto1.setSelection(position);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.item1)
        {
            Intent i=new Intent(MainActivity.this,BetweenStations.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
