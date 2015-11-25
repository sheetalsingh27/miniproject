package Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.keshavjha.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by keshav on 11/6/2015.
 */


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context c;

    List<String> tname;
    List<String> tnumber;
    List<String> status;
    List<String> arrtime;
    List<String> depttime;

    List<String> rdays;

    public RecyclerAdapter(Context c, List<String> tname, List<String> tnumber, List<String> status, List<String> arrtime, List<String> depttime, List<String> rdays) {
        this.c = c;
        this.tname = tname;
        this.tnumber = tnumber;
        this.status = status;
        this.arrtime = arrtime;
        this.depttime = depttime;

        this.rdays = rdays;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View v = li.inflate(R.layout.recycler_layout, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tname.setText(tname.get(position));
        holder.tnumber.setText(tnumber.get(position));
        holder.rdays.setText(rdays.get(position));
        holder.depttime.setText(depttime.get(position));
        holder.arrtime.setText(arrtime.get(position));

        holder.status.setText(status.get(position));

    }

    @Override
    public int getItemCount() {
        return tname.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tname, tnumber, status, arrtime, depttime, rdays;

        public ViewHolder(View itemView) {
            super(itemView);
            tname = (TextView) itemView.findViewById(R.id.tname);
            tnumber = (TextView) itemView.findViewById(R.id.tnumber);
            status = (TextView) itemView.findViewById(R.id.status);

            arrtime = (TextView) itemView.findViewById(R.id.arrtime);
            depttime = (TextView) itemView.findViewById(R.id.depttime);
            rdays = (TextView) itemView.findViewById(R.id.rdays);
        }


    }


}
