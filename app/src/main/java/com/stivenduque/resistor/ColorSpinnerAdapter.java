package com.stivenduque.resistor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by stiven on 4/03/18.
 */

public class ColorSpinnerAdapter extends ArrayAdapter<ColorSpinnerAdapterItem> implements SpinnerAdapter {
    private ArrayList<ColorSpinnerAdapterItem> colors; // android.graphics.Color list
    //private Context context;

    public ColorSpinnerAdapter(Context context, int textViewResourceId, ArrayList<ColorSpinnerAdapterItem> colors) {
        super(context, textViewResourceId, colors);

        this.colors = colors;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        super.getDropDownView(position, convertView, parent);
        if (convertView == null) {
            convertView = View.inflate(getContext(), android.R.layout.simple_list_item_1, null);
        }
        TextView tv = convertView.findViewById(android.R.id.text1);
        tv.setBackgroundColor(colors.get(position).getColor());
        tv.setText(colors.get(position).getDisplayName());
        return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(android.R.layout.simple_list_item_1, null);
        }
        TextView tv = (TextView) view.findViewById(android.R.id.text1);
        tv.setBackgroundColor(colors.get(position).getColor());
        tv.setText(colors.get(position).getDisplayName());
        return view;
    }
}