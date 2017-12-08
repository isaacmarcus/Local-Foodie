package com.example.zwanzigdrei.localfoodie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class Function2Activity extends AppCompatActivity{
//    static boolean Bedok85True,BedokSimpangTrue,ChangiTrue,ChinatownTrue,ChompChompTrue,HongLimTrue,LauPaSatTrue,MaxwellTrue,NewtonTrue,TampinesTrue;
    static SharedPreferences map;
    static SharedPreferences.Editor editor;
    FragmentManager fm = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        map = this.getSharedPreferences("Locations",MODE_PRIVATE);
        editor= map.edit();
        setContentView(R.layout.activity_function2);

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
            dFragment.show(fm, "Dialog Fragment");
        }
        return true;
    }

    public void Bedok85(View view) {startActivity(new Intent("Bedok 85",null,this,secondpage.class));
    }

    public void BedokSimpang(View view) {startActivity(new Intent("Simpang Bedok",null,this,secondpage.class));
    }

    public void ChangiVillage(View view) {startActivity(new Intent("Changi Village",null,this,secondpage.class));
    }

    public void Chinatown(View view) {startActivity(new Intent("Chinatown Food Street",null,this,secondpage.class));
    }

    public void ChompChomp(View view) {startActivity(new Intent("Chomp Chomp",null,this,secondpage.class));
    }

    public void HongLim(View view) {startActivity(new Intent("Hong Lim Food Centre",null,this,secondpage.class));
    }

    public void LauPaSat(View view) {startActivity(new Intent("Lau Pa Sat",null,this,secondpage.class));
    }

    public void Maxwell(View view) {startActivity(new Intent("Maxwell Food Centre",null,this,secondpage.class));
    }

    public void Newton(View view) {startActivity(new Intent("Newton Food Centre",null,this,secondpage.class));
    }

    public void Tampines(View view) {startActivity(new Intent("Tampines Round Market",null,this,secondpage.class));
    }


}
