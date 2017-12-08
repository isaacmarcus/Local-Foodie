package com.example.zwanzigdrei.localfoodie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    static LocJsonData[] locJsonData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // parseJson to parse items in json database
        parseJson();

    }


    public void ImageClick(View view){
        Intent nextActivityintent = new Intent(MainActivity.this, NextActivity.class);
        startActivity(nextActivityintent);
    }

    public class LocJsonData{ // Class objects for the Json file
        String location;
        String cost;
        String hours;
        String file;
        String information;
    }

    private String readTxt(int resource) {

        InputStream inputStream = getResources().openRawResource(resource);
        // take in a resource ID of a file
        String strLine;
        String outStr="";
        // read it and return it as a single string
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while ((strLine = reader.readLine()) != null) {
                outStr += strLine;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outStr;
    }

    void parseJson() {
        Gson gson = new Gson();
        // Invoke readTxt
        String jsonString = readTxt(R.raw.locations);
        // parse the JSON file using GSON
        locJsonData=gson.fromJson(jsonString,MainActivity.LocJsonData[].class);
    }
}