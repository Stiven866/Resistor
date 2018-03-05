package com.stivenduque.resistor;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

import static java.lang.Math.pow;

public class MainResistor extends AppCompatActivity {

    Spinner SpnC1,SpnC2,SpnC3,SpnC4;
    //Boton
    Button BtnCallIt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_resistor);
        BtnCallIt = findViewById(R.id.BtnCalculateIt);
        SpnC1 = findViewById(R.id.SpnColor1);
        SpnC2 = findViewById(R.id.SpnColor2);
        SpnC3 = findViewById(R.id.SpnColor3);
        SpnC4 = findViewById(R.id.SpnColor4);

        ArrayList<ColorSpinnerAdapterItem> colors = new ArrayList<ColorSpinnerAdapterItem>();
        colors.add(new ColorSpinnerAdapterItem(Color.parseColor("#000000"),"NEGRO"));
        colors.add(new ColorSpinnerAdapterItem(Color.parseColor("#795548"), "CAFE"));
        colors.add(new ColorSpinnerAdapterItem(Color.parseColor("#ff0000"), "RED" ));
        colors.add(new ColorSpinnerAdapterItem(Color.parseColor("#ffa500"), "NARANJA"));
        colors.add(new ColorSpinnerAdapterItem(Color.parseColor("#FFEB3B"), "AMARILLO"));
        colors.add(new ColorSpinnerAdapterItem(Color.parseColor("#008000"), "VERDE" ));
        colors.add(new ColorSpinnerAdapterItem(Color.parseColor("#2196F3"), "AZUL"));
        colors.add(new ColorSpinnerAdapterItem(Color.parseColor("#9400d3"), "MORAD0"));
        colors.add(new ColorSpinnerAdapterItem(Color.parseColor("#9E9E9E"), "GRIS" ));
        colors.add(new ColorSpinnerAdapterItem(Color.parseColor("#ffffff"), "BLANCO" ));

        ColorSpinnerAdapter colorSpinner = new ColorSpinnerAdapter(getApplicationContext(), R.layout.spinner_item, colors);
        SpnC1.setAdapter(colorSpinner);
        SpnC2.setAdapter(colorSpinner);
        SpnC3.setAdapter(colorSpinner);

        ArrayList<ColorSpinnerAdapterItem> colors2 = new ArrayList<ColorSpinnerAdapterItem>();
        colors2.add(new ColorSpinnerAdapterItem(Color.parseColor("#c0c0c0"),"PLATA"));
        colors2.add(new ColorSpinnerAdapterItem(Color.parseColor("#ffd700"), "ORO"));

        ColorSpinnerAdapter colorSpinner2 = new ColorSpinnerAdapter(getApplicationContext(),R.layout.spinner_item,colors2);
        SpnC4.setAdapter(colorSpinner2);


        BtnCallIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                ShowDialog("El Resultado es:",BuildNumber(SpnC1.getSelectedItemPosition(),SpnC2.getSelectedItemPosition(),
                        SpnC3.getSelectedItemPosition())+" "+GetTolerance(SpnC4.getSelectedItemPosition()));
            }
        });
    }

    private void ShowDialog(String Title, String Caption)
    {
        new AlertDialog.Builder(this)
                .setTitle(Title)
                .setMessage(Caption)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setIcon(android.R.drawable.ic_menu_info_details)
                .show();
    }
    private String GetTolerance(int Value)
    {
        if (Value == 0)
            return "+5% de tolerancia";
        else
            return "+10% de tolerancia";
    }

    private String BuildNumber(int Value1, int Value2, int Value3)
    {
        String Significant;

        Significant = Integer.toString(Value1) + Integer.toString(Value2);

        double Resultado = Integer.parseInt(Significant)*pow(10,Value3);

        if (Resultado/1000 >= 1 && Resultado/1e3 < 1000 )
        {
            return (String.valueOf(Resultado / 1e3) + "KΩ");
        }
        if (Resultado/1e6 >= 1)
        {
            return (String.valueOf(Resultado / 1e6) + "MΩ");
        }else{
            return (String.valueOf(Resultado)+"Ω");
        }
    }
}
