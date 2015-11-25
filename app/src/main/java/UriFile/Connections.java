package UriFile;

import android.support.v7.widget.StaggeredGridLayoutManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.keshavjha.myapplication.BetweenStations;
import com.example.keshavjha.myapplication.NameSearch;
import com.example.keshavjha.myapplication.NumSearch;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Adapters.NumAdapter;
import Adapters.RecyclerAdapter;

/**
 * Created by KESHAV JHA on 11/18/2015.
 */
public class Connections {

    NameSearch ns;
    NumSearch nus;
    BetweenStations bs;
    List<String> tname;
    List<String> tnumber;
    List<String> status;
    List<String> arrtime;
    List<String> depttime;
    List<String> dest;
    List<String> source;
    List<String> rdays;
    String res = " ", abc, acb;
    public String url, url1, url11, train_name, train_number, trainA, trainB;
    public String res_from_server;

    public Connections(NameSearch ns, String url, String train_name) {

        this.url = url;
        this.train_name = train_name;
        this.ns = ns;


    }

    public Connections(BetweenStations bs, String url11, String trainA, String trainB) {

        this.url11 = url11;
        this.trainA = trainA;
        this.bs = bs;
        this.trainB = trainB;


    }


    public Connections(NumSearch c, String url1, String train_number) {
        this.nus = c;
        this.url1 = url1;
        this.train_number = train_number;


    }


    public String sendRequestForName() {
        res = " ";
        RequestQueue rq = Volley.newRequestQueue(ns);
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        res_from_server = response;
                        res = parseJsonForName(res_from_server);

                        //  Toast.makeText(c.getApplicationContext(),gv, Toast.LENGTH_SHORT).show();
                        String strarr[] = res.split("\\.");
                        String nu = strarr[0].replace("\\", " ");
                        nu.trim();

                        String na = strarr[2].replace("\\", " ");
                        na.trim();

                        String so = strarr[1].replace("\\", " ");
                        so.trim();

                        String de = strarr[3].replace("\\", " ");
                        de.trim();
                        String st = strarr[4].replace("\\", " ");
                        st.trim();
                        String rd = strarr[5].replace("\\", " ");
                        rd.trim();

                        String at = strarr[6].replace("\\", " ");
                        at.trim();
                        String dt = strarr[7].replace("\\", " ");
                        dt.trim();


                        ns.trainNo.add(nu);

                        ns.trainName.add(na);

                        ns.status.add(st);

                        ns.sourceCity.add(so);

                        ns.destCity.add(de);

                        ns.runningDays.add(rd);

                        ns.arrtime.add(at);
                        ns.depttime.add(dt);

                        NumAdapter nm = new NumAdapter(ns, ns.trainName, ns.trainNo, ns.sourceCity, ns.destCity, ns.status, ns.runningDays, ns.arrtime, ns.depttime);
                        ns.lv.setAdapter(nm);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                res = error.getMessage();

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("train_name", train_name);

                return params;
            }
        };

        rq.add(postRequest);

        return res;


    }


    public String sendRequestForNumber() {
        res = " ";
        RequestQueue rq1 = Volley.newRequestQueue(nus);
        StringRequest postRequest = new StringRequest(Request.Method.POST, url1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        res_from_server = response;
                        res = parseJsonForName(res_from_server);

                        //  Toast.makeText(c.getApplicationContext(),gv, Toast.LENGTH_SHORT).show();
                        String strarr[] = res.split("\\.");
                        String nu = strarr[0].replace("\\", " ");
                        nu.trim();

                        String na = strarr[2].replace("\\", " ");
                        na.trim();

                        String so = strarr[1].replace("\\", " ");
                        so.trim();

                        String de = strarr[3].replace("\\", " ");
                        de.trim();
                        String st = strarr[4].replace("\\", " ");
                        st.trim();
                        String rd = strarr[5].replace("\\", " ");
                        rd.trim();

                        String at = strarr[6].replace("\\", " ");
                        at.trim();
                        String dt = strarr[7].replace("\\", " ");
                        dt.trim();


                        nus.trainNo.add(nu);

                        nus.trainName.add(na);

                        nus.status.add(st);

                        nus.sourceCity.add(so);

                        nus.destCity.add(de);

                        nus.runningDays.add(rd);

                        nus.arrtime.add(at);
                        nus.depttime.add(dt);

                        NumAdapter nm = new NumAdapter(nus, nus.trainName, nus.trainNo, nus.sourceCity, nus.destCity, nus.status, nus.runningDays, nus.arrtime, nus.depttime);
                        nus.lv.setAdapter(nm);


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                res = error.getMessage();

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("train_number", train_number);

                return params;
            }
        };

        rq1.add(postRequest);


        return res;


    }


    public String parseJsonForNumber(String Job) {
        try {
            JSONObject jjob = new JSONObject(Job);
            JSONArray jar = jjob.getJSONArray("res");
            for (int i = 0; i < jar.length(); i++) {
                JSONObject job1 = jar.getJSONObject(i);
                res = job1.getString("tnumber") + "\\." + job1.getString("source") + "\\." + job1.getString("tname") + "\\." + job1.getString("dest") + "\\." + job1.getString("status")
                        + "\\." + job1.getString("rdays") + "\\." + job1.getString("arrtime") + "\\." + job1.getString("depttime");


            }

        } catch (Exception e) {
            res = e.getMessage();
        }
        return res;
    }


    public String betweenTrains() {
        res = " ";

        RequestQueue rq1 = Volley.newRequestQueue(bs);
        StringRequest postRequest = new StringRequest(Request.Method.POST, url11,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        res_from_server = response;


                        tname = new ArrayList<>();
                        tnumber = new ArrayList<>();
                        status = new ArrayList<>();
                        arrtime = new ArrayList<>();
                        depttime = new ArrayList<>();
                        dest = new ArrayList<>();
                        source = new ArrayList<>();
                        rdays = new ArrayList<>();

                        res = parseJsonBetweenStations(res_from_server);
                        RecyclerAdapter rad = new RecyclerAdapter(bs, tname,
                                tnumber,
                                status,
                                arrtime,
                                depttime,
                                rdays);

                        StaggeredGridLayoutManager lm = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL);

                        bs.rv.setLayoutManager(lm);
                        bs.rv.setHasFixedSize(true);
                        bs.rv.setAdapter(rad);


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                res = error.getMessage();

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("trainA", trainA);
                params.put("trainB", trainB);
                return params;
            }
        };

        rq1.add(postRequest);


        return res;


    }


    public String parseJsonBetweenStations(String Job) {
        try {
            JSONObject jjob = new JSONObject(Job);
            JSONArray jar = jjob.getJSONArray("res");
            for (int i = 0; i < jar.length(); i++) {
                JSONObject job1 = jar.getJSONObject(i);
                res = job1.getString("tinfo");
                /*res = job1.getString("tnumber") + "\\." + job1.getString("source") + "\\." + job1.getString("tname") + "\\." + job1.getString("dest") + "\\." + job1.getString("status")
                        + "\\." + job1.getString("rdays") + "\\." + job1.getString("arrtime") + "\\." + job1.getString("depttime");*/

                tname.add(job1.getString("tname"));
                tnumber.add(job1.getString("tnumber"));
                status.add(job1.getString("status"));
                arrtime.add(job1.getString("arrtime"));
                depttime.add(job1.getString("depttime"));
                dest.add(job1.getString("dest"));
                source.add(job1.getString("source"));
                rdays.add(job1.getString("rdays"));
            }

        } catch (Exception e) {
            res = e.getMessage();
        }
        return res;
    }


    public String parseJsonForName(String Job) {
        try {
            JSONObject jjob = new JSONObject(Job);
            JSONArray jar = jjob.getJSONArray("res");
            for (int i = 0; i < jar.length(); i++) {
                JSONObject job1 = jar.getJSONObject(i);
                res = job1.getString("tnumber") + "\\." + job1.getString("source") + "\\." + job1.getString("tname") + "\\." + job1.getString("dest") + "\\." + job1.getString("status")
                        + "\\." + job1.getString("rdays") + "\\." + job1.getString("arrtime") + "\\." + job1.getString("depttime");


            }

        } catch (Exception e) {
            res = e.getMessage();
        }
        return res;
    }


}
