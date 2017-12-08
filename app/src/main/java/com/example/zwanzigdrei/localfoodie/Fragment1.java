package com.example.zwanzigdrei.localfoodie;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

public class Fragment1 extends DialogFragment {
    View root;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_fragment1, container,false);
        root =rootView;
        getDialog().setTitle("Add Location");
        ((CheckBox)rootView.findViewById(R.id.Bedok85)).setChecked(Function2Activity.map.getBoolean("Bedok 85",false));
        ((CheckBox)rootView.findViewById(R.id.BedokSimpang)).setChecked(Function2Activity.map.getBoolean("Simpang Bedok",false));
        ((CheckBox)rootView.findViewById(R.id.ChangiVillageHawkerCentre)).setChecked(Function2Activity.map.getBoolean("Changi Village",false));
        ((CheckBox)rootView.findViewById(R.id.ChinatownFoodStreet)).setChecked(Function2Activity.map.getBoolean("Chinatown Food Street",false));
        ((CheckBox)rootView.findViewById(R.id.Chompchomp)).setChecked(Function2Activity.map.getBoolean("Chomp Chomp",false));
        ((CheckBox)rootView.findViewById(R.id.HongLimFoodCentre)).setChecked(Function2Activity.map.getBoolean("Hong Lim Food Centre",false));
        ((CheckBox)rootView.findViewById(R.id.LauPaSat)).setChecked(Function2Activity.map.getBoolean("Lau Pa Sat",false));
        ((CheckBox)rootView.findViewById(R.id.MaxwellFoodCentre)).setChecked(Function2Activity.map.getBoolean("Maxwell Food Centre",false));
        ((CheckBox)rootView.findViewById(R.id.NewtonFoodCentre)).setChecked(Function2Activity.map.getBoolean("Newton Food Centre",false));
        ((CheckBox)rootView.findViewById(R.id.TampinesRoundMarket)).setChecked(Function2Activity.map.getBoolean("Tampines Round Market",false));
        // Do something else
        root.findViewById(R.id.Bedok85).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
        root.findViewById(R.id.BedokSimpang).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {update();
            }
        });
        root.findViewById(R.id.ChangiVillageHawkerCentre).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {update();
            }
        });
        root.findViewById(R.id.ChinatownFoodStreet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {update();
            }
        });
        root.findViewById(R.id.Chompchomp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
        root.findViewById(R.id.HongLimFoodCentre).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {update();
            }
        });
        root.findViewById(R.id.LauPaSat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
        root.findViewById(R.id.MaxwellFoodCentre).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {update();
            }
        });
        root.findViewById(R.id.NewtonFoodCentre).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {update();
            }
        });
        root.findViewById(R.id.TampinesRoundMarket).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {update();
            }
        });

        return rootView;
    }
    public void update(){
        Function2Activity.editor.putBoolean("Bedok 85",((CheckBox)root.findViewById(R.id.Bedok85)).isChecked());
        Function2Activity.editor.putBoolean("Simpang Bedok",((CheckBox)root.findViewById(R.id.BedokSimpang)).isChecked());
        Function2Activity.editor.putBoolean("Changi Village",((CheckBox)root.findViewById(R.id.ChangiVillageHawkerCentre)).isChecked());
        Function2Activity.editor.putBoolean("Chinatown Food Street",((CheckBox)root.findViewById(R.id.ChinatownFoodStreet)).isChecked());
        Function2Activity.editor.putBoolean("Chomp Chomp",((CheckBox)root.findViewById(R.id.Chompchomp)).isChecked());
        Function2Activity.editor.putBoolean("Hong Lim Food Centre",((CheckBox)root.findViewById(R.id.HongLimFoodCentre)).isChecked());
        Function2Activity.editor.putBoolean("Lau Pa Sat",((CheckBox)root.findViewById(R.id.LauPaSat)).isChecked());
        Function2Activity.editor.putBoolean("Maxwell Food Centre",((CheckBox)root.findViewById(R.id.MaxwellFoodCentre)).isChecked());
        Function2Activity.editor.putBoolean("Newton Food Centre",((CheckBox)root.findViewById(R.id.NewtonFoodCentre)).isChecked());
        Function2Activity.editor.putBoolean("Tampines Round Market",((CheckBox)root.findViewById(R.id.TampinesRoundMarket)).isChecked());
        Function2Activity.editor.commit();
    }
}
