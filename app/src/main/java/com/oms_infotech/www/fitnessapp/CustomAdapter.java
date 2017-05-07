package com.oms_infotech.www.fitnessapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Himanshu on 3/26/2017.
 */

public class CustomAdapter extends BaseAdapter {
    ArrayList<String> nameid=new ArrayList<>();
    ArrayList<String> typeid=new ArrayList<>();
    ArrayList<String> calid=new ArrayList<>();
    LayoutInflater inflater;

    public CustomAdapter(Context context, ArrayList<String> name, ArrayList<String> type, ArrayList<String> cal) {
        nameid=name;
        typeid=type;
        calid=cal;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public class Holder
    {
        TextView tvname;
        TextView tvtype;
        TextView tvcal;
    }

    @Override
    public int getCount() {
        return nameid.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder=new Holder();
        view=inflater.inflate(R.layout.model,null);

        holder.tvname=(TextView) view.findViewById(R.id.tvname);
        holder.tvtype=(TextView)view.findViewById(R.id.tvtype);
        holder.tvcal=(TextView)view.findViewById(R.id.tvcalories);

        holder.tvname.setText(nameid.get(i));
        holder.tvtype.setText(typeid.get(i));
        holder.tvcal.setText("Calories : "+calid.get(i));

        return view;
    }
}
