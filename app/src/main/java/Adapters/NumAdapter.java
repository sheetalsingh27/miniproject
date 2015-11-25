package Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.keshavjha.myapplication.R;

import java.util.List;

/**
 * Created by KESHAV JHA on 11/18/2015.
 */
public class NumAdapter extends BaseAdapter {
    Context c;
    List<String> trainNo, trainName, sourceCity, destCity, status, runningDays, arrtime, depttime;

    public NumAdapter(Context c, List<String> trainName, List<String> trainNo, List<String> sourceCity, List<String> destCity, List<String> status, List<String> runningDays, List<String> arrtime, List<String> depttime) {
        this.c = c;
        this.destCity = destCity;
        this.trainName = trainName;
        this.trainNo = trainNo;
        this.sourceCity = sourceCity;
        this.status = status;
        this.runningDays = runningDays;
        this.arrtime = arrtime;
        this.depttime = depttime;
    }

    @Override
    public int getCount() {
        return trainName.size();
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
        LayoutInflater li = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = li.inflate(R.layout.list_adapter, parent, false);
        // CardView cv1=(CardView)v.findViewById(R.id.cv1);
        // CardView cv2=(CardView)v.findViewById(R.id.cv2);
        TextView tname = (TextView) v.findViewById(R.id.trainNaam);
        TextView tnum = (TextView) v.findViewById(R.id.trainNum);
        TextView tsource = (TextView) v.findViewById(R.id.source);
        TextView tdest = (TextView) v.findViewById(R.id.dest);
        TextView tstatus = (TextView) v.findViewById(R.id.status);
        TextView trdays = (TextView) v.findViewById(R.id.rdays);
        TextView arrt = (TextView) v.findViewById(R.id.arrtime);
        TextView deptti = (TextView) v.findViewById(R.id.depttime1);

        tname.setText(trainName.get(position));
        tnum.setText(trainNo.get(position));
        tsource.setText(sourceCity.get(position));
        tdest.setText(destCity.get(position));
        tstatus.setText(status.get(position));
        trdays.setText(runningDays.get(position));
        arrt.setText(arrtime.get(position));
        deptti.setText(depttime.get(position));

        return v;
    }
}
