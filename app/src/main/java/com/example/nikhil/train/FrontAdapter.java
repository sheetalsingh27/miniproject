package com.example.nikhil.train;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class FrontAdapter extends BaseAdapter {
    Context c;
    List<String>trainVal;

    public FrontAdapter(Context c, List<String> trainVal) {
        this.c = c;
        this.trainVal = trainVal;
    }

    @Override
    public int getCount() {
        return trainVal.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater li=LayoutInflater.from(c);
        View v=li.inflate(R.layout.front_list_adapter, parent, false);
        TextView tv=(TextView)v.findViewById(R.id.trainInfo);
        tv.setText(trainVal.get(position));



        return v;
    }
}
