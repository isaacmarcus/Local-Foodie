package com.example.zwanzigdrei.localfoodie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class secondpage extends AppCompatActivity {
    static String intent;
    ImageView imagetobeset;
    TextView cost;
    TextView hours;
    TextView information;
    Button gotomapbtn;
//    View current;

    private MainActivity.LocJsonData[] locJsonData = MainActivity.locJsonData;      // Original json list


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondpage);
        imagetobeset = findViewById(R.id.imagetobeset);
        cost = findViewById(R.id.cost);
        hours = findViewById(R.id.hours);
        information = findViewById(R.id.information);
        gotomapbtn = findViewById(R.id.nextpagebutton);
        intent = getIntent().getAction();

        this.setTitle(intent);

        for (int i = 0; i<locJsonData.length; i++) {
            if (intent.matches(locJsonData[i].location)) {
                String packageName = this.getPackageName();
                String typeOfResource = "drawable";
                int resID = this.getResources().getIdentifier(locJsonData[i].file,typeOfResource,packageName);
                cost.setText("Average cost per person: " + locJsonData[i].cost);
                hours.setText("Opening Hours: " + locJsonData[i].hours);
                information.setText(locJsonData[i].information);
                imagetobeset.setImageResource(resID);
                break;
            }
        }

    }

    public void gotomap(View view) {
        startActivity(new Intent(intent,null,this,OverallMap.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.Location){
            Fragment1 dFragment = new Fragment1();
            // Show DialogFragment
            dFragment.show(getSupportFragmentManager(), "Dialog Fragment");
        }
        return true;
    }

}
