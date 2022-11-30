package com.example.listview;

import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    LayoutInflater inflater;
    int count;

    public Adapter(LayoutInflater inflater,int count) {
        this.inflater = inflater;
        this.count = count;
    }

    @Override
    public int getCount() {
        return count;
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
    public View getView(int position, View v, ViewGroup parent) {

       v = inflater.inflate(R.layout.list_item,parent,false);

        ImageView image = v.findViewById(R.id.image);
        TextView tv1 = v.findViewById(R.id.tv1);
        TextView tv2 = v.findViewById(R.id.tv2);


        TypedArray arrResId = v.getResources().obtainTypedArray(R.array.countries);
        TypedArray nara = v.getResources().obtainTypedArray(R.array.nara);
        TypedArray englishname = v.getResources().obtainTypedArray(R.array.englishname);


        image.setImageResource(arrResId.getResourceId(position, 0));
       tv1.setText(nara.getText(position));
       tv2.setText(englishname.getText(position));

       //tv1.setText(list.get(position).getName_k());
       //tv2.setText(list.get(position).getName_e());

        return v;
    }
}
