package com.stivenduque.resistor;

/**
 * Created by stiven on 4/03/18.
 */

public class ColorSpinnerAdapterItem {
    int color;
    String name;

    public ColorSpinnerAdapterItem(int color, String name) {
        this.color = color;
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public String getDisplayName() {
        return name;
    }
}