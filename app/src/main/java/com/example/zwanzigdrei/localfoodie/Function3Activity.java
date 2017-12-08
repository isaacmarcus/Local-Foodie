package com.example.zwanzigdrei.localfoodie;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.widget.RecyclerView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;

public class Function3Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private RecyclerView locListRecycler;
    private LocListAdapter mAdapter;
    private MainActivity.LocJsonData[] locJsonData = MainActivity.locJsonData;      // Original json list
    EditText travelBudget; // Budget keyed in by user
    String selLoc;
    static SharedPreferences map;
    static SharedPreferences.Editor editor;

    Context parentContext;

    LinkedList<String> locListData = new LinkedList<>(); // ArrayList to hold locations keyed in

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.parentContext = this;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function3);

        map = this.getSharedPreferences("Locations",MODE_PRIVATE);
        editor= map.edit();
        // Binding layout items
        Spinner locSpinner = findViewById(R.id.locSpinner);
        travelBudget = findViewById(R.id.travelBudget);
        Button navMap = findViewById(R.id.btn_navigation);
        Button addLoc = findViewById(R.id.btn_StoreLoc);

        // OnCreate Spinner Lists
        locSpinner.setOnItemSelectedListener(this);
        List<String> locListSpinner = new ArrayList<>();
        for (int i = 0; i < locJsonData.length; i++) {
            locListSpinner.add(locJsonData[i].location);
        }
        ArrayAdapter<String> spinAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,locListSpinner);
        spinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locSpinner.setAdapter(spinAdapter);

        // OnCreate Recycler view
        locListRecycler = findViewById(R.id.recyclerViewLocs);
        mAdapter = new LocListAdapter(this,locJsonData,locListData);
        locListRecycler.setAdapter(mAdapter);
        locListRecycler.setLayoutManager(new LinearLayoutManager(this));



        //creating my linkedlist


        if(map.getBoolean("Bedok 85",false)){
            locListData.add("Bedok 85");
        }
        if(map.getBoolean("Simpang Bedok",false)){
            locListData.add("Simpang Bedok");
        }
        if(map.getBoolean("Changi Village",false)){
            locListData.add("Changi Village");
        }
        if(map.getBoolean("Chinatown Food Street",false)){
            locListData.add("Chinatown Food Street");
        }
        if(map.getBoolean("Chomp Chomp",false)){
            locListData.add("Chomp Chomp");
        }
        if(map.getBoolean("Hong Lim Food Centre",false)){
            locListData.add("Hong Lim Food Centre");
        }
        if(map.getBoolean("Lau Pa Sat",false)){
            locListData.add("Lau Pa Sat");
        }
        if(map.getBoolean("Maxwell Food Centre",false)){
            locListData.add("Maxwell Food Centre");
        }
        if(map.getBoolean("Newton Food Centre",false)){
            locListData.add("Newton Food Centre");
        }
        if(map.getBoolean("Tampines Round Market",false)){
            locListData.add("Tampines Round Market");
        }
        if(map.getBoolean("Singapore Flyer",false)){
            locListData.add("Singapore Flyer");
        }
        if(map.getBoolean("Vivo City",false)){
            locListData.add("Vivo City");
        }
        if(map.getBoolean("Resorts World Sentosa",false)){
            locListData.add("Resorts World Sentosa");
        }
        if(map.getBoolean("Buddha Temple",false)){
            locListData.add("Buddha Temple");
        }
        if(map.getBoolean("Singapore Zoo",false)){
            locListData.add("Singapore Zoo");
        }


    }

    public void onClickOptim(View v){ // Call back for to calculate optimal route for locations

        String budget = travelBudget.getText().toString().trim();

        if (locListData.size() < 6) { // Below 6 locations, using brute force is alright

            if (budget.isEmpty()) {
                budget = "0";
            }
            BruteAlgorithm bruteAlgorithm = new BruteAlgorithm(Double.parseDouble(budget),locListData);
            bruteAlgorithm.solve();

            List<String> routeList = bruteAlgorithm.optimal;
            String routeOut = "\n";
            for (int i = 0; i<routeList.size(); i++) {
                routeOut += (i+1) + ": " + routeList.get(i) + "\n";
            }

            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(parentContext ,R.style.LamTheme);
            } else {
                builder = new AlertDialog.Builder(parentContext );
            }
            builder.setTitle("Optimized Route")
                    .setMessage(bruteAlgorithm.getoptimal()+" minutes\n"+routeOut)
                    .setNeutralButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .show();

        } else { // 6 locations and more, we need to use a fast solver
            if (budget.isEmpty()) {
                budget = "0";
            }
            SimpleAlgorithm simpleAlgorithm = new SimpleAlgorithm(Double.parseDouble(budget),locListData);
            simpleAlgorithm.solve();

            List<String> routeList = simpleAlgorithm.solution;
            String routeOut = "\n";
            for (int i = 0; i<routeList.size(); i++) {
                routeOut += (i+1) + ": " + routeList.get(i) + "\n";
            }

            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(parentContext ,R.style.LamTheme);
            } else {
                builder = new AlertDialog.Builder(parentContext );
            }
            builder.setTitle("Optimized Route")
                    .setMessage(simpleAlgorithm.getoptimal()+" minutes\n"+routeOut)
                    .setNeutralButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .show();
        }
    }

    public void onClickAdd(View view) { //  Call back to add new location to itinerary list

        // Every time a location is added the RecyclerView is updated with the new location list
        if (!locListData.contains(selLoc)) {
            locListData.add(selLoc);
            editor.putBoolean(selLoc,true);
            editor.commit();
        } else {
            Toast.makeText(this, "Location already added", Toast.LENGTH_SHORT).show();
        }

        mAdapter = new LocListAdapter(this, locJsonData,locListData);
        locListRecycler.setAdapter(mAdapter);
        locListRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onClickDel(View view) { //  Call back to add new location to itinerary list

        // Every time a location is added the RecyclerView is updated with the new location list
        if (!locListData.contains(selLoc)) {
            Toast.makeText(this, "Location not in itinerary", Toast.LENGTH_SHORT).show();
        }
        editor.putBoolean(selLoc,false);
        editor.commit();
        locListData.remove(selLoc);

        mAdapter = new LocListAdapter(this, locJsonData,locListData);
        locListRecycler.setAdapter(mAdapter);
        locListRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        this.selLoc = parent.getItemAtPosition(position).toString();
        // Showing selected spinner item
//        Toast.makeText(parent.getContext(), "Selected: " + selLoc, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Do nothing
    }

}


